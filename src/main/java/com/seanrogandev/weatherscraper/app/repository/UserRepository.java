package com.seanrogandev.weatherscraper.app.repository;

import com.seanrogandev.weatherscraper.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u.id FROM users u WHERE u.passwordHash = ?1 AND u.email =?2")
    Long getIdOfExistingUser(String passwordHash, String email);


}
