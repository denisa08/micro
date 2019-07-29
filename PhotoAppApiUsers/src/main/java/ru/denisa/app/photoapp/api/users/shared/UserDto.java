package ru.denisa.app.photoapp.api.users.shared;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class UserDto implements Serializable {

    private static final long serialVersionUID = 4L;

    @Getter
    @Setter
    private String firstName;
    @Getter @Setter
    private String lastName;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String password;
    @Getter @Setter
    private String userId;
    @Getter @Setter
    private String encryptedPassword;




}
