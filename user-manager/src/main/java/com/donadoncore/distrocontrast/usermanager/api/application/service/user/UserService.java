package com.donadoncore.distrocontrast.usermanager.api.application.service.user;

import com.donadoncore.distrocontrast.usermanager.api.domain.user.UserFormRequest;
import com.donadoncore.distrocontrast.usermanager.api.domain.user.UserLoginRequest;
import com.donadoncore.distrocontrast.usermanager.api.domain.user.UserResponse;

import java.util.Optional;

public interface UserService {

    UserResponse save(UserFormRequest user);

    Optional<UserResponse> login(UserLoginRequest login);

}
