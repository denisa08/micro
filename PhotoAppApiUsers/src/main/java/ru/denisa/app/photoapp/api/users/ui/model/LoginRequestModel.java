package ru.denisa.app.photoapp.api.users.ui.model;

import lombok.Getter;
import lombok.Setter;

public class LoginRequestModel {

    @Getter @Setter
    private String email;
    @Getter @Setter
    private String password;



}
