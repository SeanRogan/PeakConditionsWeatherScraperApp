package com.seanrogandev.weatherscraper.app.repository;


import com.seanrogandev.weatherscraper.app.entities.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProfileRepository extends JpaRepository<UserProfile, Long> {
}
