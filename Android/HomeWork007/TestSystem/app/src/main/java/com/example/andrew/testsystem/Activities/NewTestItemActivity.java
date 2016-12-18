package com.example.andrew.testsystem.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.andrew.testsystem.Models.TestItem;
import com.example.andrew.testsystem.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewTestItemActivity extends AppCompatActivity {

    @BindView(R.id.new_test_item_image) EditText _imageEditText;
    @BindView(R.id.new_test_item_question)  EditText _questionEditText;
    @BindView(R.id.new_test_item_correctAnswer)  EditText _correctAnswerEditText;
    @BindView(R.id.new_test_item_wrongAnswer1)  EditText _wrongAnswer1EditText;
    @BindView(R.id.new_test_item_wrongAnswer2)  EditText _wrongAnswer2EditText;
    @BindView(R.id.new_test_item_wrongAnswer3)  EditText _wrongAnswer3EditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_test_item);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.new_test_item_addButton)
    public void addTestItem(){
        Intent intent = new Intent();
        intent.putExtra(TestItem.IMAGE, _imageEditText.getText().toString());
        intent.putExtra(TestItem.QUESTION, _questionEditText.getText().toString());
        intent.putExtra(TestItem.CORRECT_ANSWER, _correctAnswerEditText.getText().toString());
        intent.putExtra(TestItem.WRONG_ANSWER_1, _wrongAnswer1EditText.getText().toString());
        intent.putExtra(TestItem.WRONG_ANSWER_2, _wrongAnswer2EditText.getText().toString());
        intent.putExtra(TestItem.WRONG_ANSWER_3, _wrongAnswer3EditText.getText().toString());

        setResult(RESULT_OK, intent);
        finish();
    }
}
