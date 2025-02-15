package com.system_design.lld.design_patterns.observer_design_pattern.service_impl;

import com.system_design.lld.design_patterns.observer_design_pattern.dao.UserDao;
import com.system_design.lld.design_patterns.observer_design_pattern.entity.UserEntity;
import com.system_design.lld.design_patterns.observer_design_pattern.service.UserObserver;
import com.system_design.lld.design_patterns.observer_design_pattern.service.ItemSubject;
import com.system_design.lld.design_patterns.observer_design_pattern.util.NotificationMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemSubjectImpl implements ItemSubject {

    @Autowired
    UserDao userDao;
    @Autowired
    UserObserver userObserver;

    @Override
    public ResponseEntity<UserEntity> registerObserver(UserEntity user) {
        return new ResponseEntity<>(userDao.insert(user), HttpStatus.OK);
    }

    @Override
    public void deregisterObserver(UserEntity user) {
        userDao.delete(user);
    }

    @Override
    public  Map<UserEntity, List<NotificationMode>> notifyObservers(String itemId) {
        List<UserEntity> users = userDao.findAllByItemId(itemId);
        Map<UserEntity, List<NotificationMode>> userNotificationModeMap = new HashMap<>();
        for (UserEntity user : users) {
            List<NotificationMode> notificationModes = new ArrayList<>();
            notificationModes = userObserver.notify(user);
            userNotificationModeMap.put(user, notificationModes);
        }
        return userNotificationModeMap;
    }
}
