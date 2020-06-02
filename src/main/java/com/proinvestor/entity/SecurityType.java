package com.proinvestor.entity;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum SecurityType
{
    EQUITY("Equity"),
    MF("Mutual Fund"),
    MF_ET("Exchange Traded Fund"),
    MF_ULIP("Unite Linked Investment Plan"),
    MF_ELSS("Equity Linked Savings Scheme"),
    COD("Certificate of Deposit"),
    BOND("Bonds"),
    CASH("Cash"),
    RETIREMENT_401K("Retirement - 401K"),
    RETIREMENT_IRA("Retirement - IRA"),
    RETIREMENT_PF("Retirement - Provident Fund"),
    BULLION("Bullion"),
    REAL_ESTATE("Real Estate"),
    FOREX("Foreign Exchange"),
    CRYPTO("Crypto Currency"),
    COMMODITY("Commodity");

    private String name;
}