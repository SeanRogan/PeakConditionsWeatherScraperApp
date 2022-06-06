package com.seanrogandev.weatherscraper.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping({"/","/home"})
    ModelAndView homeView() {
        ModelAndView mav = new ModelAndView("home-view");
        return mav;
    }

    @GetMapping("/error")
    ModelAndView getErrorView() {
        ModelAndView mav = new ModelAndView("error-page-view");
        return mav;
    }

}
