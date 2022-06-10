package com.seanrogandev.weatherscraper.app.service;

import com.seanrogandev.weatherscraper.app.entities.User;
import com.seanrogandev.weatherscraper.app.repository.UserRepository;
import com.seanrogandev.weatherscraper.app.security.SecurityManager;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
@NoArgsConstructor
@Service
public class RegistrationService {
    SecurityManager securityManager = new SecurityManager();
    UserRepository userRepo;
    @Autowired
    RegistrationService(UserRepository userRepo) {this.userRepo = userRepo;}
    public String registerNewUser(User userData, HttpServletResponse res) {
        userData.setPasswordHash(securityManager.encryptString(userData.getPasswordHash()));
        //save the new user data to the user repository
        userRepo.save(userData);
        //add cookie of user id for profile fetching
        res.addCookie(new Cookie("userId",String.valueOf(userData.getId())));
        //redirect the user to their profile
        return "redirect:/register/create-profile";
    }
}
