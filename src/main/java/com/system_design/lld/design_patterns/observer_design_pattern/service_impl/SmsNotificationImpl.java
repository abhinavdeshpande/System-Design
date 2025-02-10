package com.system_design.lld.design_patterns.observer_design_pattern.service_impl;

import com.system_design.lld.design_patterns.observer_design_pattern.dto.UserDto;
import com.system_design.lld.design_patterns.observer_design_pattern.service.NotificationStrategy;
import com.system_design.lld.design_patterns.observer_design_pattern.util.NotificationMode;
import org.springframework.stereotype.Service;

@Service
public class SmsNotificationImpl implements NotificationStrategy {
    @Override
    public NotificationMode notifyUser(UserDto user) {
        System.out.println("SMS Notification triggered for user: " + user);
        // Logic to send SMS notification
        return NotificationMode.SMS;
    }
}
