package com.example.eugen.task001;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getName();
    private EditText _numberEditText;
    private TextView _resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _numberEditText = (EditText) findViewById(R.id.numberTextEdit);
        _resultTextView = (TextView) findViewById(R.id.resultTextView);
    }

    public void calculate(View view){
        try{
            Integer value = Integer.parseInt(_numberEditText.getText().toString());

            Integer result = value%10;

            _resultTextView.setText(result.toString());

            result = value/10;

            Toast.makeText(this, result.toString(), Toast.LENGTH_SHORT)
                    .show();

            Log.i(TAG, String.valueOf(value * 1234));

            View content = findViewById(android.R.id.content);
            Snackbar
                    .make(content, String.valueOf(23), Snackbar.LENGTH_SHORT)
                    .show();
        }
        catch (Throwable e){
            printError();
        }
    }

    private void printError(){
        _resultTextView.setText("Error");
    }


}
