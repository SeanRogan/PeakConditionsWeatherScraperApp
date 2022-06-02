package com.seanrogandev.weatherscraper.app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherReport {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long weatherReportId;
    private Long peakId;
    private String maxTemp;
    private String minTemp;
    private String windChill;
    private String windSpeed;
    private float expectedRainfall;
    private float expectedSnowfall;
    private String windDirection;
    private String weatherConditions;

}
