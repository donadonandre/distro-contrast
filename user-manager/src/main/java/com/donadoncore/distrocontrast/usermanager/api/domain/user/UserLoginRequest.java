package com.donadoncore.distrocontrast.usermanager.api.domain.user;

public record UserLoginRequest (
    String email,
    String password
){
}
