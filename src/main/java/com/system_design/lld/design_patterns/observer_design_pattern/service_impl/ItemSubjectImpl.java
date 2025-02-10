package com.system_design.lld.design_patterns.observer_design_pattern.service_impl;

import com.system_design.lld.design_patterns.observer_design_pattern.dao.UserDao;
import com.system_design.lld.design_patterns.observer_design_pattern.dto.UserDto;
import com.system_design.lld.design_patterns.observer_design_pattern.service.UserObserver;
import com.system_design.lld.design_patterns.observer_design_pattern.service.ItemSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemSubjectImpl implements ItemSubject {

    @Autowired
    UserDao userDao;
    @Autowired
    UserObserver userObserver;

    @Override
    public ResponseEntity<UserDto> registerObserver(UserDto user) {
        return new ResponseEntity<>(userDao.insert(user), HttpStatus.OK);
    }

    @Override
    public void deregisterObserver(UserDto user) {
        userDao.delete(user);
    }

    @Override
    public void notifyObservers(String itemId) {
        List<UserDto> users = userDao.findAllByItemId(itemId);
        for (UserDto user : users) {
            userObserver.notify(user);
        }
    }
}
