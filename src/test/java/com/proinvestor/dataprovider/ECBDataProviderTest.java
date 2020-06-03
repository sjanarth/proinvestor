package com.proinvestor.dataprovider;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class ECBDataProviderTest
{
    @Rule
    public Timeout globalTimeout = Timeout.seconds(5);

    @Test
    public void testCurrencies() {
        ECBDataProvider dataProvider = new ECBDataProvider();
        double gold = dataProvider.fetchCurrentValue(ECBDataProvider.USD);
        Assert.assertNotSame(0, gold);
    }
}
