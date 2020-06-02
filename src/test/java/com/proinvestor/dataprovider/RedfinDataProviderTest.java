package com.proinvestor.dataprovider;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class RedfinDataProviderTest
{
    @Rule
    public Timeout globalTimeout = Timeout.seconds(3);

    @Test
    public void testOneilTerrace()  {
        SimpleDataProvider dataProvider = new RedfinDataProvider("https://www.redfin.com/CA/Fremont/34164-Oneil-Ter-94555/home/1472892");
        double curValue = dataProvider.fetchCurrentValue();
        Assert.assertNotSame(0, curValue);
    }

    @Test
    public void testFinniganTerrace()   {
        SimpleDataProvider dataProvider = new RedfinDataProvider("https://www.redfin.com/CA/Fremont/34125-Finnigan-Ter-94555/home/1153230");
        double curValue = dataProvider.fetchCurrentValue();
        Assert.assertNotSame(0, curValue);
    }

    @Test
    public void testBrocktonLane()  {
        SimpleDataProvider dataProvider = new RedfinDataProvider("https://www.redfin.com/CA/Saratoga/19600-Brockton-Ln-95070/home/804143");
        double curValue = dataProvider.fetchCurrentValue();
        Assert.assertNotSame(0, curValue);

    }
}