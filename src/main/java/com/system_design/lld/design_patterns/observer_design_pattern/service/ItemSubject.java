package com.system_design.lld.design_patterns.observer_design_pattern.service;

import com.system_design.lld.design_patterns.observer_design_pattern.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface ItemSubject {
    public ResponseEntity<UserDto> registerObserver(UserDto user);
    public void deregisterObserver(UserDto user);
    public void notifyObservers(String itemId);
}
