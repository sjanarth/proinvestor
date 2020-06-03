package com.proinvestor.dataprovider;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.select.Elements;

@Slf4j
public class ZillowDataProvider extends AbstractSimpleDataProvider
{
    public ZillowDataProvider(@NonNull String dataProviderUrl) {
        super(dataProviderUrl, DataFormat.HTML);
    }

    @Override
    protected void parseDocument() throws NumberFormatException {
        Elements elements = document.select("div.zestimate-value");
        double curValue = parseElement(elements.first());
        log.info("curValue = "+curValue);
        data.put(getKey(), curValue);
    }
}
