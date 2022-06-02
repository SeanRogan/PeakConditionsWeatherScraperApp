package com.seanrogandev.weatherscraper.app.repository;

import com.seanrogandev.weatherscraper.app.entities.MountainRange;
import com.seanrogandev.weatherscraper.app.entities.WeatherReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherReportRepository extends JpaRepository<WeatherReport, Long> {

    }
