package com.lzi.e_signature_android;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.gcacace.signaturepad.views.SignaturePad;

public class SignatureActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature);
        SignaturePad signature = findViewById(R.id.signature);
        Button buttonSave = findViewById(R.id.saveButton);
        Button buttonClear = findViewById(R.id.clearButton);

        //disable both buttons at start
        buttonClear.setEnabled(false);
        buttonSave.setEnabled(false);
        signature.setOnSignedListener(new SignaturePad.OnSignedListener() {
            @Override
            public void onStartSigning() {

            }

            @Override
            public void onSigned() {
                buttonClear.setEnabled(true);
                buttonSave.setEnabled(true);
            }

            @Override
            public void onClear() {
                buttonClear.setEnabled(false);
                buttonSave.setEnabled(false);
            }
        });
        buttonSave.setOnClickListener(v -> {
            Bitmap signatureBimap = signature.getSignatureBitmap();
            // set MainLayout invisible
            LinearLayout main = findViewById(R.id.mainLayout);
            main.setVisibility(View.GONE);
            // set SignatureLayout visible
            LinearLayout signatureLayout = findViewById(R.id.signatureLayout);
            signatureLayout.setVisibility(View.VISIBLE);
            //binding imageView
            ImageView imageViewSignature = findViewById(R.id.iv_signature);
            imageViewSignature.setImageBitmap(signatureBimap);
            Toast.makeText(getApplicationContext(), "Signature Saved", Toast.LENGTH_SHORT).show();
        });
        buttonClear.setOnClickListener(v -> signature.clear());
    }
}