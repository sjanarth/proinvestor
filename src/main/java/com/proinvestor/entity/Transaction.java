package com.proinvestor.entity;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
public class Transaction
{
    @NonNull
    private LocalDate transDate;

    @NonNull
    private Account account;

    @NonNull
    private TransactionType transType;

    private String transSubType = null;

    @NonNull
    private Security asset;

    @NonNull
    private double turnOver;

    private double fees = 0;
    private double tax = 0;
    private String comment = null;
}