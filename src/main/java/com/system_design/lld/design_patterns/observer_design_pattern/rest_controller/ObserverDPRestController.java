package com.system_design.lld.design_patterns.observer_design_pattern.rest_controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObserverDPRestController {

    @GetMapping("/observer-design-pattern/")
    public String learnObserverDesignPattern() {
        return "learning Observer Design Pattern";
    }
}
