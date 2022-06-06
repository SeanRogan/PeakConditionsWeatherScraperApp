package com.seanrogandev.weatherscraper.app.webscraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DataService {
    final DataScraper ds = new DataScraper();
    final public String baseUrl = "https://www.mountain-forecast.com";


    public HashMap<String,String> getAllMountainPeakUrls() {
        //listOfPeakUrls is a Hashmap of mountain peak names(key) and their corresponding uri (value)
        HashMap<String,String> listOfPeakUrls = new HashMap<>();
        //document map contains the pages a-z containing
        // all the links of all mountain peaks (over 1000ft) in the USA
        Map<Character, Document> documentMap = new HashMap<>();
        //iterating through the integer values 65-90 which will be cast to A-Z characters
        // via their ascii values. then using the characters to fill in the variable in the uri.
        for(int i = 65; i <= 90; i++ ) {
            //num converted to capital Letter char
            char c = (char)i;
            //uri of
            String uri = String.format(baseUrl + "/countries/United-States/locations/%c" , c);
            documentMap.put(c, ds.scrapeDocument(uri));
        }
        Iterator<Document> itr = documentMap.values().iterator();
        while(itr.hasNext()) {
            Document current = itr.next();
            Elements elements = current.getElementsByClass("b-list-table__item").select("a");
            Iterator<Element> eItr = elements.iterator();
            while (eItr.hasNext()) {
                Element currentElement = eItr.next();
                listOfPeakUrls.put(currentElement.text() , currentElement.select("a[href]").attr("href"));
            }
        }
        return listOfPeakUrls;
    }

    /**
     *
     *
     * @param uri the uri of the specific mountain peak with which the weather data is associated.
     *
     * @return List<String[]> dataList - returns a list of string arrays,
     * each array containing all values of one category,
     * catagories being the high temperature, low temperature,
     * and windchill temps, along with wind and weather conditions
     * and rainfall snowfall estimates
     */
    public List<String[]> getWeatherData(String uri) {
        List<String[]> dataList = new ArrayList<>();
        String weatherConditionsRow = "forecast__table-summary";
        String maxTempRow = "forecast__table-max-temperature";
        String minTempRow = "forecast__table-min-temperature";
        String windChillRow = "forecast__table-chill";
        String rainFallRow = "forecast__table-rain";
        String snowFallRow = "forecast__table-snow";
        String windRow = "forecast__table-wind";
        Document doc = ds.scrapeDocument(uri);

        if(doc != null) {
            //get high temps
            Elements maxTempElements = doc.getElementsByClass(maxTempRow)
                    .select("span.temp");
            dataList.add(collectToArray(maxTempElements.iterator()));

            //get low temps
            Elements minTempElements = doc.getElementsByClass(minTempRow)
                    .select("span.temp");
            dataList.add(collectToArray(minTempElements.iterator()));


            //get windchill temps
            Elements windChillElements = doc.getElementsByClass(windChillRow)
                    .select("span.temp");
            dataList.add(collectToArray(windChillElements.iterator()));


            //get snowfall
            Elements snowFallElements = doc.getElementsByClass(snowFallRow)
                    .select("td.forecast__table-relative")
                    .select("span.snow");
            dataList.add(collectToArray(snowFallElements.iterator()));


            //get rainfall
            Elements rainFallElements = doc.getElementsByClass(rainFallRow)
                    .select("td.forecast__table-relative")
                    .select("span.rain");
            dataList.add(collectToArray(rainFallElements.iterator()));


            //get weather elements
            Elements weatherConditionElements = doc.getElementsByClass(weatherConditionsRow)
                    .select("td");
            dataList.add(collectToArray(weatherConditionElements.iterator()));


            //get wind elements
            Elements windElements = doc.getElementsByClass(windRow)
                    .select("tr.forecast__table-wind");
            dataList.add(getWindConditions(windElements.select("td.iconcell").iterator()));
        }
        //returns arrayList of String arrays containing
        return dataList;
    }

    private String[] collectToArray(Iterator<Element> itr) {
        String[] result = new String[18];
        int counter = 0;

        while(itr.hasNext()) {
            Element current = itr.next();
            result[counter] = current.text();
            counter++;
        }

        return result;
    }

    private String[] getWindConditions(Iterator<Element> itr) {

        String[] result = new String[18];
        int counter = 0;
        while(itr.hasNext()) {
            Element current = itr.next();
            String windspeed = current.select("text.wind-icon__val").text();
            String windDirection = current.select("div.wind-icon__tooltip").text();
            result[counter] = windspeed + " " + windDirection;
            counter++;
        }

        return result;
    }
}
