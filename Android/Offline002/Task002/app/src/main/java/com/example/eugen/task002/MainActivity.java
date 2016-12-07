package com.example.eugen.task002;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private final String KEY = "COLOR";
    private View view;
    private int color = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.activity_main);

        if (savedInstanceState == null){
            return;
        }
        color = savedInstanceState.getInt("COLOR", -1);
        setColor(color);
    }

    public void onClick(View sender){

        int id = sender.getId();
        switch (id){
            case R.id.red_button:
                color = R.color.red;
                break;
            case R.id.green_button:
                color = R.color.green;
                break;
            case R.id.blue_button:
                color = R.color.blue;
                break;
        }

        setColor(color);
    }

    private void setColor(int color){
        if (color != -1){
            view.setBackgroundColor(ContextCompat.getColor(MainActivity.this, color));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(KEY, color);
    }
}
