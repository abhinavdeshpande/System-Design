package com.system_design.lld.design_patterns.observer_design_pattern.service;

import com.system_design.lld.design_patterns.observer_design_pattern.entity.UserEntity;
import com.system_design.lld.design_patterns.observer_design_pattern.util.NotificationMode;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ItemSubject {
    public ResponseEntity<UserEntity> registerObserver(UserEntity user);
    public void deregisterObserver(UserEntity user);
    public Map<UserEntity, List<NotificationMode>> notifyObservers(String itemId);
}
