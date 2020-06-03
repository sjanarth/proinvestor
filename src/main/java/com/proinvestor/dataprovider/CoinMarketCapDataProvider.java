package com.proinvestor.dataprovider;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.select.Elements;

@Slf4j
public class CoinMarketCapDataProvider extends AbstractMultiDataProvider
{
    public static final String BITCOIN_PRICE = "#cmc.btc";
    public static final String ETHEREUM_PRICE = "#cmc.eth";

    public CoinMarketCapDataProvider() {
        super("https://coinmarketcap.com/", DataFormat.HTML);
    }

    @Override
    protected void parseDocument() {
        Elements elements = document.select("tr.cmc-table-row > td.cmc-table__cell");
        Double curValue = parseElement(elements.get(3));
        log.info("BTC = "+curValue);
        data.put(BITCOIN_PRICE, curValue);
        curValue = parseElement(elements.get(12));
        log.info("ETH = "+curValue);
        data.put(ETHEREUM_PRICE, curValue);    }
}