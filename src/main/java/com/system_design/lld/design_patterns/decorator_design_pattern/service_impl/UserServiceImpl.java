package com.system_design.lld.design_patterns.decorator_design_pattern.service_impl;

import com.system_design.lld.design_patterns.decorator_design_pattern.dao.UserRepository;
import com.system_design.lld.design_patterns.decorator_design_pattern.dto.UserRequestDTO;
import com.system_design.lld.design_patterns.decorator_design_pattern.dto.UserResponseDTO;
import com.system_design.lld.design_patterns.decorator_design_pattern.entity.UserEntity;
import com.system_design.lld.design_patterns.decorator_design_pattern.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<UserResponseDTO> createUser(UserRequestDTO user) {
        UserEntity userEntity = new UserEntity(UUID.randomUUID().toString(), user.getName(), user.getEmail(), user.getMobileNo(), null, true);
        userEntity = userRepository.insert(userEntity);
        UserResponseDTO response = new UserResponseDTO(userEntity.getId(), userEntity.getName(), userEntity.getEmail(), userEntity.getMobileNo(), "User created successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserResponseDTO> updateUser(UserRequestDTO user) {
        Optional<UserEntity> existingUser = userRepository.findById(user.getUserId());
        UserResponseDTO response = new UserResponseDTO();
        if (existingUser.isEmpty()) {
            response.setMessage("User not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        UserEntity userEntity = new UserEntity(user.getUserId(), user.getName(), user.getEmail(), user.getMobileNo(), existingUser.get().getOrderIds(), existingUser.get().isActive());
        userEntity = userRepository.save(userEntity);
        response = new UserResponseDTO(userEntity.getId(), userEntity.getName(), userEntity.getEmail(), userEntity.getMobileNo(), "User updated successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserResponseDTO> deleteUser(UserRequestDTO user) {
        Optional<UserEntity> existingUser = userRepository.findById(user.getUserId());
        UserResponseDTO response = new UserResponseDTO();
        if (existingUser.isEmpty()) {
            response.setMessage("User not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        UserEntity userEntity = new UserEntity(user.getUserId(), user.getName(), user.getEmail(), user.getMobileNo(), existingUser.get().getOrderIds(), false);
        userEntity = userRepository.save(userEntity);
        response = new UserResponseDTO(userEntity.getId(), userEntity.getName(), userEntity.getEmail(), userEntity.getMobileNo(), "User deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserResponseDTO> getUser(String userId) {
        Optional<UserEntity> user = userRepository.findById(userId);
        UserResponseDTO response = new UserResponseDTO();
        if (user.isEmpty()) {
            response.setMessage("User not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response = new UserResponseDTO(user.get().getId(), user.get().getName(), user.get().getEmail(), user.get().getMobileNo(), "User found");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        List<UserResponseDTO> response = users.stream().map(user -> new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getMobileNo(), null)).toList();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
