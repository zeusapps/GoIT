package com.example.eugen.test.services;

import com.example.eugen.test.enums.AuthRole;

public class AuthService {
    private final static String ADMIN = "admin";
    private final static String USER = "user";

    private AuthRole _role;

    public AuthService(){
        _role = AuthRole.NOT_AUTHORIZED;
    }

    public AuthRole getAuthRole(){
        return _role;
    }

    public AuthRole auth(String login, String password){
        if (login.equals(ADMIN) && password.equals(ADMIN)){
            _role = AuthRole.ADMIN;
        } else if (login.equals(USER) && password.equals(USER)){
            _role = AuthRole.USER;
        }

        return _role;
    }

}
