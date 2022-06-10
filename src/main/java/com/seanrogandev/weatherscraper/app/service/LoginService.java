package com.seanrogandev.weatherscraper.app.service;

import com.seanrogandev.weatherscraper.app.entities.User;
import com.seanrogandev.weatherscraper.app.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class LoginService {
    UserRepository userRepository;

    /**
     * login method
     *
     * @param user the user object
     * @param model the page model
     * @param response the HttpServletResponse
     * @return returns a String, "home" or "login" to redirect the user
     */

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

}
