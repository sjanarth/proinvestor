package com.proinvestor.dataprovider;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

@Slf4j
public class RedfinDataProvider extends AbstractSimpleDataProvider
{
    public RedfinDataProvider(@NonNull String dataProviderUrl) {
        super(dataProviderUrl);
    }

    @Override
    protected double parseData(Document doc) throws NumberFormatException   {
        Elements elements = doc.select("div.statsValue");
        String text = elements.first().text();
        double curValue = Double.parseDouble(text.substring(1).replaceAll(",", ""));
        log.info("curValue = "+curValue);
        return curValue;
    }
}