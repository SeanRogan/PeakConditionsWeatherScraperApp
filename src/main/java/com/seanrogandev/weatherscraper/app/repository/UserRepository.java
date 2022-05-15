package com.seanrogandev.weatherscraper.app.repository;

import com.seanrogandev.weatherscraper.app.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
}
