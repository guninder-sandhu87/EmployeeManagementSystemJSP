package entity;

import constants.Role;

public class User {


    private  String userName;
    private final String role;

    public User(String userName) {
        this.userName = userName;
        this.role=Role.ADMIN.name();
    }

    public String getRole() {
        return role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
