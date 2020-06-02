package com.proinvestor.dataprovider;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class ZillowDataProviderTest
{
    @Rule
    public Timeout globalTimeout = Timeout.seconds(3);

    @Test
    public void testOnielTerrace()  {
        SimpleDataProvider dataProvider = new ZillowDataProvider("https://www.zillow.com/homes/34164-Oneil-Ter-Fremont,-CA,-94555_rb/25059163_zpid/");
        double curValue = dataProvider.fetchCurrentValue();
        Assert.assertNotSame(0, curValue);
    }

    @Test
    public void testFinniganTerrace()  {
        SimpleDataProvider dataProvider = new ZillowDataProvider("https://www.zillow.com/homedetails/34125-Finnigan-Ter-Fremont-CA-94555/25059153_zpid/");
        double curValue = dataProvider.fetchCurrentValue();
        Assert.assertNotSame(0, curValue);
    }
}