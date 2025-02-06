package com.system_design.lld.design_patterns.strategy_design_pattern.service;

import com.system_design.lld.design_patterns.strategy_design_pattern.dto.Order;
import org.springframework.stereotype.Service;

@Service
public interface ShippingStrategy {

    double calculateCost(Order order);
}
