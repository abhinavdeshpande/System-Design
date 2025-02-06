package com.system_design.lld.design_patterns.strategy_design_pattern.rest_controller;

import com.system_design.lld.design_patterns.strategy_design_pattern.dto.Item;
import com.system_design.lld.design_patterns.strategy_design_pattern.dto.Order;
import com.system_design.lld.design_patterns.strategy_design_pattern.service_impl.ExpressShipping;
import com.system_design.lld.design_patterns.strategy_design_pattern.service_impl.OneDayShipping;
import com.system_design.lld.design_patterns.strategy_design_pattern.service_impl.StandardShipping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StrategyDPRestController {

    @GetMapping("/strategy-design-pattern/shipping")
    public String learnStrategyDesignPattern(@RequestBody List<Item> items,
                                             @RequestParam String shippingMode) {
        Order order = new Order(items);
        switch (shippingMode) {
            case "one-day":
                order.setShippingStrategy(new OneDayShipping());
                break;

            case "express":
                order.setShippingStrategy(new ExpressShipping());
                break;

            default:
                order.setShippingStrategy(new StandardShipping());
                break;
        }
        return "Total Cost of Your Order is Rs." + order.calculateTotalCost() +
                "\nShipping Mode Selected: " + shippingMode +
                "\nOrder Summary: " + order.getItems();
    }
}
