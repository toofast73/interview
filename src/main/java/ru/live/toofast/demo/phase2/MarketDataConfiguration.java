package ru.live.toofast.demo.phase2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MarketDataConfiguration {

    @Bean
    public MarketDataProvider marketDataProvider(){
        return new MarketDataProvider(bloomberg(), nyse(), ice());
    }

    @Bean
    public MarketDataSource bloomberg(){
        return new MarketDataSource() {
            @Override
            public double getMarketData(String stockId) {
                return 42.0;
            }

            @Override
            public String getName() {
                return "bloomberg";
            }
        };
    }

    @Bean
    public MarketDataSource nyse(){
        return new MarketDataSource() {
            @Override
            public double getMarketData(String stockId) {
                longRunningRemoteCallSimulation();
                return 44.0;
            }

            @Override
            public String getName() {
                return "nyse";
            }
        };
    }

    @Bean
    public MarketDataSource ice(){
        return new MarketDataSource() {
            @Override
            public double getMarketData(String stockId) {
                longRunningRemoteCallSimulation();
                return 40.0;
            }

            @Override
            public String getName() {
                return "ice";
            }
        };
    }

    private void longRunningRemoteCallSimulation() {
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
