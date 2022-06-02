package com.seanrogandev.weatherscraper.app.entities;

import com.seanrogandev.weatherscraper.app.model.WeatherConditions;
import com.seanrogandev.weatherscraper.app.model.WeatherReportTimeOfDay;
import lombok.*;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Getter
@Setter
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
    private WeatherReportTimeOfDay timeOfDay;

}
