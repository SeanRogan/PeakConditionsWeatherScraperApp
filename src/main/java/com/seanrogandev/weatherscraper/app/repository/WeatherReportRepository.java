package com.seanrogandev.weatherscraper.app.repository;

import com.seanrogandev.weatherscraper.app.entities.MountainRange;
import com.seanrogandev.weatherscraper.app.entities.WeatherReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WeatherReportRepository extends JpaRepository<WeatherReport, Long> {

    @Query("SELECT report FROM weather_report report WHERE peakId = ?1 AND ")
    List<WeatherReport> getWeatherReportByPeakId(Long peakId);

    }
