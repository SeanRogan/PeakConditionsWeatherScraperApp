package com.seanrogandev.weatherscraper.app.controller;

import com.seanrogandev.weatherscraper.app.entities.User;
import com.seanrogandev.weatherscraper.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

public class UserProfileController {
    @Autowired
    private UserRepository repo;
    @GetMapping("/profile")
    ModelAndView returnProfileView() {
        ModelAndView mav = new ModelAndView("registration-form");
        mav.addObject("user", new User());
        return mav;
    }
    @PostMapping("/register")
    String createNewProfile(@ModelAttribute User userData) {
        //save the new user data to the user repository
        repo.save(userData);
        //redirect the user to their profile
        return "redirect:/";
        //need fav weather,
    }
}

