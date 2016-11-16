package com.example.eugen.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int TEXT_LENGTH_TO_INC_COUNTER = 12;
    private static final int TEXT_LENGTH_TO_SHOW_GREETING = 23;
    private static final String GREETING_TEXT = "I love GoIT so much";
    private static final String COUNTER_TEXT = "Current counter: %d";

    private int _counter;
    private TextView _counterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _counterTextView = (TextView) findViewById(R.id.counterTextView);
        EditText counterEditText = (EditText) findViewById(R.id.counterEditText);
        if (counterEditText == null){
            return;
        }


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
}