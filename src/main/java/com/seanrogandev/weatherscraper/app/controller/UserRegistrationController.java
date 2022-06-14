package com.seanrogandev.weatherscraper.app.controller;

import com.seanrogandev.weatherscraper.app.security.SecurityManager;
import com.seanrogandev.weatherscraper.app.entities.User;
import com.seanrogandev.weatherscraper.app.repository.UserRepository;
import com.seanrogandev.weatherscraper.app.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Controller
public class UserRegistrationController {
    RegistrationService registrationService = new RegistrationService();
    @GetMapping("/register")
    ModelAndView registerUserView() {
        ModelAndView mav = new ModelAndView("registration-form");
        mav.addObject("user", new User());
        return mav;
    }
    @PostMapping("/register")
    String registerNewUser(@ModelAttribute User userData , HttpServletResponse res) {
       return registrationService.registerNewUser(userData,res);
    }
}

