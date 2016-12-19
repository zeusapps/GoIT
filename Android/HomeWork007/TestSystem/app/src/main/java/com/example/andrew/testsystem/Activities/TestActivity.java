package com.example.andrew.testsystem.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andrew.testsystem.Models.Test;
import com.example.andrew.testsystem.Models.TestItem;
import com.example.andrew.testsystem.R;
import com.example.andrew.testsystem.Repository.TestsRepository;
import com.squareup.picasso.Picasso;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity extends AppCompatActivity {


    private TestItem[] _testItems;
    private int _testIndex;
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
    @BindView(R.id.test_testImage)
    ImageView imageView;
    @BindView(R.id.test_nextButton)
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);

        long id = getIntent().getLongExtra(Test.ID_FIELD, 0);
        TestsRepository repository = new TestsRepository(this);
        _testItems = repository.getTestItems(id);
        _testIndex = 0;
        _corectAnswers = 0;

        onNext();
    }

    @OnClick(R.id.test_nextButton)
    public void onNext(){
        checkAnswer();

        if (_testIndex == _testItems.length){
            Toast
                    .makeText(this, "You answerer " + _corectAnswers + " of " + _testItems.length, Toast.LENGTH_SHORT)
                    .show();
            finish();
            return;
        }

        TestItem item = _testItems[_testIndex];

        Picasso
                .with(this)
                .load(item.getImage())
                .into(imageView);

        question.setText(item.getQuestion());

        String[] answers = shuffleAnswers(item);
        answer1.setText(answers[0]);
        answer1.setChecked(true);
        answer2.setText(answers[1]);
        answer3.setText(answers[2]);
        answer4.setText(answers[3]);

        _testIndex++;
        if (_testIndex == _testItems.length){
            nextButton.setText("Finish test");
        }
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

    private void checkAnswer(){
        if (_testIndex == 0){
            return;
        }

        String correct = _testItems[_testIndex - 1].getCorrectAnswer();

        int id = radioGroup.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton) findViewById(id);
        if (rb != null && rb.getText().equals(correct)){
            _corectAnswers++;
        }
    }
}
