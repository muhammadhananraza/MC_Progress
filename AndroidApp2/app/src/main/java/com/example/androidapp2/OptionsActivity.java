package com.example.androidapp2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("options activity","onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("options activity","onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("options activity","onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("options activity","onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("options activity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("options activity","onDestroy");
    }


    public void goToGoogle(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(intent);
    }


    public void goToDial(View view) {
        Intent intent = new Intent(getApplicationContext(), DialActivity.class);
        startActivity(intent);
    }
}