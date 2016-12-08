package com.example.andrew.arrays;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText arrayAEditText;
    private TextView arrayBTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayAEditText = (EditText) findViewById(R.id.arrayAEditText);
        arrayBTextView = (TextView) findViewById(R.id.arrayBTextView);
    }

    public void onCalculateTask1(View view){

        String[] items = arrayAEditText
                .getText()
                .toString()
                .split(",");
        ArrayList<Integer> negotive = new ArrayList<>();
        ArrayList<Integer> positive = new ArrayList<>();
        try{
            for (String item: items){
                Integer i = Integer.parseInt(item.trim());
                if (i < 0){
                    negotive.add(i);
                } else {
                    positive.add(i);
                }
            }
            negotive.addAll(positive);

            Integer[] result = new Integer[negotive.size()];
            negotive.toArray(result);

            arrayBTextView.setText(toPrintable(result));
        } catch (Throwable e){
            arrayBTextView.setText("Error!");
        }
    }

    @NonNull
    private String toPrintable(Integer[] array){
        StringBuilder sb= new StringBuilder();
        for (Integer i: array){
            sb.append(i + ", ");
        }
        return sb.toString();
    }

}
