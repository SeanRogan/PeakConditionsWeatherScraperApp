package com.seanrogandev.weatherscraper.app.repository;

import com.seanrogandev.weatherscraper.app.entities.MountainRange;
import com.seanrogandev.weatherscraper.app.entities.WeatherReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WeatherReportRepository extends JpaRepository<WeatherReport, Long> {


    }
