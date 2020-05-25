package com.stockwiz.stock;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.stockwiz.util.TextUtils;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString(doNotUseGetters = true) 
public class Stock //implements Comparable<Stock>
{
	private Stock () {}

	public static Stock buildStock(Document doc)	
	{
		Stock stock = new Stock();
	
		stock.symbol = doc.select("#ticker").text();
		stock.companyName = doc.select(".tab-link").select("a[href^=http:] b").text();
		stock.industry = doc.select(".tab-link").select("a[href^=screener.ashx]").first().nextElementSibling().text();
		stock.geo = doc.select(".tab-link").select("a[href^=screener.ashx]").last().text();
		
		stock.isSNP = getFieldData(doc, "Index").contains("S&P500");
		stock.isDJIA = getFieldData(doc, "Index").contains("DJIA");
		stock.marketCap = TextUtils.parseMillions (getFieldData(doc, "Market Cap")); 
		stock.income = TextUtils.parseMillions (getFieldData(doc, "Income"));
		stock.sales = TextUtils.parseMillions (getFieldData(doc, "Sales"));
		stock.bookSh = TextUtils.parseRatio (getFieldData(doc, "Book/sh"));
		stock.cashSh = TextUtils.parseCents (getFieldData(doc, "Cash/sh"));
		stock.dividend = TextUtils.parseCents (getFieldData(doc, "Dividend"));
		stock.dividendYield = TextUtils.parsePercentage (getFieldData(doc, "Dividend %")); 
		stock.employees = TextUtils.parseInteger (getFieldData(doc, "Employees"));

		stock.priceEarnings = TextUtils.parseFloat (getFieldData2(doc, "P/E"));
		stock.fwdPriceEarnings = TextUtils.parseFloat (getFieldData2(doc, "Forward P/E"));
		stock.price2Sales = TextUtils.parseRatio (getFieldData2(doc, "P/S"));
		stock.price2Book = TextUtils.parseRatio (getFieldData2(doc, "P/B"));
		stock.price2Cash = TextUtils.parseRatio (getFieldData2(doc, "P/C"));
		stock.price2FCF = TextUtils.parseRatio (getFieldData2(doc, "P/FCF"));
		stock.quickRatio = TextUtils.parseRatio (getFieldData2(doc, "Quick Ratio"));
		stock.currentRatio = TextUtils.parseRatio (getFieldData2(doc, "Current Ratio"));
		stock.dbt2Equity = TextUtils.parseRatio (getFieldData2(doc, "Debt/Eq"));
		stock.longDebt2Equity = TextUtils.parseRatio (getFieldData2(doc, "LT Debt/Eq"));
		stock.sma20 = TextUtils.parsePercentage (getFieldData2(doc, "SMA20"));

		stock.epsTTM = TextUtils.parseCents (getFieldData2(doc, "EPS (ttm)"));
		stock.epsNextQ = TextUtils.parseCents (getFieldData2(doc, "EPS next Q"));
		stock.epsNextY = TextUtils.parseCents (getFieldData2(doc, "EPS next Y"));
		stock.epsThisY = TextUtils.parsePercentage (getFieldData2(doc, "EPS this Y"));
		stock.epsNextY = TextUtils.parseCents (getFieldData2(doc, "EPS next Y"));
		stock.epsNext5Y = TextUtils.parsePercentage (getFieldData2(doc, "EPS next 5Y"));
		stock.epsPast5Y = TextUtils.parsePercentage (getFieldData2(doc, "EPS past 5Y"));
		// sop("Earnings = "+getFieldData2(doc, "Earnings"));
		// stock.nextEarningsDate = getFieldData3(doc, "Earnings");
		stock.sma50 = TextUtils.parsePercentage (getFieldData2(doc, "SMA50"));
		
		stock.insiderOwn = TextUtils.parsePercentage (getFieldData2(doc, "Insider Own"));
		stock.insiderTrans = TextUtils.parsePercentage (getFieldData2(doc, "Insider Trans"));
		stock.instOwn = TextUtils.parsePercentage (getFieldData2(doc, "Inst Own"));
		stock.instTrans = TextUtils.parsePercentage (getFieldData2(doc, "Inst Trans"));
		stock.ROA = TextUtils.parsePercentage (getFieldData2(doc, "ROA"));
		stock.ROE = TextUtils.parsePercentage (getFieldData2(doc, "ROE"));
		stock.ROI = TextUtils.parsePercentage (getFieldData2(doc, "ROI"));
		stock.marginGross = TextUtils.parsePercentage (getFieldData2(doc, "Gross Margin"));
		stock.marginOper = TextUtils.parsePercentage (getFieldData2(doc, "Oper. Margin"));
		stock.marginProfit = TextUtils.parsePercentage (getFieldData2(doc, "Profit Margin"));
		stock.sma200 = TextUtils.parsePercentage (getFieldData2(doc, "SMA200"));

		return stock;
	}
	
	private static void sop (String s) {
		System.out.println(s);
	}
	
	/*
	 * 	<td width="7%" class="snapshot-td2-cp" align="left" title="cssbody=[tooltip_short_bdy] cssheader=[tooltip_short_hdr] body=[Diluted EPS (ttm)] offsetx=[10] offsety=[20] delay=[300]">EPS (ttm)</td>
	 * 	<td width="8%" class="snapshot-td2" align="left"><b>2.08</b></td>
	 */
	private static String getFieldData(Document doc, String fieldName) {
		Elements elements = doc.select("td[class]:contains("+fieldName+"):first-child");
		String text = elements.next().text();
		return text.split(" ")[0];
	}

	/*
	 * 	<td width="7%" class="snapshot-td2-cp" align="left" title="cssbody=[tooltip_short_bdy] cssheader=[tooltip_short_hdr] body=[Price-to-Earnings (ttm)] offsetx=[10] offsety=[20] delay=[300]">P/E</td>
	 * 	<td width="8%" class="snapshot-td2" align="left"><b><span style="color:#008800;">5.42</span></b></td>
	 */
	private static String getFieldData2(Document doc, String fieldName) {
		Elements elements = doc.select("td[class]:contains("+fieldName+")");
		String text = elements.next().text();
		return text.split(" ")[0];
	}

	private static String getFieldData3(Document doc, String fieldName) {
		Elements elements = doc.select("td[class]:contains("+fieldName+")");
		String text = elements.val();
		return text;
	}

	private String symbol = null;
	private String companyName = null;
	private String sector = null;
	private String industry = null;
	private String geo = null;
	
	private Boolean isSNP = false;			// is part of S&P500?
	private Boolean isDJIA = false;			// is part of DJIA?
	private Integer marketCap = 0;			// in millions
	private Integer income = 0;				// in millions
	private Integer sales = 0;				// in millions
	private Float bookSh = 0.0f;			// ratio
	private Integer cashSh = 0;				// in cents
	private Integer dividend = 0;			// in cents
	private Float dividendYield = 0.0f;		// percentage
	private Integer employees = 0;			
	
	private Float priceEarnings = 0.0f;		// ratio
	private Float fwdPriceEarnings = 0.0f;	// ratio
	private Float price2Sales = 0.0f;		// ratio
	private Float price2Book = 0.0f;		// ratio
	private Float price2Cash = 0.0f;		// ratio
	private Float price2FCF = 0.0f;			// ratio
	private Float quickRatio = 0.0f;		// ratio
	private Float currentRatio = 0.0f;		// ratio
	private Float dbt2Equity = 0.0f;		// ratio
	private Float longDebt2Equity = 0.0f;	// ratio
	private Float sma20 = 0.0f;				// percentage
	
	private Integer epsTTM = 0;				// in cents
	private Float epsThisY = 0.0f;			// percentage
	private Float epsPast5Y = 0.0f;			// percentage 	
	private Integer epsNextQ = 0;			// in cents
	private Integer epsNextY = 0;			// in cents
	private Float epsNext5Y = 0.0f;			// percentage
	private String nextEarningsDate = null;	// Apr 29 AMC	
	private Float sma50 = 0.0f;				// percentage
	
	private Float insiderOwn = 0.0f;		// percentage
	private Float insiderTrans = 0.0f;		// percentage (6 month change)
	private Float instOwn = 0.0f;			// percentage
	private Float instTrans = 0.0f;			// percentage (3 month change)
	private Float ROA = 0.0f;				// percentage
	private Float ROE = 0.0f;				// percentage
	private Float ROI = 0.0f;				// percentage
	private Float marginGross = 0.0f;		// percentage
	private Float marginOper = 0.0f;		// percentage
	private Float marginProfit = 0.0f;		// percentage
	private Float sma200 = 0.0f;			// percentage
	
	private Integer shOutstanding = 0;		// in thousands
	private Integer shFloat = 0;			// in thousands
	private Float shortFloat = 0.0f;		// percentage
	private Float shortRatio = 0.0f;		// percentage
	private Float priceTaget = 0.0f;		// in dollars		
	private Float wk52Min = 0.0f;			// in dollars
	private Float wk52Max = 0.0f;			// in dollars
	private Float rsi = 0.0f;				// ratio
	private Integer volume = 0;				// in thousands
	private Integer avg3MoVolume = 0;		// in thousands
	
	private Float perfWeek = 0.0f;			// percentage
	private Float perfMonth = 0.0f;			// percentage
	private Float perfQtr = 0.0f;			// percentage
	private Float perf6Month = 0.0f;		// percentage
	private Float perf12Month = 0.0f;		// percentage
	private Float perfYTD = 0.0f;			// percentage
	private Float beta = 0.0f;				// ratio
	private Float volatalityWeek = 0.0f;	// ratio
	private Float volatilityMonth = 0.0f;	// ratio
	private Integer price = 0;				// in cents
	
	/*@Override
	public int compareTo(Stock o) {
		return marketCap - o.marketCap;
	}*/
}
