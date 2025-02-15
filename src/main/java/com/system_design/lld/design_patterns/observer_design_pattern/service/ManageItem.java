package com.system_design.lld.design_patterns.observer_design_pattern.service;

import com.system_design.lld.design_patterns.observer_design_pattern.entity.ItemEntity;
import com.system_design.lld.design_patterns.observer_design_pattern.entity.UserEntity;
import com.system_design.lld.design_patterns.observer_design_pattern.util.NotificationMode;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ManageItem {
    public ResponseEntity<ItemEntity> addItem(ItemEntity item);

    public ResponseEntity<ItemEntity> removeItem(ItemEntity item);

    public ResponseEntity<List<ItemEntity>> getAllItems();

    public ResponseEntity<Map<UserEntity, List<NotificationMode>>> updateItemDetail(ItemEntity item);

    public ResponseEntity<Optional<ItemEntity>> getItemDetail(String itemId);
}
