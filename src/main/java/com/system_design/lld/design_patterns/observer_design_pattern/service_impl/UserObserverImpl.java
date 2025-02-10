package com.system_design.lld.design_patterns.observer_design_pattern.service_impl;

import com.system_design.lld.design_patterns.observer_design_pattern.dto.UserDto;
import com.system_design.lld.design_patterns.observer_design_pattern.service.NotificationStrategy;
import com.system_design.lld.design_patterns.observer_design_pattern.service.UserObserver;
import com.system_design.lld.design_patterns.observer_design_pattern.util.NotificationMode;
import org.springframework.stereotype.Service;

@Service
public class UserObserverImpl implements UserObserver {

    private NotificationStrategy notificationStrategy;

    @Override
    public void notify(UserDto user) {
        for (NotificationMode notificationMode : user.getNotificationModes()) {
            switch (notificationMode) {
                case NotificationMode.SMS:
                    notificationStrategy = new SmsNotificationImpl();
                    break;
                case NotificationMode.EMAIL:
                    notificationStrategy = new EmailNotificationImpl();
                    break;
                case NotificationMode.WHATSAPP:
                    notificationStrategy = new WhatsAppNotificationImpl();
                    break;
            }
            notificationStrategy.notifyUser(user);
        }
    }
}
