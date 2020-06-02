package com.proinvestor.entity;

import com.proinvestor.dataprovider.SimpleDataProvider;
import com.proinvestor.dataprovider.ZeroDataProvider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.Currency;

@Getter
@ToString
@AllArgsConstructor
public enum Index
{
    SP500("SP500", "Standard and Poor's 500 Index", SecurityType.EQUITY, "US", null, 0.0, new ZeroDataProvider()),
    DJIA("DJIA", "Down Jones Industrial Average", SecurityType.EQUITY, "US", null, 0.0, new ZeroDataProvider()),
    VIX("VIX", "CBOE Volatility Index", SecurityType.EQUITY, "US", null, 0.0, new ZeroDataProvider()),
    TNX("TNX", "CBOE 10 Year Treasury Note Yield Index", SecurityType.BOND, "US", null, 0.0, new ZeroDataProvider()),
    TYX("TYX", "CBOE 30 Year Treasury Note Yield Index", SecurityType.BOND, "US", null, 0.0, new ZeroDataProvider()),

    ORCL("ORCL", "Oracle Common Stock", SecurityType.EQUITY, "US", Currency.getInstance("USD"), 0.0, new ZeroDataProvider()),

    BSE_SENSEX("SENSEX", "BSE SENSEX ", SecurityType.EQUITY, "IN", null, 0.0, new ZeroDataProvider()),
    BSE_BANKEX("BANKEX", "BSE Bank Index", SecurityType.EQUITY, "IN", null, 0.0, new ZeroDataProvider()),
    BSE_HEALTH("HEALTH", "BSE Healthcare Index", SecurityType.EQUITY, "IN", null, 0.0, new ZeroDataProvider()),
    BSE_IT("TECHX", "BSE IT Index", SecurityType.EQUITY, "IN", null, 0.0, new ZeroDataProvider()),
    NSE_NIFTY("NIFTY", "NSE Nifty Index", SecurityType.EQUITY, "IN", null, 0.0, new ZeroDataProvider()),

    GOLD("AU", "Gold", SecurityType.BULLION, "US", Currency.getInstance("USD"), 0.0, new ZeroDataProvider()),
    SILVER("AG", "Silver", SecurityType.BULLION, "US", Currency.getInstance("USD"), 0.0, new ZeroDataProvider()),
    BRENT_CRUDE("BWC", "Brent Wholesale Crude Oil", SecurityType.COMMODITY, "US", Currency.getInstance("USD"), 0.0, new ZeroDataProvider()),

    USD("USD", "United States Dollar", SecurityType.FOREX, "US", Currency.getInstance("INR"), 0.0, new ZeroDataProvider()),
    EUR("EUR", "Euro", SecurityType.FOREX, "US", Currency.getInstance("INR"), 0.0, new ZeroDataProvider()),
    SGD("SGD", "Singapore Dollar", SecurityType.FOREX, "SG", Currency.getInstance("INR"), 0.0, new ZeroDataProvider()),

    CSSFO("CSSFO", "Case/Shiller - San FranCisco", SecurityType.REAL_ESTATE, "US", Currency.getInstance("USD"), 0.0, new ZeroDataProvider()),
    ONIEL ("ONIEL", "Home - Oneil Terrace", SecurityType.REAL_ESTATE, "US", Currency.getInstance("USD"), 0.0, new ZeroDataProvider()),

    BTC ("BTC", "Bit Coin", SecurityType.CRYPTO, "US", Currency.getInstance("USD"), 0.0, new ZeroDataProvider()),
    ETH ("ETH", "Ethereum", SecurityType.CRYPTO, "US", Currency.getInstance("USD"), 0.0, new ZeroDataProvider());

    @NonNull
    private String code;

    @NonNull
    private String name;

    @NonNull
    private SecurityType type;

    @NonNull
    private String country;

    @NonNull
    private Currency currency;

    private double currentValue;

    @NonNull
    private SimpleDataProvider dataProvider;

    public void refresh ()  {
        currentValue = dataProvider.fetchCurrentValue();
    }

    public static void refreshAll ()    {
        for (Index i : values())    {
            i.refresh();
        }
    }
}