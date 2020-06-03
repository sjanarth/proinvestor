package com.proinvestor.dataprovider;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@Slf4j
public class ECBDataProvider extends AbstractMultiDataProvider
{
    public static final String USD = "#ecb.usd";
    public static final String JPY = "#ecb.jpy";
    public static final String GBP = "#ecb.gbp";
    public static final String CHF = "#ecb.chf";
    public static final String AUD = "#ecb.aud";
    public static final String CAD = "#ecb.cad";
    public static final String CNY = "#ecb.CNY";
    public static final String HKD = "#ecb.hkd";
    public static final String INR = "#ecb.inr";
    public static final String SGD = "#ecb.sgd";

    public ECBDataProvider() {
        super("https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml", DataFormat.XML);
    }

    @Override
    protected void parseDocument() {
        Elements elements = document.select("Cube[currency]");
        elements.forEach(this::parseElement);
    }

    @Override
    protected Double parseElement(Element element) {
        Double curValue = 0.0;
        try {
            String code = element.attr("currency");
            String rate = element.attr("rate");
            curValue = Double.parseDouble(rate);
            log.info(code+" = "+curValue);
            data.put("#ecb."+code.toLowerCase(), curValue);
        } catch (NumberFormatException e)   {
            log.error("", e);
        }
        return curValue;
    }
}