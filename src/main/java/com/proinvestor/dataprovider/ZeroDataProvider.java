package com.proinvestor.dataprovider;

public class ZeroDataProvider implements SimpleDataProvider
{
    @Override
    public double fetchCurrentValue() {
        return 0;
    }
}