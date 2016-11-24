package com.example.andrew.strings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.SortedSet;

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

        builder.append("\nTotal arguments: " + arguments.length);

        _resultTextView.setText(builder.toString());
    }

    /**
     * Вариант 2-11
     * Программа определяет, какие символы содержатся во введенных аргументах
     * (например, аргументы "abc", "cf", "bfc" содержат символы "abcf"). Шаблон
     * аргумента: строка либо латинских букв, либо букв кириллицы. Программа
     * выводит количество заданных аргументов, значения аргументов и строку
     * символов, содержащихся в аргументах.
     * */
    public void CountChars(View view){
        String[] arguments = _argumentsEditText
                .getText()
                .toString()
                .split(" ");

        StringBuilder builder = new StringBuilder();

        ArrayList<Character> chars = new ArrayList<>();

        for (String item: arguments){
            for (int i = 0; i < item.length(); i++){
                char ch = item.charAt(i);
                if (!chars.contains(ch)){
                     chars.add(ch);
                }
            }
            builder.append(item + "\n");
        }

        builder.append("\nCharacters: ");
        for(char ch: chars){
            builder.append(ch);
        }

        builder.append("\nTotal arguments: " + arguments.length);

        _resultTextView.setText(builder.toString());
    }

    /**
     * Вариант 2-18
     * Программа переставляет введенные аргументы в порядке возрастания
     * их длины. Шаблон аргумента: строка либо цифр, либо латинских букв,
     * либо букв кириллицы. Программа выводит количество заданных аргументов,
     * их значения, а также список значений аргументов в порядке возрастания  их длины.
     * */
    public void SortArguments(View view){
        String[] arguments = _argumentsEditText
                .getText()
                .toString()
                .split(" ");

        StringBuilder builder = new StringBuilder(
                "Total arguments: " + arguments.length + "\n");

        ArrayList<String> items = new ArrayList<>();

        for (String item: arguments){
            items.add(item);
            builder.append(item + "\n");
        }

        builder.append("\nSorted:\n");


        Collections.sort(items, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.length() - t1.length();
            }
        });

        for (String item: items){
            builder.append(item + "\n");
        }

        _resultTextView.setText(builder.toString());
    }
}
