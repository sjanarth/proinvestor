package com.proinvestor.entity;

import com.proinvestor.dataprovider.SimpleDataProvider;
import lombok.Data;
import lombok.NonNull;

@Data
public class Holding extends Security
{
    @Override
    public void setQuantity(@NonNull double quantity) {
        super.setQuantity(quantity);
        updateGains();
    }

    @Override
    public void setCostPrice(@NonNull double unitPrice) {
        super.setCostPrice(unitPrice);
        updateGains();
    }

    @NonNull
    private double currentPrice;

    @NonNull
    private double gainNominal;

    @NonNull
    private double gainPercent;

    @NonNull
    private SimpleDataProvider dataProvider;

    private void updateGains()  {
        gainNominal = (currentPrice * getQuantity()) - (getCostPrice() * getQuantity());
        gainPercent = gainNominal / (getCostPrice() * getQuantity());
    }

    public void refresh ()  {
        currentPrice = dataProvider.fetchCurrentValue();
    }
}