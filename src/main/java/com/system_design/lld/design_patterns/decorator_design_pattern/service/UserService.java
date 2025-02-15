package com.system_design.lld.design_patterns.decorator_design_pattern.service;

import com.system_design.lld.design_patterns.decorator_design_pattern.dto.UserRequestDTO;
import com.system_design.lld.design_patterns.decorator_design_pattern.dto.UserResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<UserResponseDTO> createUser(UserRequestDTO user);
    ResponseEntity<UserResponseDTO> updateUser(UserRequestDTO user);
    ResponseEntity<UserResponseDTO> deleteUser(UserRequestDTO user);
    ResponseEntity<UserResponseDTO> getUser(String userId);
    ResponseEntity<List<UserResponseDTO>> getAllUsers();
}
