package com.proinvestor.dataprovider;

import lombok.NonNull;

public abstract class AbstractMultiDataProvider extends AbstractBaseDataProvider implements MultiDataProvider
{
    public AbstractMultiDataProvider(@NonNull String dataProviderUrl, @NonNull DataFormat dataFormat) {
        super(dataProviderUrl, dataFormat);
    }

    @Override
    public double fetchCurrentValue(String key) {
        refresh();
        return data.get(key);
    }
}