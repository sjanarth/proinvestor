package com.proinvestor.dataprovider;

import lombok.NonNull;

public abstract class AbstractSimpleDataProvider extends AbstractBaseDataProvider implements SimpleDataProvider
{
    public AbstractSimpleDataProvider(@NonNull String dataProviderUrl, @NonNull DataFormat dataFormat) {
        super(dataProviderUrl, dataFormat);
    }

    @Override
    public double fetchCurrentValue()   {
        refresh();
        return data.get(getKey());
    }

    protected String getKey()   {
        return "#" + getClass() + "." + dataProviderUrl;
    }
}