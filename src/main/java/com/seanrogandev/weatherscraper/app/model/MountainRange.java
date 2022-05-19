package com.seanrogandev.weatherscraper.app.model;

import javax.persistence.*;

@Entity
public class MountainRange {
    @Id //for primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long rangeId;

    @Column(name = "range_name")
    private String rangeName;

    @Column(name = "number_of_peaks")
    private int numberOfPeaks;

}
