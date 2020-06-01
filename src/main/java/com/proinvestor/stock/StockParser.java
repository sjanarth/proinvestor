package com.proinvestor.stock;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

@Slf4j
public class StockParser
{
	private static final String TEMP_DIR = System.getProperty ("java.io.tmpdir") + "/";

	public static void parseDataFiles ()	throws IOException {
		//parseStockData ();
		parseDataFile (new File("/proinvestor/CNOB.html"));
	}
	
	public static List<Stock> getStockData ()	{
		return stocks;
	}
	
	public static List<Stock> getStocks()	{
		return stocks;
	}
	
	private static void parseStockData () throws IOException	{
		List<Path> paths = 
			Files.list(Paths.get(TEMP_DIR))
					.filter(path -> Files.isRegularFile(path))
					.filter(path -> path.getFileName().toString().endsWith("html"))
					.sorted()
					.collect(Collectors.toList());
		int countTotal = paths.size();
		int countProcessed = 1;
		for (Path p : paths) {
			try	{
				log.info("Parsing ["+countProcessed+"/"+countTotal+"] "+p.toString());
				parseDataFile (p.toFile());
			} catch (IOException ie) {
				log.error ("Failed to parse stock data for ["+p.getFileName()+"]", ie);
			}
			countProcessed++;
		}
	}
	
	private static void parseDataFile (File filePath) throws IOException	{
		Document doc = Jsoup.parse(filePath, "UTF-8", "http://example.com/");
		Stock stock = new Stock("GOOG", 1400);//Stock.buildStock(doc);
		stocks.add(stock);
	}
	
	private static List<Stock> stocks = new ArrayList<>();
}