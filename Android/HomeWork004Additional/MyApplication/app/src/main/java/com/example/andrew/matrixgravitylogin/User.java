package com.example.andrew.matrixgravitylogin;

/**
 * Created by Andrew on 29.11.2016.
 */

public class User {
    private final String _login;
    private final String _role;

    public User(String login, String role){
        _login = login;
        _role = role;
    }

    public String getLogin() {
        return _login;
    }

    public String getRole() {
        return _role;
    }
}
