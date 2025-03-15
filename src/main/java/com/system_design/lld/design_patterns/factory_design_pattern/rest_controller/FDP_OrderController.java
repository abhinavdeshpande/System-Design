package com.system_design.lld.design_patterns.factory_design_pattern.rest_controller;

import com.system_design.lld.design_patterns.factory_design_pattern.dto.OrderRequestDTO;
import com.system_design.lld.design_patterns.factory_design_pattern.dto.OrderResponseDTO;
import com.system_design.lld.design_patterns.factory_design_pattern.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/factory-design-pattern/order")
public class FDP_OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/process")
    public ResponseEntity<OrderResponseDTO> processOrder(@RequestBody OrderRequestDTO requestDTO) {
        OrderResponseDTO responseDTO = orderService.processOrder(requestDTO);

        if (responseDTO.getOrderId() != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
        }
    }
}
