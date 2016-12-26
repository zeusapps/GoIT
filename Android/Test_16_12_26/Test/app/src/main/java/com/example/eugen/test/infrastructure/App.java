package com.example.eugen.test.infrastructure;

import android.app.Application;

import com.example.eugen.test.repositories.TestsRepository;
import com.example.eugen.test.services.AuthService;

public class App extends Application {

    private AuthService _authService;
    private TestsRepository _testsRepository;

    public AuthService getAuthService() {
        if (_authService == null){
            _authService = new AuthService();
        }

        return _authService;
    }

    public TestsRepository getTestsRepository() {
        if (_testsRepository == null){
            _testsRepository = new TestsRepository();
        }

        return _testsRepository;
    }
}
