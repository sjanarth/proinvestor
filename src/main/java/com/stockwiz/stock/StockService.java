package com.stockwiz.stock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class StockDataService
{
    private List<Stock> stocks = new ArrayList<>(Arrays.asList(
            new Stock("GOOG", 1400.23),
            new Stock("MSFT", 176.47),
            new Stock("AAPL", 320.69),
            new Stock("TSLA", 818.99)
        ));

    public List<Stock> getAllStocks()   {
        return stocks;
    }

    public Stock getStock(String ticker)    {
        return stocks.stream().filter(s -> s.getTicker().equals(ticker)).findFirst().get();
    }

    public void addStock(Stock stock)   {
        log.info("Adding Stock - "+stock);
        stocks.add(stock);
    }

    public void updateStock(String ticker, Stock stock)   {
        log.info("Updating Stock - "+stock);
        for (int i = 0; i < stocks.size(); i++) {
            Stock s = stocks.get(i);
            if (s.getTicker().equals(ticker))   {
                stocks.set(i, stock);
                return;
            }
        }
    }

    public void deleteStock (String ticker) {
        log.info("Deleting Stock - "+ticker);
        stocks.removeIf(s -> s.getTicker().equals(ticker));
    }
}
