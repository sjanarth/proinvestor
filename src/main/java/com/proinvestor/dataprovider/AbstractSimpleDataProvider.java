package com.proinvestor.dataprovider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

@Slf4j
@Data
@AllArgsConstructor
public abstract class AbstractSimpleDataProvider implements SimpleDataProvider
{
    protected abstract double parseData(Document doc) throws NumberFormatException;

    @Override
    public double fetchCurrentValue()   {
        try {
            log.info("Fetching "+dataProviderUrl);
            Instant start = Instant.now();
            Document doc = Jsoup.connect(dataProviderUrl).get();
            Instant end = Instant.now();
            log.info("Completed fetching in "+ Duration.between(start, end));
            return parseData(doc);
        } catch (IOException | NumberFormatException e) {
            log.error("", e);
            return 0;
        }
    }

    @NonNull
    protected String dataProviderUrl;
}