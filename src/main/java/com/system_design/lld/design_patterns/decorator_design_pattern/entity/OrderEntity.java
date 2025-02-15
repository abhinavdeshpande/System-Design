package com.system_design.lld.design_patterns.decorator_design_pattern.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "ddp_orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
    @Id
    private String id;
    private String details;
    private double price;
    private List<String> appliedDecorators;
    private String status;

    @DBRef
    private UserEntity user; // Reference to the User who placed the order
}

