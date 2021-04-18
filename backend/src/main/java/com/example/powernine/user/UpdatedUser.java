package com.example.powernine.user;

public class UpdatedUser extends User {
    private String newPassword;

    public UpdatedUser(String username, String password, String role, String newPassword) {
        super(username, password, role);
        this.newPassword = newPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
