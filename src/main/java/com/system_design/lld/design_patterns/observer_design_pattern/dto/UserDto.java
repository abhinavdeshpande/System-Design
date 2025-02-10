package com.system_design.lld.design_patterns.observer_design_pattern.dto;

import com.system_design.lld.design_patterns.observer_design_pattern.util.NotificationMode;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;

@Document(collection = "user")
@Data
@Builder
public class UserDto {

    @Id
    private String id;
    @NotNull
    private String userName;
    @NotNull
    private String email;
    @NotNull
    private String mobileNo;
    @Indexed
    private String itemId;
    private List<NotificationMode> notificationModes;

    public UserDto(String id, String userName, String email, String mobileNo, String itemId, List<NotificationMode> notificationModes) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.mobileNo = mobileNo;
        this.itemId = itemId;
        this.notificationModes = notificationModes;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", mobileNo=" + mobileNo +
                ", itemId='" + itemId + '\'' +
                ", notificationModes=" + notificationModes +
                '}';
    }
}
