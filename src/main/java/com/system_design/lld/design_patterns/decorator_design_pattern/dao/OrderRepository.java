package com.system_design.lld.design_patterns.decorator_design_pattern.dao;

import com.system_design.lld.design_patterns.decorator_design_pattern.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<OrderEntity, String> {
}

