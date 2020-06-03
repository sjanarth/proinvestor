package com.proinvestor.dataprovider;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Data
@RequiredArgsConstructor
public abstract class AbstractBaseDataProvider
{
    protected enum DataFormat   {
        XML,
        HTML,
    }

    protected void refresh()    {
        if (document == null) {
            fetchDocument();
            parseDocument();
        }
    }
    protected void fetchDocument()   {
        try {
            log.info("Fetching "+dataProviderUrl);
            Instant start = Instant.now();
            switch (dataFormat) {
                case HTML:
                    document = Jsoup.connect(dataProviderUrl).parser(Parser.htmlParser()).get();
                    break;
                case XML:
                    document = Jsoup.connect(dataProviderUrl).parser(Parser.xmlParser()).get();
            }
            Instant end = Instant.now();
            log.info("Completed fetching in "+ Duration.between(start, end));
        } catch (IOException e) {
            log.error("", e);
        }
    }

    protected abstract void parseDocument();

    protected Double parseElement (Element element)   {
        Double curVal = 0.0;
        try {
            String text = element.text()
                            .replaceAll("\\$", "")
                            .replaceAll(",", "")
                            .replaceAll("\n", "");

            curVal = Double.parseDouble(text);
        } catch (NumberFormatException e)   {
            log.error("", e);
        }
        return curVal;
    }

    @NonNull
    protected String dataProviderUrl;

    @NonNull
    protected DataFormat dataFormat;

    protected Document document = null;
    protected Map<String,Double> data = new ConcurrentHashMap<>();
}