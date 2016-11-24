package com.example.andrew.fraction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String ERROR = "Error!";
    private EditText _fraction1;
    private EditText _fraction2;
    private TextView _result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        _fraction1 = (EditText) findViewById(R.id.fraction1);
        _fraction2 = (EditText) findViewById(R.id.fraction2);
        _result = (TextView) findViewById(R.id.result);

    }

    public void add(View view){
        calculate(FractionOperations.ADD);
    }

    public void subtract(View view){
        calculate(FractionOperations.SUBTRACT);
    }

    public void multiply(View view){
        calculate(FractionOperations.MULTIPLY);
    }

    public void divide(View view){
        calculate(FractionOperations.DIVIDE);
    }

    private void calculate(FractionOperations operation){
        try{
            Fraction f1 = Fraction.Parse(_fraction1.getText().toString());
            Fraction f2 = Fraction.Parse(_fraction2.getText().toString());

            Fraction r = Fraction.Calculate(f1,f2,operation);

            _result.setText(r.toString());
        }
        catch (Throwable e){
            _result.setText(ERROR);
        }
    }
}
