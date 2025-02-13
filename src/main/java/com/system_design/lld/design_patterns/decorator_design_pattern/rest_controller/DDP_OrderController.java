package com.system_design.lld.design_patterns.decorator_design_pattern.rest_controller;

import com.system_design.lld.design_patterns.decorator_design_pattern.dto.OrderRequestDTO;
import com.system_design.lld.design_patterns.decorator_design_pattern.dto.OrderResponseDTO;
import com.system_design.lld.design_patterns.decorator_design_pattern.service.OrderService;
import com.system_design.lld.design_patterns.decorator_design_pattern.service_impl.OrderServiceImpl;
import com.system_design.lld.design_patterns.decorator_design_pattern.util.DiscountDecorator;
import com.system_design.lld.design_patterns.decorator_design_pattern.util.GiftWrapDecorator;
import com.system_design.lld.design_patterns.decorator_design_pattern.util.PriorityOrderDecorator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/decorator-design-pattern/order")
public class DDP_OrderController {
    private final OrderServiceImpl orderServiceImpl;

    public DDP_OrderController(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    @PostMapping("/process")
    public ResponseEntity<OrderResponseDTO> processOrder(@RequestBody OrderRequestDTO orderRequest) {
        OrderService orderService = orderServiceImpl;
        for (String decorator : orderRequest.getDecorators()) {
            orderService = switch (decorator.toLowerCase()) {
                case "discount" -> new DiscountDecorator(orderService);
                case "priority" -> new PriorityOrderDecorator(orderService);
                case "gift wrap" -> new GiftWrapDecorator(orderService);
                default -> orderService;
            };
        }

        // Process the order
        return orderService.processOrder(orderRequest);
    }
}
