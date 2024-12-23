package com.usafarmermarkets.backend.service;

import com.opencsv.CSVReader;
import com.usafarmermarkets.backend.entities.Market;
import com.usafarmermarkets.backend.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class MarketService {
    private final MarketRepository marketRepository;

    @Autowired
    MarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    private Market parseMarketFromCsvLine(String[] line) {
        if (line.length < 22) {
            throw new IllegalArgumentException("Invalid CSV line: not enough fields");
        }

        Market market = new Market();
        market.setFMID(Integer.parseInt(line[0]));
        market.setMarketName(line[1]);
        market.setWebsite(line[2]);
        market.setFacebook(line[3]);
        market.setTwitter(line[4]);
        market.setYoutube(line[5]);
        market.setOtherMedia(line[6]);
        market.setStreet(line[7]);
        market.setCity(line[8]);
        market.setCounty(line[9]);
        market.setState(line[10]);
        market.setZip(line[11]);
        market.setX(Float.parseFloat(line[20]));
        market.setY(Float.parseFloat(line[21]));

        return market;
    }

    public void loadDataFromCsv(String filePath) {
        String[] nextLine;
        List<Market> markets = new ArrayList<>();

        if (isDataLoaded()) {
            // Log or handle the case where data is already loaded
            return;
        }

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            reader.readNext(); // skip header line

            while ((nextLine = reader.readNext()) != null) {
                try{
                    Market market =parseMarketFromCsvLine(nextLine);
                    markets.add(market);

                    if(markets.size() > 100){
                        marketRepository.saveAll(markets);
                        markets.clear();
                    }
                }
                catch (IllegalArgumentException e) {
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(!markets.isEmpty()){
            marketRepository.saveAll(markets);
        }
    }

    public boolean isDataLoaded() {
        return marketRepository.count() > 0;
    }

    public List<Market> getAllMarkets() {
        return marketRepository.findAll();
    }

    public Market getMarketById(int  id) {
        return marketRepository.findById(id).orElse(null);
    }

    public Market saveMarket(Market market) {
        return marketRepository.save(market);
    }

    public List<Market> getMarketsByCity(String city) {
        return marketRepository.findByCity(city);
    }
}
