package com.proinvestor.dataprovider;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class CoinMarketCapDataProviderTest
{
    @Rule
    public Timeout globalTimeout = Timeout.seconds(3);

    @Test
    public void testCrypto() {
        CoinMarketCapDataProvider dataProvider = new CoinMarketCapDataProvider();
        double btc = dataProvider.fetchCurrentValue(CoinMarketCapDataProvider.BITCOIN_PRICE);
        Assert.assertNotSame(0, btc);
        double eth = dataProvider.fetchCurrentValue(CoinMarketCapDataProvider.ETHEREUM_PRICE);
        Assert.assertNotSame(0, eth);
    }
}
