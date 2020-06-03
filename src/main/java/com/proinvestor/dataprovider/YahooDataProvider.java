package com.proinvestor.dataprovider;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.select.Elements;

@Slf4j
public class YahooDataProvider extends AbstractSimpleDataProvider
{
    public YahooDataProvider(@NonNull String dataProviderUrl) {
        super(dataProviderUrl, DataFormat.HTML);
    }

    @Override
    protected void parseDocument() {
        Elements elements;
        if (dataProviderUrl.contains("p=^") || dataProviderUrl.split("=").length > 3) {
            // https://finance.yahoo.com/quote/%5ETNX?p=^TNX&.tsrc=fin-srch
            elements = document.select("span[data-reactid=33]");
        } else {
            // https://finance.yahoo.com/quote/AMZN?p=AMZN&.tsrc=fin-srch
            elements = document.select("span[data-reactid=50]");
        }
        double curValue = parseElement(elements.first());
        log.info("curValue = "+curValue);
        data.put(getKey(), curValue);
    }
}