package com.proinvestor.stock;

import java.io.IOException;

public class StockWizard 
{
	public static void main (String[] args)	{
		try	{
			tellMeWhatToBuy();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	
	private static void tellMeWhatToBuy() throws IOException	{
		StockDownloader.refreshDataFiles();
		/*Parser.parseDataFiles();
		List<Stock> stocks = Parser.getStocks();
		for (Stock stock : stocks)	{
			System.out.println(stock.toString());
		}*/
		//Analyzer.analyzeAndRecommend();
	}
}