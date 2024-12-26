package com.usafarmermarkets.backend.controller;

import com.usafarmermarkets.backend.entities.Market;
import com.usafarmermarkets.backend.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/markets")
public class MarketController {
    @Autowired
    private MarketService marketService;

    @GetMapping
    public List<Market> getAllMarkets() {
        return marketService.getAllMarkets();
    }

    @GetMapping("/{id}")
    public Market getMarketById(@PathVariable int id) {
        return marketService.getMarketById(id);
    }

    @PostMapping
    public Market createMarket(@RequestBody Market market) {
        return marketService.saveMarket(market);
    }

    @GetMapping("/city/{city}")
    public List<Market> getMarketsByCity(@PathVariable String city) {
        return marketService.getMarketsByCity(city);
    }
}
