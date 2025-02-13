package com.system_design.lld.design_patterns.observer_design_pattern.service_impl;

import com.system_design.lld.design_patterns.observer_design_pattern.dao.ItemDao;
import com.system_design.lld.design_patterns.observer_design_pattern.entity.ItemEntity;
import com.system_design.lld.design_patterns.observer_design_pattern.entity.UserEntity;
import com.system_design.lld.design_patterns.observer_design_pattern.service.ItemSubject;
import com.system_design.lld.design_patterns.observer_design_pattern.service.ManageItem;
import com.system_design.lld.design_patterns.observer_design_pattern.util.NotificationMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class ManageItemImpl implements ManageItem {

    @Autowired
    ItemDao itemDao;
    @Autowired
    ItemSubject itemSubject;

    @Override
    public ResponseEntity<ItemEntity> addItem(ItemEntity item) {
        return new ResponseEntity<>(itemDao.insert(item), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ItemEntity> removeItem(ItemEntity item) {
        return new ResponseEntity<>(itemDao.save(item), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ItemEntity>> getAllItems() {
        return new ResponseEntity<>(itemDao.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<UserEntity, List<NotificationMode>>> updateItemDetail(ItemEntity item) {
        ItemEntity itemPriorUpdate = Objects.requireNonNull(getItemDetail(item.getId()).getBody()).get();
        ItemEntity itemAfterUpdate = itemDao.save(item);
        if (itemAfterUpdate.isActive() && itemPriorUpdate.getItemQuantity() == 0 && !itemPriorUpdate.isActive()) {
            return new ResponseEntity<>(itemSubject.notifyObservers(item.getId()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Optional<ItemEntity>> getItemDetail(String itemId) {
        return new ResponseEntity<>(itemDao.findById(itemId), HttpStatus.OK);
    }
}
