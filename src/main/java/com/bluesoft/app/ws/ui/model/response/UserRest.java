package com.bluesoft.app.ws.ui.model.response;

public class UserRest {

    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

   public String getUserId() {
        return userId;
    }

   public void setUserId(final String userId) {
        this.userId = userId;
    }

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
