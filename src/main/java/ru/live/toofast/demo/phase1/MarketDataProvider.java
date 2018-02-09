package ru.live.toofast.demo.phase1;

import java.util.HashMap;
import java.util.Map;

class MarketDataProvider {
    static Map<String, Double> getMarketData(String stockId) {

        longRunningRemoteCallSimulation();
        Map<String, Double> result = new HashMap<>();
        result.put("Bloomberg", 42.0);

        return result;
    }

    private static void longRunningRemoteCallSimulation() {
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
