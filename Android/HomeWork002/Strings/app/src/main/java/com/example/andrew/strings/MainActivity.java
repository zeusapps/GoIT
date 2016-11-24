package com.example.andrew.strings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView _resultTextView;
    private EditText _argumentsEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _resultTextView = (TextView) findViewById(R.id.argumentsResult);
        _argumentsEditText = (EditText) findViewById(R.id.argumentEditText);
    }

    /**
     * Created by Andrew on 24.11.2016.
     * Вариант 2-01
     * Если аргумент является правильным целым числом
     * (шаблон: одна или несколько цифр, первым символом
     * может быть либо цифра,  либо знак "+" или "-"), то
     * тип аргумента "Integer", иначе "String". Программа выводит
     * количество заданных аргументов и, для каждого аргумента, его тип и значение.
     */
    public void CheckResults(View view){
        String[] arguments = _argumentsEditText
                .getText()
                .toString()
                .split(" ");
        StringBuilder builder = new StringBuilder();
        for (String item: arguments){
            String type = "Integer";

            for (int i = 0; i < item.length(); i++){
                char ch = item.charAt(i);

                if (!Character.isDigit(ch)){
                    if (i == 0 && (ch == '+' || ch == '-'))
                    {
                        continue;
                    }
                    type = "String";
                    break;
                }
            }

            builder.append(type + ": " + item + "\n");
        }

        _resultTextView.setText(builder.toString());
    }
}
