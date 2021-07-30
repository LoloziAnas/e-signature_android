package com.lzi.e_signature_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonNext = findViewById(R.id.btn_next);
        buttonNext.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, SignatureActivity.class);
            startActivity(i);
            finish();
        });
    }
}