package com.system_design.lld.design_patterns.decorator_design_pattern.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    private String userId;
    private String name;
    private String email;
    private String mobileNo;
}
