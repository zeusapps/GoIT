package com.example.eugen.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Integer _counter;
    private TextView _counterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _counter = 0;
        _counterTextView = (TextView) findViewById(R.id.counterTextView);
    }

    public void onIncCounterClick(View sender){
        increaseCounter();
        updateCounterView();
    }

    private void increaseCounter(){
        _counter++;
    }
    
    private void updateCounterView(){
        if (_counterTextView == null) {
            return;
        }

        String text = String.format("Current counter: %d", _counter);
        _counterTextView.setText(text);
    }
}
