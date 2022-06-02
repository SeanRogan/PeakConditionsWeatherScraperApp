package com.seanrogandev.weatherscraper.app.webscraper;

import com.seanrogandev.weatherscraper.app.entities.WeatherReport;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class Webscraper {
    final public String baseUrl = "https://www.mountain-forecast.com";


    public List<String[]> getWeatherData(String url) throws IOException {
        List<String[]> dataList = new ArrayList<>();
        String weatherConditionsRow = "forecast__table-summary";
        String maxTempRow = "forecast__table-max-temperature";
        String minTempRow = "forecast__table-min-temperature";
        String windChillRow = "forecast__table-chill";
        String rainFallRow = "forecast__table-rain";
        String snowFallRow = "forecast__table-snow";
        String windRow = "forecast__table-wind";
        Document doc = Jsoup.connect(url).get();


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

        return dataList;
    }

    private String[] collectToArray(Iterator<Element> itr) {
        String[] result = new String[18];
        int counter = 0;

        while(itr.hasNext()) {
            Element currentElement = itr.next();
            result[counter] = currentElement.text();
            counter++;
        }

        return result;
    }

    private String[] getWindConditions(Iterator<Element> itr) {

        String[] result = new String[18];
        int counter = 0;

        while(itr.hasNext()) {
            Element currentElement = itr.next();
            String windspeed = currentElement.select("text.wind-icon__val").text();
            String windDirection = currentElement.select("div.wind-icon__tooltip").text();
            result[counter] = windspeed + " " + windDirection;
            counter++;
        }

        return result;
    }


}
