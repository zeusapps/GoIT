package com.example.eugen.test.infrastructure;

import android.app.Application;

import com.example.eugen.test.services.AuthService;

public class App extends Application {

    private AuthService _authService;

    public AuthService getAuthService() {
        if (_authService == null){
            _authService = new AuthService();
        }

        return _authService;
    }
}
