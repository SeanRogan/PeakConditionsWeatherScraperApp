package com.seanrogandev.weatherscraper.app.repository;

import com.seanrogandev.weatherscraper.app.entities.MountainPeak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MountainPeakRepository extends JpaRepository<MountainPeak, Long> {
    @Query("SELECT m FROM mountain_peak m WHERE m.peakId = ?1 AND m.rangeId = ?2" )
    MountainPeak getPeakByPeakAndRangeId(Long peakId, Long rangeId);
}
