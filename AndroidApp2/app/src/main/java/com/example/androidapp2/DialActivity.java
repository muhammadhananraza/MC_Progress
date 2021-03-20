package com.example.androidapp2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("dial activity","onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("dial activity","onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("dial activity","onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("dial activity","onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("dial activity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("dial activity","onDestroy");
    }

    public void dialNumber(View view) {
        EditText number = findViewById(R.id.numberPhone);
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number.getText().toString()));
        startActivity(intent);
    }
}