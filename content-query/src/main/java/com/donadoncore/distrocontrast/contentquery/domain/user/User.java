package com.donadoncore.distrocontrast.contentquery.domain.user;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Builder
@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String sharedId;

    private String name;

    private List<UserSocialMedia> userContacts;

    private List<UserDevice> userDevices;
}
