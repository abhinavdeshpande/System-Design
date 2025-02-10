package com.system_design.lld.design_patterns.observer_design_pattern.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "item")
@Data
@Builder
public class ItemDto {

    @Id
    private String id;
    @NotNull
    private String itemName;
    @NotNull
    private int itemQuantity;
    private boolean isActive;

    @Override
    public String toString() {
        return "ItemDto{" +
                "itemId=" + id + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemQuantity=" + itemQuantity + '\'' +
                ", isActive=" + isActive + '\'' +
                '}';
    }
}
