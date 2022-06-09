package com.seanrogandev.weatherscraper.app.controller;

import com.seanrogandev.weatherscraper.app.entities.User;
import com.seanrogandev.weatherscraper.app.entities.UserProfile;
import com.seanrogandev.weatherscraper.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserProfileController {

    final private UserRepository repo;
    @Autowired
    UserProfileController(UserRepository repo) {
        this.repo = repo;
    }
    @GetMapping("/profile")
    ModelAndView returnProfileView(
            @ModelAttribute(name = "profile")
            UserProfile profile,
            HttpServletRequest req) {
        ModelAndView mav = new ModelAndView("profile-view");
        for(Cookie cookies : req.getCookies()){
            if(cookies.getName().equals("userId")){
                mav.addObject("userProfile", repo.getById(Long.valueOf(cookies.getValue())));
            }
        }
        return mav;
    }
    @GetMapping("register/create-profile")
    ModelAndView getCreateProfileView() {
        ModelAndView mav = new ModelAndView("new-profile-form");
        mav.addObject("userProfile" , new UserProfile());
        return mav;
    }
    @PostMapping("register/create-profile")
    String createNewProfile(@ModelAttribute(name = "user") User userData, HttpServletResponse res) {
        //save the new user data to the user repository
        res.addCookie(new Cookie("userId",String.valueOf(userData.getId())));
        repo.save(userData);
        //redirect the user to their profile
        return "redirect:/profile";
        //need fav weather,

    }

    @GetMapping("/error")
    ModelAndView getErrorView() {
        ModelAndView mav = new ModelAndView("error-page-view");
        return mav;
    }

}

