package com.system_design.lld.design_patterns.observer_design_pattern.rest_controller;

import com.system_design.lld.design_patterns.observer_design_pattern.dto.ItemDto;
import com.system_design.lld.design_patterns.observer_design_pattern.service.ManageItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/observer-design-pattern/item")
public class ItemController {

    @Autowired
    ManageItem manageItem;

    @PostMapping("/add")
    public ResponseEntity<ItemDto> addItem(@RequestBody ItemDto item) {
        return manageItem.addItem(item);
    }

    @PutMapping("/remove")
    public ResponseEntity<ItemDto> removeItem(@RequestBody ItemDto item) {
        return manageItem.removeItem(item);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ItemDto>> getAllItems() {
        return manageItem.getAllItems();
    }

    @PutMapping("/detail")
    public ResponseEntity<ItemDto> updateItemDetail(@RequestBody ItemDto item) {
        return manageItem.updateItemDetail(item);
    }

    @GetMapping("/detail")
    public ResponseEntity<Optional<ItemDto>> getItemDetail(@RequestParam String itemId) {
        return manageItem.getItemDetail(itemId);
    }
}
