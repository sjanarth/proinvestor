package com.proinvestor.dataprovider;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.select.Elements;

@Slf4j
public class ZillowXmlDataProvider extends AbstractSimpleDataProvider
{
   public ZillowXmlDataProvider(@NonNull String dataProviderUrl) {
        super(dataProviderUrl, DataFormat.XML);
    }

    @Override
    protected void parseDocument() {
        Elements elements = document.select("zestimate > amount");
        double curValue = parseElement(elements.first());
        log.info("curValue = "+curValue);
        data.put(getKey(), curValue);
    }
}
