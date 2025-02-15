package com.system_design.lld.design_patterns.observer_design_pattern.dao;

import com.system_design.lld.design_patterns.observer_design_pattern.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends MongoRepository<UserEntity, String> {
    List<UserEntity> findAllByItemId(String itemId);
}
