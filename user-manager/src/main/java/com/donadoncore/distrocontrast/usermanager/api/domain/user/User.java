package com.donadoncore.distrocontrast.usermanager.api.domain.user;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "users")
public class User {
    private String id;

    private String sharedId;

    private String name;

    private String email;

    private String password;

    private List<UserLink> links;
}
