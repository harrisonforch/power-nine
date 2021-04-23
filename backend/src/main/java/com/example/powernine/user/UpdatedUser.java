package com.example.powernine.user;

import com.mongodb.lang.NonNull;

public class UpdatedUser extends User {
    private String newPassword;

    public UpdatedUser(@NonNull String username, @NonNull String password, String firstName, String lastName,
                       String email, String role, String newPassword) {
        super(username, password, firstName, lastName, email, role);
        this.newPassword = newPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
