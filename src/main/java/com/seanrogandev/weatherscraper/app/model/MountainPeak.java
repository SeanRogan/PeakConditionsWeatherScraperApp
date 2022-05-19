package com.seanrogandev.weatherscraper.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Mountain_peaks")
public class MountainPeak {
    @Id
    @Column(name = "peak_id")
    private int peakId;
    @Column(name = "peak_name")
    private String peakName;
    @Column(name = "elevation")
    private int elevation;
    @Column(name = "home_state")
    private String homeState;
    @Column(name = "day_hike_friendly")
    private boolean dayHikeFriendly;

}
