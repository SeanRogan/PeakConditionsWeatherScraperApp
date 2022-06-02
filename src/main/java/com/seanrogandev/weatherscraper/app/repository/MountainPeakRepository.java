package com.seanrogandev.weatherscraper.app.repository;

import com.seanrogandev.weatherscraper.app.entities.MountainPeak;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MountainPeakRepository extends JpaRepository<MountainPeak, Long> {
}
