package com.seanrogandev.weatherscraper.app;

import com.seanrogandev.weatherscraper.app.webscraper.Webscraper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class App {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(App.class, args);
		Webscraper w = new Webscraper();
		w.getWeatherData("https://www.mountain-forecast.com/peaks/Mount-Washington-2/forecasts/1917");
	}

}
