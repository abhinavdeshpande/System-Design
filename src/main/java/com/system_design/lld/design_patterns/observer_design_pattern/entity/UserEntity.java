package com.system_design.lld.design_patterns.observer_design_pattern.entity;

import com.system_design.lld.design_patterns.observer_design_pattern.util.NotificationMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "odp_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    private String id;
    private String userName;
    private String email;
    private String mobileNo;
    @Indexed
    private String itemId;
    private List<NotificationMode> notificationModes;
}
