package com.proinvestor.dataprovider;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class ApmexDataProviderText
{
    @Rule
    public Timeout globalTimeout = Timeout.seconds(5);

    @Test
    public void testMetals() {
        ApmexDataProvider dataProvider = new ApmexDataProvider();
        double gold = dataProvider.fetchCurrentValue(ApmexDataProvider.GOLD_PRICE);
        Assert.assertNotSame(0, gold);
        double silver = dataProvider.fetchCurrentValue(ApmexDataProvider.SILVER_PRICE);
        Assert.assertNotSame(0, silver);
        double platinum = dataProvider.fetchCurrentValue(ApmexDataProvider.PLATINUM_PRICE);
        Assert.assertNotSame(0, platinum);
        double palladium = dataProvider.fetchCurrentValue(ApmexDataProvider.PALLADIUM_PRICE);
        Assert.assertNotSame(0, palladium);
    }
}