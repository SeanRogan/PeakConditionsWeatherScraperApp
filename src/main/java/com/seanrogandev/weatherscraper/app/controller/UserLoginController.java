package com.seanrogandev.weatherscraper.app.controller;

import com.seanrogandev.weatherscraper.app.entities.User;
import com.seanrogandev.weatherscraper.app.repository.UserRepository;
import com.seanrogandev.weatherscraper.app.security.SecurityManager;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
@Data
@Controller
public class UserLoginController {
    /**
     * The User repository.
     */
    final UserRepository userRepository;
    final SecurityManager securityManager = new SecurityManager();
    /**
     * Instantiates a new Login controller.
     *
     * @param userRepository the user repository
     */
    UserLoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * login method
     *
     * @param user the user object
     * @param model the page model
     * @param response the HttpServletResponse
     * @return returns a String, "home" or "login" either the home view
     */

    @PostMapping("/login")
    public String login(@ModelAttribute(name = "user") User user,
                        Model model, final HttpServletResponse response) {

        if (null != userRepository.getIdOfExistingUser(
                 user.getPasswordHash(), user.getEmail())) {

            Cookie loginCookie = new Cookie("login", "true");
            loginCookie.setMaxAge(7 * 24 * 60 * 60);
            response.addCookie(loginCookie);
            return "redirect:/profile";
        }

        Cookie cookie = new Cookie("login", "false");
        cookie.setMaxAge(7 * 24 * 60 * 60);
        response.addCookie(cookie);
        model.addAttribute("invalidCredentials", true);
        return "redirect:/login";
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
