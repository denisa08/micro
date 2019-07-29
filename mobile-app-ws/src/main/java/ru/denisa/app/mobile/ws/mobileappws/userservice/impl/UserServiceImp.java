package ru.denisa.app.mobile.ws.mobileappws.userservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.denisa.app.mobile.ws.mobileappws.shared.Utils;
import ru.denisa.app.mobile.ws.mobileappws.ui.model.request.UserDetailsRequestModel;
import ru.denisa.app.mobile.ws.mobileappws.ui.model.response.UserRest;
import ru.denisa.app.mobile.ws.mobileappws.userservice.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService {
    Map<String, UserRest> users;
    Utils utils;


    public UserServiceImp() {
    }

    @Autowired
    public UserServiceImp(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());

        String userId = utils.generateUserId();

        if (users == null) users = new HashMap<>();
        users.put(userId, returnValue);
        returnValue.setUserId(userId);
        return returnValue;
    }
}
