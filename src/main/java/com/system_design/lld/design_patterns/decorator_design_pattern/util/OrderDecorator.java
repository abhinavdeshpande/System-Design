package com.system_design.lld.design_patterns.decorator_design_pattern.util;

import com.system_design.lld.design_patterns.decorator_design_pattern.dto.OrderRequestDTO;
import com.system_design.lld.design_patterns.decorator_design_pattern.dto.OrderResponseDTO;
import com.system_design.lld.design_patterns.decorator_design_pattern.service.OrderService;
import org.springframework.http.ResponseEntity;

public abstract class OrderDecorator implements OrderService {
    protected OrderService orderService;

    public OrderDecorator(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public ResponseEntity<OrderResponseDTO> processOrder(OrderRequestDTO order) {
        return orderService.processOrder(order);
    }
}
