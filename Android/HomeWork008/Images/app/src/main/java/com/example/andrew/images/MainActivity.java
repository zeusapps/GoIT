package com.example.andrew.images;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private final static int CHECK_PERMISSION_CODE = 77;


    @BindView(R.id.main_imagesGridView)
    GridView imagesGridView;
    @BindView(R.id.main_imageFromFileImageView)
    ImageView imageFromFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        ImageAdapter adapter = new ImageAdapter(this, R.layout.image_item_template);

        adapter.add(R.drawable.image_1);
        adapter.add(R.drawable.image_2);
        adapter.add(R.drawable.image_3);
        adapter.add(R.drawable.image_4);

        imagesGridView.setAdapter(adapter);

        setLocalImage();
    }

    private void setLocalImage(){

        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    CHECK_PERMISSION_CODE);
            return;
        }

        String path = Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                .getPath() +
                "/file_to_load.png";

        File file = new File(path);
        if (file.exists()){
            Picasso p = Picasso.with(this);
            Uri uri = Uri.fromFile(file);
            p.setLoggingEnabled(true);
            p.load(uri)
                    .error(R.drawable.error)
                    .into(imageFromFile);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == CHECK_PERMISSION_CODE){
            setLocalImage();
        }
    }
}
