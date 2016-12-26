package com.example.eugen.test.activities.base;

import android.content.Intent;
import android.os.Bundle;

import com.example.eugen.test.activities.LoginActivity;
import com.example.eugen.test.enums.AuthRole;

public abstract class BaseAuthActivity extends BaseActivity {
    @Override
    protected void onCreateCustom(Bundle savedState) {
        if (_application.getAuthService().getAuthRole() == AuthRole.NOT_AUTHORIZED){
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
    }
}
