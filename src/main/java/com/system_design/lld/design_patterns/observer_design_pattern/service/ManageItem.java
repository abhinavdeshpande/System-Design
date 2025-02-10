package com.system_design.lld.design_patterns.observer_design_pattern.service;

import com.system_design.lld.design_patterns.observer_design_pattern.dto.ItemDto;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

public interface ManageItem {
    public ResponseEntity<ItemDto> addItem(ItemDto item);

    public ResponseEntity<ItemDto> removeItem(ItemDto item);

    public ResponseEntity<List<ItemDto>> getAllItems();

    public ResponseEntity<ItemDto> updateItemDetail(ItemDto item);

    public ResponseEntity<Optional<ItemDto>> getItemDetail(String itemId);
}
