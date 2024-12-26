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

    /**
     * Constructor
     * @requires marketRepository != null
     * @param marketRepository
     * @effects constructs a new MarketService object
     * @returns none
     */
    @Autowired
    MarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    /**
     * Takes a single line from the CSV file into a Market object
     * @requires line != null
     * @param line
     * @effects  none
     * @returns Market object
     */
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

    /**
     * Loads data from a CSV file
     * @requires filePath != null
     * @param filePath
     * @effects none
     * @returns none
     */
    public void loadDataFromCsv(String filePath) {
        String[] nextLine; // next line from CSV file
        List<Market> markets = new ArrayList<>(); // list of markets to save

        //return for the case where data is already loaded
        if (isDataLoaded()) {
            return;
        }

        //parse the CSV file
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            reader.readNext(); // skip header line

            while ((nextLine = reader.readNext()) != null) {
                try{
                    Market market = parseMarketFromCsvLine(nextLine);
                    markets.add(market);
                    marketRepository.save(market);
                }
                catch (IllegalArgumentException e) {
                    System.err.println("Error parsing line: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks if data is already loaded
     * @requires none
     * @effects none
     * @returns boolean
     */
    public boolean isDataLoaded() {
        return marketRepository.count() > 0;
    }

    /**
     * Gets all markets
     * @requires none
     * @effects none
     * @returns List of Market objects
     */
    public List<Market> getAllMarkets() {
        return marketRepository.findAll();
    }

    /**
     * Gets a market by ID
     * @requires id >= 0
     * @param id
     * @effects none
     * @returns Market object
     */
    public Market getMarketById(int  id) {
        return marketRepository.findById(id).orElse(null);
    }

    /**
     * Saves a market
     * @requires market != null
     * @param market
     * @effects none
     * @returns Market object
     */
    public Market saveMarket(Market market) {
        return marketRepository.save(market);
    }

    /**
     * Gets markets by city
     * @requires city != null
     * @param city
     * @effects none
     * @returns List of Market objects
     */
    public List<Market> getMarketsByCity(String city) {
        return marketRepository.findByCity(city);
    }
}
