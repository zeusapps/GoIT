package com.example.eugen.task001;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final int STATUS_CODE = 112;
    private EditText _phoneEditText;
    private EditText _longitudeEditText;
    private EditText _latitudeEditText;
    private EditText _browserEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _phoneEditText = (EditText) findViewById(R.id.main_phoneNumberEditText);
        _longitudeEditText = (EditText) findViewById(R.id.main_longitudeEditText);
        _latitudeEditText = (EditText) findViewById(R.id.main_latitudeEditText);
        _browserEditText = (EditText) findViewById(R.id.main_webBrowserEditText);

        findViewById(R.id.main_callButton).setOnClickListener(this);
        findViewById(R.id.main_locationButton).setOnClickListener(this);
        findViewById(R.id.main_browserButton).setOnClickListener(this);
        findViewById(R.id.main_getDataButton).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_callButton:
                String number = _phoneEditText
                        .getText()
                        .toString();

                call(number);
                break;
            case R.id.main_locationButton:
                Double longitude = Double.parseDouble(_longitudeEditText
                        .getText()
                        .toString());
                Double latitude = Double.parseDouble(_latitudeEditText
                        .getText()
                        .toString());
                showLocation(longitude, latitude);
                break;
            case R.id.main_browserButton:
                String site = _browserEditText.getText().toString();
                showSite(site);
                break;
            case R.id.main_getDataButton:
                Intent intent = new Intent(this, ResultActivity.class);
                startActivityForResult(intent, STATUS_CODE);
                break;
        }
    }

    private void call(String number){
        number = "tel:" + number;

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(number));

        startActivity(intent);
    }

    private void showLocation(Double longitude, Double latitude){
        Uri uri = Uri.parse("geo:" + longitude + "," + latitude);

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);

        startActivity(intent);
    }

    private void showSite(String url){
        Uri uri = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);

        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != STATUS_CODE){
            return;
        }

        if (resultCode != RESULT_OK){
            return;
        }

        _phoneEditText.setText(data.getStringExtra(Constants.PHONE_NUMBER));
        _browserEditText.setText(data.getStringExtra(Constants.BROWSER_LINK));


        //super.onActivityResult(requestCode, resultCode, data);
    }
}
