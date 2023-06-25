package com.donadoncore.distrocontrast.usermanager.api.domain.user;

public record UserFormRequest(
        String name,

        String email,

        String password
) {
}
