package ru.live.toofast.demo.phase2;

import java.util.HashMap;
import java.util.Map;

class MarketDataProvider {

    private final MarketDataSource bloomberg;
    private final MarketDataSource nyse;
    private final MarketDataSource ice;

    MarketDataProvider(MarketDataSource bloomberg, MarketDataSource nyse, MarketDataSource ice) {
        this.bloomberg = bloomberg;
        this.nyse = nyse;
        this.ice = ice;
    }


    public Map<String, Double> getMarketData(String stockId) {
        Map<String, Double> result = new HashMap<>();
        result.put(bloomberg.getName(), bloomberg.getMarketData(stockId));
        result.put(nyse.getName(),      nyse.getMarketData(stockId));
        result.put(ice.getName(),       ice.getMarketData(stockId));
        return result;
    }

}
