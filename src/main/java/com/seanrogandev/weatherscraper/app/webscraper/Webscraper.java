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
    String weatherConditionsRow = "forecast__table-summary";
    String maxTempRow = "forecast__table-max-temperature";
    String minTempRow = "forecast__table-min-temperature";
    String windChillRow = "forecast__table-chill";
    String rainFallRow = "forecast__table-rain";
    String snowFallRow = "forecast__table-snow";
    String windRow = "forecast__table-wind";

    public WeatherReport getWeatherData(String url) throws IOException {

        WeatherReport report = new WeatherReport();
        Document doc = Jsoup.connect(url).get();

        //get high temps
        Elements maxTempElements = doc.getElementsByClass(maxTempRow)
                .select("span.temp");
        String[] maxTemps = collectToArray(maxTempElements.iterator());


        //get low temps
        Elements minTempElements = doc.getElementsByClass(minTempRow)
                .select("span.temp");
        String[] minTemps = collectToArray(minTempElements.iterator());


        //get windchill temps
        Elements windChillElements = doc.getElementsByClass(windChillRow)
                .select("span.temp");
        String[] windChillTemps = collectToArray(windChillElements.iterator());


        //get snowfall
        Elements snowFallElements = doc.getElementsByClass(snowFallRow)
                .select("td.forecast__table-relative")
                .select("span.snow");
        String[] snowFall = collectToArray(snowFallElements.iterator());


        //get rainfall
        Elements rainFallElements = doc.getElementsByClass(rainFallRow)
                .select("td.forecast__table-relative")
                .select("span.rain");
        String[] rainFall = collectToArray(rainFallElements.iterator());


        //get weather elements
        Elements weatherConditionElements = doc.getElementsByClass(weatherConditionsRow)
                .select("td");
        String[] weatherConditions = collectToArray(weatherConditionElements.iterator());


        //get wind elements
        Elements windElements = doc.getElementsByClass(windRow)
                .select("tr.forecast__table-wind");
        String[] windStats = getWindConditions(windElements.select("td.iconcell").iterator());


        System.out.println(Arrays.toString(windStats));
        System.out.println(Arrays.toString(weatherConditions));
        System.out.println(Arrays.toString(maxTemps));
        System.out.println(Arrays.toString(minTemps));
        System.out.println(Arrays.toString(windChillTemps));
        System.out.println(Arrays.toString(rainFall));
        System.out.println(Arrays.toString(snowFall));

        return report;
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
