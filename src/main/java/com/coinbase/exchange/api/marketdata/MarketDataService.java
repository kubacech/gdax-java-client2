package com.coinbase.exchange.api.marketdata;

import com.coinbase.exchange.api.exchange.GdaxExchange;
import org.springframework.core.ParameterizedTypeReference;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by robevansuk on 07/02/2017.
 */
public class MarketDataService {

    private GdaxExchange exchange;

    public static final String PRODUCT_ENDPOINT = "/products";

    public MarketDataService(GdaxExchange exchange) {
        this.exchange = exchange;
    }

    public Mono<MarketData> getMarketDataOrderBook(String productId, String level) {
        String marketDataEndpoint = PRODUCT_ENDPOINT + "/" + productId + "/book";
        if(level != null && !level.equals(""))
            marketDataEndpoint += "?level=" + level;
       return exchange.get(marketDataEndpoint, new ParameterizedTypeReference<MarketData>(){});
    }

    public Mono<List<Trade>> getTrades(String productId) {
        String tradesEndpoint = PRODUCT_ENDPOINT + "/" + productId + "/trades";
        return exchange.getAsList(tradesEndpoint, new ParameterizedTypeReference<Trade[]>(){});
    }

    public Mono<List<Currency>> currencies() {
        String currenciesEndpoint = "/currencies";
        return exchange.getAsList(currenciesEndpoint, new ParameterizedTypeReference<Currency[]>(){});
    }
}
