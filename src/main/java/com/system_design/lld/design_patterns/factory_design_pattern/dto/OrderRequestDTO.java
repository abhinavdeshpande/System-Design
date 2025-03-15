package com.system_design.lld.design_patterns.factory_design_pattern.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {
    private String userId;
    private double amount;
    private String paymentMethod;  // "CREDIT_CARD", "UPI"
}
