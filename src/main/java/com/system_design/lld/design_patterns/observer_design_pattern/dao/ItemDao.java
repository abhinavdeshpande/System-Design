package com.system_design.lld.design_patterns.observer_design_pattern.dao;

import com.system_design.lld.design_patterns.observer_design_pattern.entity.ItemEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends MongoRepository<ItemEntity, String> {
}
