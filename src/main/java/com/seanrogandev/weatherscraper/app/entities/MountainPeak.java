package com.seanrogandev.weatherscraper.app.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity(name="mountain_peak")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class MountainPeak {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "peak_id")
    private Long peakId;

    @Column(name = "peak_name")
    private String peakName;

    @Column(name = "elevation")
    private int elevation;

    @Column(name = "home_state")
    private String homeState;

    @JoinColumn(name = "range_id")
    private Long rangeId;

    @Column(name = "day_hike_friendly")
    private boolean dayHikeFriendly;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MountainPeak that = (MountainPeak) o;
        return peakId != null && Objects.equals(peakId, that.peakId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
