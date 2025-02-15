package com.system_design.lld.design_patterns.decorator_design_pattern.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {
    private String userId;
    private String details;
    private double price;
    private List<String> decorators;
}
