package com.proinvestor.stock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
//@Service
public class StockService
{
    /*
    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAllStocks()   {
        List<Stock> stocks = new ArrayList<>();
        stockRepository.findAll().forEach(stocks::add);
        return stocks;
    }

    public Stock getStock(String ticker)    {
        return stockRepository.findById(ticker).orElse(null);
    }

    public void addStock(Stock stock)   {
        log.info("Adding Stock - "+stock);
        stockRepository.save(stock);
    }

    public void updateStock(String ticker, Stock stock)   {
        log.info("Updating Stock - "+stock);
        stockRepository.save(stock);
    }

    public void deleteStock (String ticker) {
        log.info("Deleting Stock - "+ticker);
        stockRepository.deleteById(ticker);
    }

     */
}