package com.proinvestor.dataprovider;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.select.Elements;

@Slf4j
public class ApmexDataProvider extends AbstractMultiDataProvider
{
    public static final String GOLD_PRICE = "#apmex.gold";
    public static final String SILVER_PRICE = "#apmex.silver";
    public static final String PLATINUM_PRICE = "#apmex.platinum";
    public static final String PALLADIUM_PRICE = "#apmex.palladium";

    public ApmexDataProvider() {
        super("http://www.apmex.com", DataFormat.HTML);
    }

    @Override
    protected void parseDocument() {
        Elements elements = document.select("div.price > span.current");
        Double curValue = parseElement(elements.get(0));
        log.info("Gold Price = "+curValue);
        data.put(GOLD_PRICE, curValue);
        curValue = parseElement(elements.get(1));
        log.info("Silver Price = "+curValue);
        data.put(SILVER_PRICE, curValue);
        curValue = parseElement(elements.get(2));
        log.info("Platinum Price = "+curValue);
        data.put(PLATINUM_PRICE, curValue);
        curValue = parseElement(elements.get(3));
        log.info("Palladium Price = "+curValue);
        data.put(PALLADIUM_PRICE, curValue);
    }
}