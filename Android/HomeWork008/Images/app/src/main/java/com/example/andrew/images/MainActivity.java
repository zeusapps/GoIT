package com.example.andrew.images;

import android.net.Uri;
import android.os.Environment;
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

        String path =
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath() +
                "/file_to_load.png";

        Log.d("teeegsdfsfsdf", path);

        File file = new File(path);
        Picasso
                .with(this)
                .load(file)
                .error(R.drawable.error)
                .into(imageFromFile);
    }
}
