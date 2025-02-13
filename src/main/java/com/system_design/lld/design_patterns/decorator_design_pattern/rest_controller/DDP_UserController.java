package com.system_design.lld.design_patterns.decorator_design_pattern.rest_controller;

import com.system_design.lld.design_patterns.decorator_design_pattern.dto.UserRequestDTO;
import com.system_design.lld.design_patterns.decorator_design_pattern.dto.UserResponseDTO;
import com.system_design.lld.design_patterns.decorator_design_pattern.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/decorator-design-pattern/user")
public class DDP_UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO user) {
        return userService.createUser(user);
    }

    @PutMapping("/update")
    public ResponseEntity<UserResponseDTO> updateUser(@RequestBody UserRequestDTO user) {
        return userService.updateUser(user);
    }

    @PutMapping("/delete")
    public ResponseEntity<UserResponseDTO> deleteUser(@RequestBody UserRequestDTO user) {
        return userService.deleteUser(user);
    }

    @GetMapping("/get")
    public ResponseEntity<UserResponseDTO> getUser(@RequestParam String userId) {
        return userService.getUser(userId);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return userService.getAllUsers();
    }
}
