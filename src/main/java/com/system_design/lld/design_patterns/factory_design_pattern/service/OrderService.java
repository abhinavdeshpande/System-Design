package com.system_design.lld.design_patterns.factory_design_pattern.service;

import com.system_design.lld.design_patterns.factory_design_pattern.dto.OrderResponseDTO;
import com.system_design.lld.design_patterns.factory_design_pattern.dto.OrderRequestDTO;

public interface OrderService {
    OrderResponseDTO processOrder(OrderRequestDTO requestDTO);
}
