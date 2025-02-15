package com.system_design.lld.design_patterns.decorator_design_pattern.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.system_design.lld.design_patterns.decorator_design_pattern.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResponseDTO {
    private String orderId;
    private String details;
    private List<String> appliedDecorators;
    private double price;
    private String message;
    private UserEntity user;
}
