package com.proinvestor.entity;

import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class Account
{
    @NonNull
    private String id;

    @NonNull
    private String name;

    @NonNull
    private Collection<Holding> holdings = new ArrayList<>();

    public void refreshAllHoldings()    {
        holdings.forEach(Holding::refresh);
    }
}