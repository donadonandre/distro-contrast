package com.donadoncore.distrocontrast.usermanager.api.domain.user;

public record UserResponse(
        String sharedId,

        String name,

        String email
) {
}
