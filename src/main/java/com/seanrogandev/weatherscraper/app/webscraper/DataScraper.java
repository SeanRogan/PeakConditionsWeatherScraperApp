package com.seanrogandev.weatherscraper.app.webscraper;

import lombok.NoArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

@NoArgsConstructor
public class DataScraper {

    public Document scrapeDocument(String uri) {
        try {
           Document result = Jsoup.connect(uri).get();
           return result;
        } catch (IOException e)
        {
        //todo fill catch block
        }
        return null;

    }



}
