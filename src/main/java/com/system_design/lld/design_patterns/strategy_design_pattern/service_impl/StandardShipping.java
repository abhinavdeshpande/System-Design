package com.system_design.lld.design_patterns.strategy_design_pattern.service_impl;

import com.system_design.lld.design_patterns.strategy_design_pattern.dto.Order;
import com.system_design.lld.design_patterns.strategy_design_pattern.service.ShippingStrategy;

public class StandardShipping implements ShippingStrategy {
    @Override
    public double calculateCost(Order order) {
        return 10;
    }
}
