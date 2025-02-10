package com.system_design.lld.design_patterns.observer_design_pattern.service;

import com.system_design.lld.design_patterns.observer_design_pattern.dto.UserDto;

public interface NotificationStrategy {
    public void notifyUser(UserDto user);
}
