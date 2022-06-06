package com.seanrogandev.weatherscraper.app.entities;

import com.seanrogandev.weatherscraper.app.model.WeatherConditions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "user_profiles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long profileId;

        //FK should be User.id
        @OneToOne(cascade = CascadeType.ALL)
        @MapsId
        private User user;

        private Integer maxWindSpeedPreference;
        private Integer maxTempPreference;
        private Integer minTempPreference;
        @Enumerated(EnumType.STRING)
        private WeatherConditions weatherConditionPreference;



}
