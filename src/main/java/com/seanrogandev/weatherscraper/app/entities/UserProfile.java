package com.seanrogandev.weatherscraper.app.entities;

import com.seanrogandev.weatherscraper.app.model.WeatherConditions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "user_profiles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long profileId;
        @Column(name ="owner")
        @OneToOne(mappedBy = "profile")
        private User owner;


        private Integer maxWindSpeed;
        private Integer maxTempPreference;
        private Integer minTempPreference;
        private Enum<WeatherConditions> weatherConditionPreference;



}
