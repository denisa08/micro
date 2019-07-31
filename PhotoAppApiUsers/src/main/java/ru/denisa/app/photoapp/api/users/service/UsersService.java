package ru.denisa.app.photoapp.api.users.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.denisa.app.photoapp.api.users.shared.UserDto;

public interface UsersService extends UserDetailsService {


    UserDto createUser(UserDto userDetails);
    UserDto getUserDetailsByEmail(String email);


}
