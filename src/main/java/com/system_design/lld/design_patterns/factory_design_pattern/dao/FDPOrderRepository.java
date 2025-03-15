package com.system_design.lld.design_patterns.factory_design_pattern.dao;

import com.system_design.lld.design_patterns.factory_design_pattern.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FDPOrderRepository extends MongoRepository<OrderEntity, String> {
}
