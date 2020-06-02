package com.proinvestor.entity;

import lombok.*;

import java.util.Currency;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Security
{
    @NonNull
    private String id;

    @NonNull
    private String name;

    @NonNull
    private SecurityType type;

    @NonNull
    private String subType;

    @NonNull
    private Currency currency;

    @NonNull
    private Date boughtOn;

    @NonNull
    private double quantity;

    @NonNull
    private double costPrice;
}