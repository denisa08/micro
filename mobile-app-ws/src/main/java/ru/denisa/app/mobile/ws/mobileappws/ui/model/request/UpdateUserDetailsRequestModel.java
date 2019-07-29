package ru.denisa.app.mobile.ws.mobileappws.ui.model.request;

import javax.validation.constraints.NotNull;

public class UpdateUserDetailsRequestModel {

    @NotNull(message = "it not be a null")
    private String firstName;
    @NotNull(message = "it not be a null")
    private String lastName;




    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
