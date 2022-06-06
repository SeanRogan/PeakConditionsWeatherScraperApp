package com.seanrogandev.weatherscraper.app.webscraper;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Data
public class ScrapeController {
    private final DataScraper ws = new DataScraper();
    HashMap<String, List<String[]>> weatherData = new HashMap<>();
    final public int millisecondsIn6Days = 604800000 - 86400000;
    @Scheduled(fixedDelay = millisecondsIn6Days)
    public void scheduledScraping(){
        try {
            //scrapes the page for all mountains in the usa,
            //finds their name and link to their forecast page,
            //returns a hashmap<names, links>
            HashMap<String, String> urlMap = ws.getAllMountainPeakUrls();
            //iterate through the map
            //weather data element key is mountain peak name
            //weather data element value is the List of weather conditions
            // scraped from the forecast link
            for (Map.Entry<String, String> entry : urlMap.entrySet()) {
                weatherData.put(entry.getKey(),
                        ws.getWeatherData(entry.getValue()));
            }
        } catch(IOException e) {
            //log error
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        //Todo convert hashmap to json object
    }
}
