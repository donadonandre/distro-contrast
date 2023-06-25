package com.donadoncore.distrocontrast.usermanager.api.application.service.user;

import com.donadoncore.distrocontrast.usermanager.api.application.shared.utils.Generator;
import com.donadoncore.distrocontrast.usermanager.api.domain.user.User;
import com.donadoncore.distrocontrast.usermanager.api.domain.user.UserFormRequest;
import com.donadoncore.distrocontrast.usermanager.api.domain.user.UserResponse;

public class UserMapper {

    public static User toEntity(UserFormRequest form) {
        return User.builder()
                .email(form.email())
                .name(form.name())
                .password(form.password())
                .sharedId(Generator.generateSharedId(10))
                .build();
    }

    public static UserResponse toResponse(User user) {
        return new UserResponse(
                user.getSharedId(),
                user.getName(),
                user.getEmail()
        );
    }

}
