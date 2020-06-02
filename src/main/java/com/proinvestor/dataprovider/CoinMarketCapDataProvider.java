package com.proinvestor.dataprovider;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@Slf4j
public class CoinMarketCapDataProvider extends AbstractMultiDataProvider
{
    public static final String BITCOIN_PRICE = "#cmc.btc";
    public static final String ETHEREUM_PRICE = "#cmc.eth";

    public CoinMarketCapDataProvider() {
        super("https://coinmarketcap.com/");
    }

    @Override
    protected void parseDocument() {
        Elements elements = document.select("tr.cmc-table-row > td.cmc-table__cell");
        Element btc = elements.get(3);
        data.put(BITCOIN_PRICE, parseElement(btc));
        Element eth = elements.get(12);
        data.put(ETHEREUM_PRICE, parseElement(eth));
    }
}