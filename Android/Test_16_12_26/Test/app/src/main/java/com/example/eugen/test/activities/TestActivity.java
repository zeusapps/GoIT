package com.example.eugen.test.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eugen.test.R;
import com.example.eugen.test.activities.base.BaseAuthActivity;
import com.example.eugen.test.models.Test;
import com.example.eugen.test.models.TestItem;

import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;

public class TestActivity extends BaseAuthActivity {

    private Test _test;
    private int _position;
    private int _corectAnswers;

    @BindView(R.id.test_radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.test_answer1)
    RadioButton answer1;
    @BindView(R.id.test_answer2)
    RadioButton answer2;
    @BindView(R.id.test_answer3)
    RadioButton answer3;
    @BindView(R.id.test_answer4)
    RadioButton answer4;
    @BindView(R.id.test_question)
    TextView question;

    @Override
    protected void onCreateCustom(Bundle savedState) {
        super.onCreateCustom(savedState);

        int id = getIntent().getIntExtra(Test.ID_EXTRA, 0);

        _test = _application.getTestsRepository().getTest(id);
        _position = 0;
        update();
    }

    @Override
    protected int getResourceId() {
        return R.layout.activity_test;
    }

    @OnClick(R.id.test_nextButton)
    public void next(){
        String correct = _test.getTestItems().get(_position).getCorrectAnswer();

        int id = radioGroup.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton) findViewById(id);
        if (rb != null && rb.getText().equals(correct)){
            _corectAnswers++;
        }

        _position++;
        if (_position >= _test.getTestItems().size() - 1){
            update();
        }
        else {

            int persents = _corectAnswers * 100 / _test.getTestItems().size();
            Toast.makeText(this, persents + "%", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void update(){

        TestItem item = _test.getTestItems().get(_position);

        question.setText(item.getQuestion());

        String[] answers = shuffleAnswers(item);
        answer1.setText(answers[0]);
        answer1.setChecked(true);
        answer2.setText(answers[1]);
        answer3.setText(answers[2]);
        answer4.setText(answers[3]);
    }

    private String[] shuffleAnswers(TestItem item)
    {
        String[] ar = {
                item.getCorrectAnswer(),
                item.getWrongAnswer1(),
                item.getWrongAnswer2(),
                item.getWrongAnswer3()
        };

        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }

        return ar;
    }
}
