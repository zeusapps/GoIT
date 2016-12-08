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
        Integer[] items = parseArrayA();
        if(items.length == 0){
            return;
        }

        ArrayList<Integer> negative = new ArrayList<>();
        ArrayList<Integer> positive = new ArrayList<>();
        for (Integer item: items){
            if (item < 0){
                negative.add(item);
            } else {
                positive.add(item);
            }
        }
        negative.addAll(positive);
        Integer[] result = new Integer[negative.size()];
        negative.toArray(result);
        arrayBTextView.setText(toPrintable(result));
    }

    public void onCalculateTask2(View view){
        Integer[] items = parseArrayA();
        if(items.length == 0){
            return;
        }

        Integer[] result = new Integer[items.length];
        for (int i = 0; i < items.length; i++){
            if (result[i] != null && result[i].equals(1)){
                continue;
            }
            result[i] = 0;
            for (int j = i + 1; j < items.length; j++){
                if (items[i].equals(items[j])){
                    result[i] = 1;
                    result[j] = 1;
                }
            }
        }

        arrayBTextView.setText(toPrintable(result));
    }

    private Integer[] parseArrayA(){
        try {
            String[] items = arrayAEditText
                    .getText()
                    .toString()
                    .split(",");
            Integer[] result = new Integer[items.length];
            for (int i = 0; i < result.length; i++){
                result[i] = Integer.parseInt(items[i].trim());
            }
            return result;
        } catch (Throwable e){
            arrayBTextView.setText("Error!");
            return new Integer[0];
        }
    }
    @NonNull
    private String toPrintable(Integer[] array){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++){
            sb.append(array[i].toString());
            if (i != array.length - 1){
                sb.append(", ");
            }
        }
        return sb.toString();
    }

}
