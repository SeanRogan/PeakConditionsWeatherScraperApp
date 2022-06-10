package com.seanrogandev.weatherscraper.app.webscraper;


import com.seanrogandev.weatherscraper.app.service.DataService;
import lombok.Data;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Data
public class ScrapeScheduler {

    //todo im not sure this should be scheduled,
    // populating the DB, maybe just have it be a pure detatched API,
    // and you make calls and get back json
    private final DataService service = new DataService();
    HashMap<String, List<String[]>> weatherData = new HashMap<>();
    final public int millisecondsIn6Days = 604800000 - 86400000;
    @Scheduled(fixedDelay = millisecondsIn6Days)
    private void scheduledScraping(){
            //scrapes the page for all mountains in the usa,
            //finds their name and link to their forecast page,
            //returns a hashmap<names, links>
            HashMap<String, String> urlMap = service.getAllMountainPeakUrls();
            //iterate through the map
            //weather data element key is mountain peak name
            //weather data element value is the List of weather conditions
            // scraped from the forecast link
            for (Map.Entry<String, String> entry : urlMap.entrySet()) {
                weatherData.put(entry.getKey(),
                        service.getWeatherData(entry.getValue()));
            }
    }
}
