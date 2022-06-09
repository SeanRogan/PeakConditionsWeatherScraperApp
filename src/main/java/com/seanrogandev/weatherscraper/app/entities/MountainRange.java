package com.seanrogandev.weatherscraper.app.entities;

import lombok.*;

import javax.persistence.*;

@Entity(name = "mountain_ranges")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MountainRange {
    @Id //for primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "range_id")
    private Long rangeId;

    @Column(name = "range_name")
    private String rangeName;

    @Column(name = "uri")
    private String uri;

    public MountainRange(String rangeName, String uri) {
        this.rangeName = rangeName;
        this.uri = uri;
    }
}
