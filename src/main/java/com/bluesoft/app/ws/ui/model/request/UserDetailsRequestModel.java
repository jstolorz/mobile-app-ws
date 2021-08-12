package com.bluesoft.app.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserDetailsRequestModel {

    @NotNull(message="First name cannot be null")
    private String firstName;
    @NotNull(message="Last name cannot be null")
    private String lastName;
    @NotNull(message="email cannot be null")
    @Email
    private String email;
    @NotNull(message="password cannot be null")
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
