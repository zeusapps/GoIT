package com.example.eugen.offline004;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_DIR = "photos";
    private static final int PHOTO_CAPTURED_REQUEST_CODE = 77;
    private static Uri _fileUri;

    @BindView(R.id.main_originalSourceImageView)
    ImageView originalImageView;
    @BindView(R.id.main_changedImageView)
    ImageView changedImageView;
    @BindView(R.id.main_originalDimensionsTextView)
    TextView originalTextView;
    @BindView(R.id.main_changedDimensionsTextView)
    TextView changedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.main_captureScreenButton)
    public void captureImage(){
        _fileUri = getFileUri();
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, _fileUri);
        startActivityForResult(intent, PHOTO_CAPTURED_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode != PHOTO_CAPTURED_REQUEST_CODE || resultCode != RESULT_OK){
            return;
        }

        Bitmap image = BitmapFactory.decodeFile(_fileUri.getPath());
        originalImageView.setImageBitmap(image);
    }

    private Uri getFileUri(){
        File file = new File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                FILE_DIR);
        if (!file.exists()){
            if(!file.mkdirs()){
                return null;
            }
        }

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());

        File result = new File(file.getPath() + File.separator + "IMG_" + timestamp + ".jpg");

        return Uri.fromFile(result);
    }
}