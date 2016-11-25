package com.example.eugen.hyperbola;

import android.opengl.EGLDisplay;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText _editX;
    EditText _editY;
    TextView _result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _editX = (EditText) findViewById(R.id.editX);
        _editY = (EditText) findViewById(R.id.editY);
        _result = (TextView) findViewById(R.id.result);
    }

    public void calculateX(View view){
        try {
            double y = Double.parseDouble(_editY.getText().toString());
            Hyperbola h = Hyperbola.calculateX(y);
            printResult(h);
        } catch (Throwable e){
            printError();
        }
    }

    public void calculateY(View view){
        try {
            double x = Double.parseDouble(_editX.getText().toString());
            Hyperbola h = Hyperbola.calculateY(x);
            printResult(h);
        } catch (Throwable e){
            printError();
        }
    }

    private void printError(){
        _result.setText("Error!");
    }

    private void printResult(Hyperbola h){
        _result.setText(h.toString());
    }
}
