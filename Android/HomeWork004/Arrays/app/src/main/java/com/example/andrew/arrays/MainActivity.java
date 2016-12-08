package com.example.andrew.arrays;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText _arrayA;
    private TextView _arrayB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _arrayA = (EditText) findViewById(R.id.arrayA);
        _arrayB = (TextView) findViewById(R.id.arrayB);
    }

    public void calculate
}
