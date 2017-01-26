package com.example.atlassian.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView _image;
    private TextView _counterTextView;
    private Button _button;
    private int _counter;
    private Handler _handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _image = (ImageView) findViewById(R.id.activity_main_image);
        _counterTextView = (TextView) findViewById(R.id.activity_main_counter);
        _button = (Button) findViewById(R.id.activity_main_incCounterButton);

        _button.setOnClickListener(this);


        DownloadImage di = new DownloadImage();
        di.execute("http://sport.ua/images/news/0/8/64/orig_332808.jpg");

        _handler = new Handler();
        incDelayed();
    }

    @Override
    public void onClick(View v) {
        incrementCounter();
    }

    private void incDelayed(){
        _handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (incrementCounter()){
                    incDelayed();
                }
            }
        }, 2000);
    }

    private boolean incrementCounter(){
        if (_counter >= 30){
            return false;
        }

        _counter++;
        _counterTextView.setText("Counter: " + _counter);
        return true;
    }


    public class DownloadImage extends AsyncTask<String, String, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... params) {
            Request request = new Request.Builder()
                    .url(params[0])
                    .get()
                    .build();

            try{
                Response response = new OkHttpClient().newCall(request).execute();

                return BitmapFactory.decodeStream(response.body().byteStream());
            }
            catch (IOException e){
                //
            }

            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            _image.setImageBitmap(bitmap);
        }
    }
}
