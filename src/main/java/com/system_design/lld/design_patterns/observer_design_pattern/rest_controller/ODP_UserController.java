package com.system_design.lld.design_patterns.observer_design_pattern.rest_controller;

import com.system_design.lld.design_patterns.observer_design_pattern.entity.UserEntity;
import com.system_design.lld.design_patterns.observer_design_pattern.service.ItemSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/observer-design-pattern/user")
public class ODP_UserController {

    @Autowired
    ItemSubject itemSubject;

    @PostMapping("/registration")
    public ResponseEntity<UserEntity> registerObserver(@RequestBody UserEntity user) {
        return itemSubject.registerObserver(user);
    }

    @DeleteMapping("/deregistration")
    public void removeObserver(@RequestBody UserEntity user) {
        itemSubject.deregisterObserver(user);
    }
}
