package com.proinvestor.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController
{
    @Autowired
    private StockService stockService;

    @RequestMapping("/stocks")
    public List<Stock> getAllStocks()   {
        return stockService.getAllStocks();
    }

    @RequestMapping("/stocks/{ticker}")
    public Stock getStock (@PathVariable String ticker)   {
        return stockService.getStock(ticker);
    }

    @RequestMapping(method=RequestMethod.POST, value="/stocks")
    public void addStock (@RequestBody Stock stock) {
        stockService.addStock(stock);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/stocks/{ticker}")
    public void updateStock (@RequestBody Stock stock, @PathVariable String ticker) {
        stockService.updateStock(ticker, stock);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/stocks/{ticker}")
    public void deleteStock (@PathVariable String ticker) {
        stockService.deleteStock(ticker);
    }
}