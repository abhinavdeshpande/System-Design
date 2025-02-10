package com.system_design.lld.design_patterns.observer_design_pattern.service;

import com.system_design.lld.design_patterns.observer_design_pattern.dto.ItemDto;
import com.system_design.lld.design_patterns.observer_design_pattern.dto.UserDto;
import com.system_design.lld.design_patterns.observer_design_pattern.util.NotificationMode;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ManageItem {
    public ResponseEntity<ItemDto> addItem(ItemDto item);

    public ResponseEntity<ItemDto> removeItem(ItemDto item);

    public ResponseEntity<List<ItemDto>> getAllItems();

    public ResponseEntity<Map<UserDto, List<NotificationMode>>> updateItemDetail(ItemDto item);

    public ResponseEntity<Optional<ItemDto>> getItemDetail(String itemId);
}
