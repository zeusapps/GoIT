package com.example.eugen.test.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.eugen.test.R;
import com.example.eugen.test.activities.base.BaseActivity;
import com.example.eugen.test.activities.base.BaseAuthActivity;
import com.example.eugen.test.enums.AuthRole;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.login_loginTextView)
    EditText _loginTextView;
    @BindView(R.id.login_passwordTextView)
    EditText _passwordTextView;

    @Override
    protected void onCreateCustom(Bundle savedState) {

    }

    @Override
    protected int getResourceId() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.login_loginButton)
    public void login(){

        AuthRole role = this._application
                .getAuthService()
                .auth(_loginTextView.getText().toString(), _passwordTextView.getText().toString());

        if (role != AuthRole.NOT_AUTHORIZED){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
