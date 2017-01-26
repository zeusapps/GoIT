package com.example.atlassian.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private ImageView _image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _image = (ImageView) findViewById(R.id.activity_main_image);

        DownloadImage di = new DownloadImage();
        di.execute("http://sport.ua/images/news/0/8/64/orig_332808.jpg");
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
