package com.system_design.lld.design_patterns.observer_design_pattern.service_impl;

import com.system_design.lld.design_patterns.observer_design_pattern.dao.ItemDao;
import com.system_design.lld.design_patterns.observer_design_pattern.dto.ItemDto;
import com.system_design.lld.design_patterns.observer_design_pattern.dto.UserDto;
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
    public ResponseEntity<ItemDto> addItem(ItemDto item) {
        return new ResponseEntity<>(itemDao.insert(item), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ItemDto> removeItem(ItemDto item) {
        return new ResponseEntity<>(itemDao.save(item), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ItemDto>> getAllItems() {
        return new ResponseEntity<>(itemDao.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<UserDto, List<NotificationMode>>> updateItemDetail(ItemDto item) {
        ItemDto itemPriorUpdate = Objects.requireNonNull(getItemDetail(item.getId()).getBody()).get();
        ItemDto itemAfterUpdate = itemDao.save(item);
        if (itemAfterUpdate.isActive() && itemPriorUpdate.getItemQuantity() == 0 && !itemPriorUpdate.isActive()) {
            return new ResponseEntity<>(itemSubject.notifyObservers(item.getId()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Optional<ItemDto>> getItemDetail(String itemId) {
        return new ResponseEntity<>(itemDao.findById(itemId), HttpStatus.OK);
    }
}
