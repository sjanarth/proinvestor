package com.stockwiz.stock;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
public class StockDataDownloader
{
	private static final long TWO_DAYS_IN_MILLIS = 2 * 24 * 60 * 60 * 1000;

	private static final String TEMP_DIR = System.getProperty ("java.io.tmpdir") + "/";
	
	private static final String STOCK_DATA_URL = "https://www.finviz.com/quote.ashx?t=";
	private static final String STOCK_LIST_URL = "ftp://ftp.nasdaqtrader.com/SymbolDirectory/";
	private static final String STOCK_LIST_FILENAME = "nasdaqlisted.txt";	// "otherlisted.txt";

	public static void refreshDataFiles () throws IOException	{
		refreshStockList();
		refreshStockData();
	}
	
	private static void refreshStockList() throws IOException	{
		refresh (STOCK_LIST_URL + STOCK_LIST_FILENAME, TEMP_DIR + STOCK_LIST_FILENAME);
	}
	
	private static void refresh (String url, String filePath) throws IOException 	{
		log.debug ("Refreshing "+filePath+ " from "+url);
		File file = new File (filePath);
		if (file.exists())	{
			long lmt = file.lastModified ();
			long now = System.currentTimeMillis ();
			long diff = now - lmt;
			if (diff < TWO_DAYS_IN_MILLIS)	{
				log.debug ("Skip refreshing "+filePath);
				return;
			}
		}
		download (url, filePath);
	}
	
	private static void download (String address, String filePath) throws IOException {
		log.debug ("Downloading "+address+" to "+filePath);
	    try (InputStream in = URI.create(address).toURL().openStream()) {
	        Files.copy(in, Paths.get(filePath));
	    }
		/*
        OutputStream out = null;
        URLConnection conn = null;
        InputStream in = null;
        try {
            URL url = new URL(address);
            out = new BufferedOutputStream(new FileOutputStream(filePath));
            conn = url.openConnection();
            in = conn.getInputStream();
            byte[] buffer = new byte[1024];
            int numRead;
            //long numWritten = 0;
            while ((numRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, numRead);
                //numWritten += numRead;
            }
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } 
            catch (IOException ioe) {
            }
        }
        */
	}
	
	private static void refreshStockData() throws IOException	{
		String nasdaqListed = TEMP_DIR + STOCK_LIST_FILENAME;
		int countTotal = getCountOfLinesInFile (nasdaqListed) - 2;
		try (BufferedReader br = new BufferedReader (new FileReader(nasdaqListed))) {
			String line = br.readLine();
			int countProcessed = 1;
			while (line != null)	{
				if (!line.startsWith("Symbol|") && !line.startsWith("Nasdaq Traded|") && !line.startsWith("File Creation Time: "))	{
					String[] splits = line.split("\\|");
					String stock = splits[0];
					String company = splits[1];
					log.info("Processing ["+countProcessed+"/"+countTotal+"] "+company);
					try	{
						refresh (STOCK_DATA_URL + stock, TEMP_DIR + stock + ".html");
					} catch (IOException e) {
						log.error ("Failed to refresh stock data for ["+company+"]", e);
					}
					countProcessed++;
				}
				line = br.readLine();
			}
		}
	}
	
	private static int getCountOfLinesInFile (String filePath) throws IOException {
		Path path = Paths.get(filePath);
		long lineCount = Files.lines(path).count();
		return (int) lineCount;
	}
}