package com.seanrogandev.weatherscraper.app.controller;

import com.seanrogandev.weatherscraper.app.entities.User;
import com.seanrogandev.weatherscraper.app.repository.UserRepository;
import com.seanrogandev.weatherscraper.app.service.LoginService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
@Data
@Controller
public class UserLoginController {
    /**
     * The User repository.
     */
    final UserRepository userRepository;
    final LoginService loginService;
    /**
     * Instantiates a new Login controller.
     *
     * @param userRepository the user repository
     */
    @Autowired
    public UserLoginController(UserRepository userRepository, LoginService loginService) {
        this.userRepository = userRepository;
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute(name = "user") User user,
                        Model model, final HttpServletResponse response) {
        String redirect = loginService.login(user, model, response);
        return redirect;
    }

    /**
     * Get Request to request login-form view
     *
     * @return returns the login-form.html view
     */
    @GetMapping("/login")
    public ModelAndView getLoginForm() {
        ModelAndView mav = new ModelAndView("login-form");
        mav.addObject("user" ,new User());
        return mav;
    }
}
