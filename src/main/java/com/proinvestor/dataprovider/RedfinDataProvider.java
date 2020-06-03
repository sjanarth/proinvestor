package com.proinvestor.dataprovider;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.select.Elements;

@Slf4j
public class RedfinDataProvider extends AbstractSimpleDataProvider
{
    public RedfinDataProvider(@NonNull String dataProviderUrl) {
        super(dataProviderUrl, DataFormat.HTML);
    }

    @Override
    protected void parseDocument() {
        Elements elements = document.select("div.statsValue");
        double curValue = parseElement (elements.first());
        log.info("curValue = "+curValue);
        data.put(getKey(), curValue);
    }
}