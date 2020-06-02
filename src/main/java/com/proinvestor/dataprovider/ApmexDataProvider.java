package com.proinvestor.dataprovider;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@Slf4j
public class ApmexDataProvider extends AbstractMultiDataProvider
{
    public static final String GOLD_PRICE = "#apmex.gold";
    public static final String SILVER_PRICE = "#apmex.silver";
    public static final String PLATINUM_PRICE = "#apmex.platinum";
    public static final String PALLADIUM_PRICE = "#apmex.palladium";

    public ApmexDataProvider() {
        super("http://www.apmex.com");
    }

    @Override
    protected void parseDocument() {
        Elements elements = document.select("div.price > span.current");
        Element gold = elements.get(0);
        data.put(GOLD_PRICE, parseElement(gold));
        Element silver = elements.get(1);
        data.put(SILVER_PRICE, parseElement(silver));
        Element platinum = elements.get(2);
        data.put(PLATINUM_PRICE, parseElement(platinum));
        Element palladium = elements.get(3);
        data.put(PALLADIUM_PRICE, parseElement(palladium));
    }
}