package com.system_design.lld.design_patterns.factory_design_pattern.entity;

import com.system_design.lld.design_patterns.factory_design_pattern.dto.OrderRequestDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fdp_orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @Id
    private String id;
    private String userId;
    private double amount;
    private String paymentMethod;
    private boolean processed;

    // Constructor for mapping DTO to Entity
    public OrderEntity(OrderRequestDTO dto) {
        this.userId = dto.getUserId();
        this.amount = dto.getAmount();
        this.paymentMethod = dto.getPaymentMethod();
        this.processed = false; // Default to false
    }
}

