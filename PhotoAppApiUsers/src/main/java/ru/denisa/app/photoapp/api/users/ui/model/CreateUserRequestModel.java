package ru.denisa.app.photoapp.api.users.ui.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {



    @NotNull(message = "First name cannot be null")
    @Size(min = 2, message = "First name must not be less than two characters")
    @Getter @Setter
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Size(min = 2, message = "Last name must not be less than two characters")
    @Getter @Setter
    private String lastName;

    @NotNull(message = "Last name cannot be null")
    @Size(min = 2,max=6, message = "Password cannot be null")
    @Getter @Setter
    private String password;

    @NotNull(message = "Email cannot be null")
    @Email
    @Getter
    @Setter
    private String email;











}
