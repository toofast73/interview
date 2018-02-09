package ru.live.toofast.demo.phase2;

public interface MarketDataSource {

    double getMarketData(String stockId);
    String getName();
}
