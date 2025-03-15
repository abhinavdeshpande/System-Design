package com.system_design.lld.design_patterns.factory_design_pattern.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {
    private String orderId;
    private String userId;
    private double amount;
    private String paymentMethod;
    private boolean processed;
    private String message;
}
