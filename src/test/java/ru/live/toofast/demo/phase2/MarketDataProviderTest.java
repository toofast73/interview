package ru.live.toofast.demo.phase2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MarketDataConfiguration.class)
public class MarketDataProviderTest {

    @Autowired
    private MarketDataProvider marketDataProvider;

    @Test
    public void getMarketDataTest(){
        Map<String, Double> btc = marketDataProvider.getMarketData("BTC");
        assertThat(btc.values()).containsOnly(44.0, 42.0, 40.0);
    }

}
