package com.example.eugen.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.eugen.homework.services.FibonacciService;
import com.example.eugen.homework.services.IFibonacciService;


public class MainActivity extends AppCompatActivity {

    private static final int TEXT_LENGTH_TO_INC_COUNTER = 12;
    private static final int TEXT_LENGTH_TO_SHOW_GREETING = 23;
    private static final int FIBONACCI_INT_OVERFLOW = 47;
    private static final String GREETING_TEXT = "I love GoIT so much";
    private static final String COUNTER_TEXT = "Current counter: %d";
    private static final String FIBONACCI_TEXT = "= %d";
    private static final String FIBONACCI_ERROR_TEXT = "probably bad input";
    private static final String FIBONACCI_OVERFLOW_TEXT = "we support values in range 0 and 46";
    private static final String FIBONACCI_EMPTY_TEXT = "please, provide some value";

    private int _counter;
    private TextView _counterTextView;
    private TextView _fibonacciTextView;
    private IFibonacciService _fibonacciService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _fibonacciService = FibonacciService.instance();
        _counterTextView = (TextView) findViewById(R.id.counterTextView);
        _fibonacciTextView = (TextView) findViewById(R.id.fibonacciResultTextView);

        EditText counterEditText = (EditText) findViewById(R.id.counterEditText);
        if (counterEditText != null){
            counterEditText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence text, int i, int i1, int i2) { }

                @Override
                public void onTextChanged(CharSequence text, int i, int i1, int i2) {
                    if (text.length() > TEXT_LENGTH_TO_INC_COUNTER){
                        increaseCounterAndUpdateUI();
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) { }
            });
        }

        EditText fibonacciEditText = (EditText) findViewById(R.id.fibonacciEditText);
        if (fibonacciEditText != null){
            fibonacciEditText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

                @Override
                public void onTextChanged(CharSequence text, int i, int i1, int i2) {
                    if(text.length() == 0){
                        printFibonacciResult(FIBONACCI_EMPTY_TEXT);
                        return;
                    }

                    try{
                        int value = Integer.parseInt(text.toString());
                        if (value < FIBONACCI_INT_OVERFLOW) {
                            int result = _fibonacciService.calculate(value);
                            printFibonacciResult(result);
                        } else {
                            printFibonacciResult(FIBONACCI_OVERFLOW_TEXT);
                        }
                    }
                    catch (Throwable e){
                        printFibonacciResult(FIBONACCI_ERROR_TEXT);
                    }
                }


                @Override
                public void afterTextChanged(Editable editable) { }
            });
        }
    }

    public void onIncCounterClick(View sender){
        increaseCounterAndUpdateUI();
    }

    private void increaseCounterAndUpdateUI(){
        _counter++;

        if (_counterTextView == null) {
            return;
        }

        String text = _counter == TEXT_LENGTH_TO_SHOW_GREETING
                ? GREETING_TEXT
                : String.format(COUNTER_TEXT, _counter);
        _counterTextView.setText(text);
    }

    private void printFibonacciResult(int value){
        printFibonacciResult(String.format(FIBONACCI_TEXT, value));
    }

    private void printFibonacciResult(String value){
        _fibonacciTextView.setText(value);
    }
}