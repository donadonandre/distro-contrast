package com.donadoncore.distrocontrast.contentmanager.api.domain.user;

import com.donadoncore.distrocontrast.contentmanager.api.domain.device.Device;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String email;

    private String name;

    private String sharedKey;

    private List<Device> devices;
}
