
package com.proinvestor.entity;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum TransactionType
{
    CASH_ADD("Cash - Addition"),
    CASH_MINUS("Cash - Withdrawal"),

    SECURITY_BUY("Security - Buy"),
    SECURITY_SELL("Security - Sell"),
    SECURITY_DIVIDEND("Security - Dividend"),
    SECURITY_SPLIT("Security - Split"),
    SECURITY_BONUS("Security - Bonus"),
    SECURITY_ROC("Security - Return of Capital");

    private String name;
}