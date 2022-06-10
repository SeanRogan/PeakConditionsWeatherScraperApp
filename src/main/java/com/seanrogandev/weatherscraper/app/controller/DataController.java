package com.seanrogandev.weatherscraper.app.controller;

import com.seanrogandev.weatherscraper.app.entities.MountainPeak;
import com.seanrogandev.weatherscraper.app.repository.MountainPeakRepository;
import com.seanrogandev.weatherscraper.app.repository.MountainRangeRepository;
import com.seanrogandev.weatherscraper.app.repository.WeatherReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DataController {

    //todo endpoints to expose for weather api..
    // getAllPeaksByRange,
    // getAllPeaksStartingWith{Letter}
    // getPeakByNameAndRange,
    // getAllRanges,
    // getRangesByState
    // getAllPeaks, getWeatherByPeakId, getPeakURLbyName
}
