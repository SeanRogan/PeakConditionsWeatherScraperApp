package com.seanrogandev.weatherscraper.app;

import com.seanrogandev.weatherscraper.app.webscraper.DataScraper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class App {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(App.class, args);
		DataScraper w = new DataScraper();
		w.getAllMountainPeakUrls();
	}

}
