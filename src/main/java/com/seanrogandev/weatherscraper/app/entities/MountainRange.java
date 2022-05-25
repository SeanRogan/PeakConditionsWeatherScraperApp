package com.seanrogandev.weatherscraper.app.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity(name = "mountain_ranges")
public class MountainRange {
    @Id //for primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long rangeId;
    @Getter
    @Setter
    @Column(name = "range_name")
    private String rangeName;
    @Getter
    @Setter
    @Column(name = "number_of_peaks")
    private int numberOfPeaks;

}
