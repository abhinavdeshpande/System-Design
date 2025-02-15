package com.system_design.lld.design_patterns.decorator_design_pattern.dao;

import com.system_design.lld.design_patterns.decorator_design_pattern.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
}

