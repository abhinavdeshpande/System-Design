package com.system_design.lld.design_patterns.observer_design_pattern.rest_controller;

import com.system_design.lld.design_patterns.observer_design_pattern.dto.UserDto;
import com.system_design.lld.design_patterns.observer_design_pattern.service.ItemSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/observer-design-pattern/user")
public class UserController {

    @Autowired
    ItemSubject itemSubject;

    @PostMapping("/registration")
    public ResponseEntity<UserDto> registerObserver(@RequestBody UserDto user) {
        return itemSubject.registerObserver(user);
    }

    @DeleteMapping("/deregistration")
    public void removeObserver(@RequestBody UserDto user) {
        itemSubject.deregisterObserver(user);
    }
}
