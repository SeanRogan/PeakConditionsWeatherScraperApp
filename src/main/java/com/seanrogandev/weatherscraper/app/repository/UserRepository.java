package com.seanrogandev.weatherscraper.app.repository;

import com.seanrogandev.weatherscraper.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
}
