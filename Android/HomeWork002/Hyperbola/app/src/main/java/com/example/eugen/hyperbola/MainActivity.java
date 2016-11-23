package com.example.eugen.hyperbola;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private TextView _textViewY;
    private TextView _textViewX;
    private EditText _editTextX;
    private EditText _editTextY;
    private HyperbolaService _hyperbolaService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _textViewX = (TextView) findViewById(R.id.textViewResultX);
        _textViewY = (TextView) findViewById(R.id.textViewResultY);
        _editTextX = (EditText) findViewById(R.id.editTextX);
        _editTextY = (EditText) findViewById(R.id.editTextY);
        _hyperbolaService = new HyperbolaService();
    }

    public void calculateY(View view){
        try {
            double x = Double.parseDouble(_editTextX.getText().toString());
            _textViewY.setText(
                    _hyperbolaService.calculateY(x).toString());
        } catch (Exception e){
            _textViewY.setText(
                    "Check input value");
        }
    }

    public void calculateX(View view){
        try {
            double y = Double.parseDouble(_editTextY.getText().toString());
            _textViewX.setText(
                    _hyperbolaService.calculateX(y).toString());
        } catch (Exception e){
            _textViewX.setText(
                    "Check input value");
        }
    }
}
