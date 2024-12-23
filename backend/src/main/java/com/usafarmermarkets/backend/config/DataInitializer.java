package com.usafarmermarkets.backend.config;

import com.usafarmermarkets.backend.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final MarketService farmerMarketService;
    private final String csvFilePath;

    @Autowired
    public DataInitializer(MarketService farmerMarketService, @Value("${csv.file.path}") String csvFilePath) {
        this.farmerMarketService = farmerMarketService;
        this.csvFilePath = csvFilePath;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        farmerMarketService.loadDataFromCsv(csvFilePath);
    }
}