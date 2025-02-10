package com.system_design.lld.design_patterns.observer_design_pattern.service;

import com.system_design.lld.design_patterns.observer_design_pattern.dto.UserDto;
import com.system_design.lld.design_patterns.observer_design_pattern.util.NotificationMode;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ItemSubject {
    public ResponseEntity<UserDto> registerObserver(UserDto user);
    public void deregisterObserver(UserDto user);
    public Map<UserDto, List<NotificationMode>> notifyObservers(String itemId);
}
