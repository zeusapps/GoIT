package com.example.eugen.task001;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        findViewById(R.id.result_one).setOnClickListener(this);
        findViewById(R.id.result_two).setOnClickListener(this);
        findViewById(R.id.result_three).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.result_one:
                intent.putExtra(Constants.PHONE_NUMBER, "0632659013");
                intent.putExtra(Constants.BROWSER_LINK, "http://vk.com");
                break;
            case R.id.result_two:
                intent.putExtra(Constants.PHONE_NUMBER, "0995151718");
                intent.putExtra(Constants.BROWSER_LINK, "http://fb.com");
                break;
            case R.id.result_three:
                intent.putExtra(Constants.PHONE_NUMBER, "0736669988");
                intent.putExtra(Constants.BROWSER_LINK, "http://google.com");
                break;
        }

        setResult(RESULT_OK, intent);
        finish();
    }
}
