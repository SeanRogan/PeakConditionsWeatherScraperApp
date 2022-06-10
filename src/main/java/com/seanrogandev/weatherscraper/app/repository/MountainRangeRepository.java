package com.seanrogandev.weatherscraper.app.repository;


import com.seanrogandev.weatherscraper.app.entities.MountainRange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface MountainRangeRepository extends JpaRepository<MountainRange, Long> {

    @Query("SELECT r FROM mountain_ranges r WHERE r.uri = ?1 AND r.rangeName = ?2")
    Boolean findIfRangeExists(String uri, String rangeName);
}
