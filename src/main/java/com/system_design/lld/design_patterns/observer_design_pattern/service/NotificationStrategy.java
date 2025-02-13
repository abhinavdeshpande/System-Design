package com.system_design.lld.design_patterns.observer_design_pattern.service;

import com.system_design.lld.design_patterns.observer_design_pattern.entity.UserEntity;
import com.system_design.lld.design_patterns.observer_design_pattern.util.NotificationMode;

public interface NotificationStrategy {
    public NotificationMode notifyUser(UserEntity user);
}
