package com.proinvestor.dataprovider;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class ZillowXmlDataProviderTest
{
    @Rule
    public Timeout globalTimeout = Timeout.seconds(3);

    @Test
    public void testOnielTerrace()  {
        SimpleDataProvider dataProvider = new ZillowXmlDataProvider("http://www.zillow.com/webservice/GetZestimate.htm?zws-id=X1-ZWz19x04cm4k5n_3pg0i&zpid=25059163");
        double curValue = dataProvider.fetchCurrentValue();
        Assert.assertNotSame(0, curValue);
    }

    @Test
    public void testFinniganTerrace()  {
        SimpleDataProvider dataProvider = new ZillowXmlDataProvider("http://www.zillow.com/webservice/GetZestimate.htm?zws-id=X1-ZWz19x04cm4k5n_3pg0i&zpid=25059153");
        double curValue = dataProvider.fetchCurrentValue();
        Assert.assertNotSame(0, curValue);
    }
}
