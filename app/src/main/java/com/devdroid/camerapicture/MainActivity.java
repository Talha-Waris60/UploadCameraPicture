package com.devdroid.camerapicture;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private final int Camera_REQ_CODE = 1;
    ImageView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         view = findViewById(R.id.cameraImg);
        Button button = findViewById(R.id.Btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(iCamera, Camera_REQ_CODE);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == Camera_REQ_CODE) {
                // For camera
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                view.setImageBitmap(bitmap);
            }
        }
    }
}