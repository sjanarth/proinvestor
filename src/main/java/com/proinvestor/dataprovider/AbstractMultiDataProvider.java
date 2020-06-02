package com.proinvestor.dataprovider;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Data
@RequiredArgsConstructor
public abstract class AbstractMultiDataProvider implements MultiDataProvider
{
    @Override
    public double fetchCurrentValue(String key) {
        if (document == null) {
            fetchDocument();
            parseDocument();
            //document.remove();
            //document = null;
        }
        return data.get(key);
    }

    protected abstract void parseDocument();

    protected Double parseElement (Element element)   {
        Double curVal = (double) 0;
        try {
            curVal = Double.parseDouble((element.text().substring(1)).replaceAll(",", ""));
            log.info("curVal = "+curVal);
        } catch (NumberFormatException e)   {
            log.error("", e);
        }
        return curVal;
    }

    private void fetchDocument()   {
        try {
            log.info("Fetching "+dataProviderUrl);
            Instant start = Instant.now();
            document = Jsoup.connect(dataProviderUrl).get();
            Instant end = Instant.now();
            log.info("Completed fetching in "+ Duration.between(start, end));
        } catch (IOException e) {
            log.error("", e);
        }
    }

    @NonNull
    private String dataProviderUrl;

    protected Document document = null;

    protected Map<String,Double> data = new ConcurrentHashMap<>();
}