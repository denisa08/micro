package ru.denisa.app.mobile.ws.mobileappws.userservice;

import ru.denisa.app.mobile.ws.mobileappws.ui.model.request.UserDetailsRequestModel;
import ru.denisa.app.mobile.ws.mobileappws.ui.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);

}
