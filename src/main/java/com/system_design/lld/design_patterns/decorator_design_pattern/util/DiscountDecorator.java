package com.system_design.lld.design_patterns.decorator_design_pattern.util;

import com.system_design.lld.design_patterns.decorator_design_pattern.dto.OrderRequestDTO;
import com.system_design.lld.design_patterns.decorator_design_pattern.dto.OrderResponseDTO;
import com.system_design.lld.design_patterns.decorator_design_pattern.service.OrderService;
import org.springframework.http.ResponseEntity;

public class DiscountDecorator extends OrderDecorator {
    public DiscountDecorator(OrderService orderService) {
        super(orderService);
    }

    @Override
    public ResponseEntity<OrderResponseDTO> processOrder(OrderRequestDTO order) {
        order.setPrice(order.getPrice() * 0.9); // Apply a 10% discount
        return super.processOrder(order);
    }
}

