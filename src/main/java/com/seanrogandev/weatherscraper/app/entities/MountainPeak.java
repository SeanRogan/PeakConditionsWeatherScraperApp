package com.seanrogandev.weatherscraper.app.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="mountain_peaks")
public class MountainPeak {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Column(name = "peak_id")
    private Long peakId;
    @Getter
    @Setter
    @Column(name = "peak_name")
    private String peakName;
    @Getter
    @Setter
    @Column(name = "elevation")
    private int elevation;
    @Getter
    @Setter
    @Column(name = "home_state")
    private String homeState;
    @Getter
    @Setter
    @Column(name = "day_hike_friendly")
    private boolean dayHikeFriendly;

}
