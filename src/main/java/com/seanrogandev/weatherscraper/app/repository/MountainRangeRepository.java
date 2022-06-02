package com.seanrogandev.weatherscraper.app.repository;


import com.seanrogandev.weatherscraper.app.entities.MountainRange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MountainRangeRepository extends JpaRepository<MountainRange, Long> {
}
