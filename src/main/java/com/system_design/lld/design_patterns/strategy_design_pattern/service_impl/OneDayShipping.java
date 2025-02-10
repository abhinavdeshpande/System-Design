package com.system_design.lld.design_patterns.strategy_design_pattern.service_impl;

import com.system_design.lld.design_patterns.strategy_design_pattern.dto.Order;
import com.system_design.lld.design_patterns.strategy_design_pattern.service.ShippingStrategy;
import org.springframework.stereotype.Service;

@Service
public class OneDayShipping  implements ShippingStrategy {
    @Override
    public double calculateCost(Order order) {
        return 100;
    }
}
