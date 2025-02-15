package com.system_design.lld.design_patterns.decorator_design_pattern.service;

import com.system_design.lld.design_patterns.decorator_design_pattern.dto.OrderRequestDTO;
import com.system_design.lld.design_patterns.decorator_design_pattern.dto.OrderResponseDTO;
import org.springframework.http.ResponseEntity;

public interface OrderService {
    ResponseEntity<OrderResponseDTO> processOrder(OrderRequestDTO order);
}
