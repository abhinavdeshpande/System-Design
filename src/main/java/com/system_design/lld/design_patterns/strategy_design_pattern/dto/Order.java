package com.system_design.lld.design_patterns.strategy_design_pattern.dto;

import com.system_design.lld.design_patterns.strategy_design_pattern.service.ShippingStrategy;
import lombok.Data;

import java.util.List;

@Data
public class Order {
    private List<Item> items;
    private ShippingStrategy shippingStrategy;

    public Order(List<Item> items) {
        this.items = items;
    }

    public double calculateTotalCost() {
        double itemCost= items.stream().mapToDouble(Item::getPrice).sum();
        return itemCost + shippingStrategy.calculateCost(this);
    }

    @Override
    public String toString() {
        return "Order{" +
                "items=" + items +
                ", shippingStrategy=" + shippingStrategy +
                '}';
    }
}
