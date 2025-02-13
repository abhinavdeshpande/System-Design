package com.system_design.lld.design_patterns.decorator_design_pattern.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseDTO {
    private String userId;
    private String name;
    private String email;
    private String mobileNo;
    private String message;
}
