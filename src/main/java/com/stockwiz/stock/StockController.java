package com.stockwiz.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController
{
    @Autowired
    private StockDataService stockDataService;

    @RequestMapping("/stocks")
    public List<Stock> getAllStocks()   {
        return stockDataService.getAllStocks();
    }

    @RequestMapping("/stocks/{ticker}")
    public Stock getStock (@PathVariable String ticker)   {
        return stockDataService.getStock(ticker);
    }

    @RequestMapping(method=RequestMethod.POST, value="/stocks")
    public void addStock (@RequestBody Stock stock) {
        stockDataService.addStock(stock);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/stocks/{ticker}")
    public void updateStock (@RequestBody Stock stock, @PathVariable String ticker) {
        stockDataService.updateStock(ticker, stock);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/stocks/{ticker}")
    public void deleteStock (@PathVariable String ticker) {
        stockDataService.deleteStock(ticker);
    }
}