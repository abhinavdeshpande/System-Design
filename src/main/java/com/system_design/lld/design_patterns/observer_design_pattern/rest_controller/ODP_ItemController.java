package com.system_design.lld.design_patterns.observer_design_pattern.rest_controller;

import com.system_design.lld.design_patterns.observer_design_pattern.entity.ItemEntity;
import com.system_design.lld.design_patterns.observer_design_pattern.entity.UserEntity;
import com.system_design.lld.design_patterns.observer_design_pattern.service.ManageItem;
import com.system_design.lld.design_patterns.observer_design_pattern.util.NotificationMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/observer-design-pattern/item")
public class ODP_ItemController {

    @Autowired
    ManageItem manageItem;

    @PostMapping("/add")
    public ResponseEntity<ItemEntity> addItem(@RequestBody ItemEntity item) {
        return manageItem.addItem(item);
    }

    @PutMapping("/remove")
    public ResponseEntity<ItemEntity> removeItem(@RequestBody ItemEntity item) {
        return manageItem.removeItem(item);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ItemEntity>> getAllItems() {
        return manageItem.getAllItems();
    }

    @PutMapping("/detail")
    public ResponseEntity<Map<UserEntity, List<NotificationMode>>> updateItemDetail(@RequestBody ItemEntity item) {
        return manageItem.updateItemDetail(item);
    }

    @GetMapping("/detail")
    public ResponseEntity<Optional<ItemEntity>> getItemDetail(@RequestParam String itemId) {
        return manageItem.getItemDetail(itemId);
    }
}
