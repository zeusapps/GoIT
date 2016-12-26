package com.example.eugen.test.activities.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.eugen.test.infrastructure.App;

import butterknife.ButterKnife;

public abstract class BaseActivity  extends AppCompatActivity {

    protected App _application;

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResourceId());
        ButterKnife.bind(this);
        _application = (App) getApplication();
        onCreateCustom(savedInstanceState);
    }

    protected abstract void onCreateCustom(Bundle savedState);

    protected abstract int getResourceId();
}
