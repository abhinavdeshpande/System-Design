package com.system_design.lld.design_patterns.strategy_design_pattern.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {

    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
