package com.donadoncore.distrocontrast.usermanager.api.application.service.user;

import com.donadoncore.distrocontrast.usermanager.api.domain.user.UserFormRequest;
import com.donadoncore.distrocontrast.usermanager.api.domain.user.UserLoginRequest;
import com.donadoncore.distrocontrast.usermanager.api.domain.user.UserResponse;
import com.donadoncore.distrocontrast.usermanager.api.infrastructure.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse save(UserFormRequest user) {
        var userEntity = userRepository.save(UserMapper.toEntity(user));
        return UserMapper.toResponse(userEntity);
    }

    @Override
    public Optional<UserResponse> login(UserLoginRequest login) {
        return Optional.empty();
    }
}
