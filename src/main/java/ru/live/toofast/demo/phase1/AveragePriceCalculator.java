package ru.live.toofast.demo.phase1;

import com.google.common.base.Preconditions;

import java.util.Map;

public class AveragePriceCalculator {

    /**
     * Evaluates min asset price from multiple market data providers and exchanges
     * @param stockId, i.e. USD/BTC/GOOG
     */
    public static double calculateMinStockPrice(String stockId){

        Map<String, Double> marketData = MarketDataProvider.getMarketData(stockId);

        return findMinPrice(marketData);
    }

    private static Double findMinPrice(Map<String, Double> marketData){
        Preconditions.checkArgument(!marketData.isEmpty());

        Double minPrice = null;

        for (Double price : marketData.values()) {
            if(minPrice == null){
                minPrice = price;
            }
            if (price < minPrice){
                minPrice = price;
            }
        }
        return minPrice;
    }
}