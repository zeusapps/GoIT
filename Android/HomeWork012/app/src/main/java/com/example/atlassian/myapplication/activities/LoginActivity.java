package com.example.atlassian.myapplication.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.atlassian.myapplication.R;
import com.example.atlassian.myapplication.fragmants.ForgotPasswordFragment;
import com.example.atlassian.myapplication.fragmants.LoginFragment;
import com.example.atlassian.myapplication.fragmants.RegisterFragment;

public class LoginActivity extends AppCompatActivity implements LoginFragment.OnLoginListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.activity_login_content, new LoginFragment())
                .commit();
    }

    @Override
    public void onLogin(String login, String password) {
        Toast.makeText(this, "Logining " + login + "...", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onRegister() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_login_content, new RegisterFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onPasswordRecover() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_login_content, new ForgotPasswordFragment())
                .addToBackStack(null)
                .commit();
    }
}
