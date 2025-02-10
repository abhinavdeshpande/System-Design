package com.system_design.lld.design_patterns.observer_design_pattern.dao;

import com.system_design.lld.design_patterns.observer_design_pattern.dto.UserDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends MongoRepository<UserDto, String> {
    List<UserDto> findAllByItemId(String itemId);
}
