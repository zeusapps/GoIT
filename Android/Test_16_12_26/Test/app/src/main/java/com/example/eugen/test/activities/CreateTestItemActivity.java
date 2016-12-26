package com.example.eugen.test.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.eugen.test.R;
import com.example.eugen.test.activities.base.BaseAuthActivity;
import com.example.eugen.test.models.TestItem;

import butterknife.BindView;
import butterknife.OnClick;

public class CreateTestItemActivity extends BaseAuthActivity {

    @BindView(R.id.create_test_item_questionEditText)
    EditText _questionTextView;
    @BindView(R.id.create_test_item_correctAnswerEditText)
    EditText _correctAnswerTextView;
    @BindView(R.id.create_test_item_wrongAnswer1EditText)
    EditText _wrongAnswer1TextView;
    @BindView(R.id.create_test_item_wrongAnswer2EditText)
    EditText _wrongAnswer2TextView;
    @BindView(R.id.create_test_item_wrongAnswer3EditText)
    EditText _wrongAnswer3TextView;

    @Override
    protected int getResourceId() {
        return R.layout.activity_create_test_item;
    }

    @OnClick(R.id.create_test_item_createButton)
    public void create(){
        Intent intent = new Intent();
        intent.putExtra(TestItem.QUESTIN_EXTRA, _questionTextView.getText().toString());
        intent.putExtra(TestItem.CORRECT_ANSWER_EXTRA, _correctAnswerTextView.getText().toString());
        intent.putExtra(TestItem.WRONG_ANSWER_1_EXTRA, _wrongAnswer1TextView.getText().toString());
        intent.putExtra(TestItem.WRONG_ANSWER_2_EXTRA, _wrongAnswer2TextView.getText().toString());
        intent.putExtra(TestItem.WRONG_ANSWER_3_EXTRA, _wrongAnswer3TextView.getText().toString());

        setResult(RESULT_OK, intent);
        finish();
    }
}
