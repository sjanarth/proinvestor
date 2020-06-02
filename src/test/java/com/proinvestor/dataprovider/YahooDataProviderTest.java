package com.proinvestor.dataprovider;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class YahooDataProviderTest
{
    @Rule
    public Timeout globalTimeout = Timeout.seconds(3);

    @Test
    public void testGSPC()  {
        YahooDataProvider dataProvider = new YahooDataProvider("https://finance.yahoo.com/quote/%5EGSPC?p=^GSPC&.tsrc=fin-srch");
        double curValue = dataProvider.fetchCurrentValue();
        Assert.assertNotSame(0, curValue);
    }

    @Test
    public void testDJI()  {
        YahooDataProvider dataProvider = new YahooDataProvider("https://finance.yahoo.com/quote/%5EDJI?p=^DJI&.tsrc=fin-srch");
        double curValue = dataProvider.fetchCurrentValue();
        Assert.assertNotSame(0, curValue);
    }

    @Test
    public void testTYX()  {
        YahooDataProvider dataProvider = new YahooDataProvider("https://finance.yahoo.com/quote/%5ETYX?p=^TYX&.tsrc=fin-srch");
        double curValue = dataProvider.fetchCurrentValue();
        Assert.assertNotSame(0, curValue);
    }

    @Test
    public void testTNX()  {
        YahooDataProvider dataProvider = new YahooDataProvider("https://finance.yahoo.com/quote/%5ETNX?p=^TNX&.tsrc=fin-srch");
        double curValue = dataProvider.fetchCurrentValue();
        Assert.assertNotSame(0, curValue);
    }

    @Test
    public void testVIX()  {
        YahooDataProvider dataProvider = new YahooDataProvider("https://finance.yahoo.com/quote/%5EVIX?p=^VIX&.tsrc=fin-srch");
        double curValue = dataProvider.fetchCurrentValue();
        Assert.assertNotSame(0, curValue);
    }

    @Test
    public void testBZF()  {
        YahooDataProvider dataProvider = new YahooDataProvider("https://finance.yahoo.com/quote/BZ=F?p=BZ=F&.tsrc=fin-srch");
        double curValue = dataProvider.fetchCurrentValue();
        Assert.assertNotSame(0, curValue);
    }
    @Test
    public void testGCF()  {
        YahooDataProvider dataProvider = new YahooDataProvider("https://finance.yahoo.com/quote/GC=F?p=GC=F&.tsrc=fin-srch");
        double curValue = dataProvider.fetchCurrentValue();
        Assert.assertNotSame(0, curValue);
    }
    @Test
    public void testSIF()  {
        YahooDataProvider dataProvider = new YahooDataProvider("https://finance.yahoo.com/quote/SI=F?p=SI=F&.tsrc=fin-srch");
        double curValue = dataProvider.fetchCurrentValue();
        Assert.assertNotSame(0, curValue);
    }
    @Test
    public void testINR()  {
        YahooDataProvider dataProvider = new YahooDataProvider("https://finance.yahoo.com/quote/INR=X?p=INR=X&.tsrc=fin-srch");
        double curValue = dataProvider.fetchCurrentValue();
        Assert.assertNotSame(0, curValue);
    }
    @Test
    public void testSGDINR()  {
        YahooDataProvider dataProvider = new YahooDataProvider("https://finance.yahoo.com/quote/SGDINR=X?p=SGDINR=X&.tsrc=fin-srch");
        double curValue = dataProvider.fetchCurrentValue();
        Assert.assertNotSame(0, curValue);
    }

    @Test
    public void testORCL()  {
        YahooDataProvider dataProvider = new YahooDataProvider("https://finance.yahoo.com/quote/ORCL?p=ORCL&.tsrc=fin-srch");
        double curValue = dataProvider.fetchCurrentValue();
        Assert.assertNotSame(0, curValue);
    }
}
