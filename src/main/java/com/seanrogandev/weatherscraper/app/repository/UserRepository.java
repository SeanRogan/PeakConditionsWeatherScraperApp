package com.seanrogandev.weatherscraper.app.repository;

import com.seanrogandev.weatherscraper.app.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    List<User> getUsersById(Long id, Pageable pageable);
    List<User> getAllUsers(Pageable pageable);
}
