package com.example.androidapp2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("main activity","onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("main activity","onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("main activity","onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("main activity","onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("main activity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("main activity","onDestroy");
    }

    public void authenticateAndMove(View view) {
        TextView status = findViewById(R.id.statusTextView);
        EditText username = findViewById(R.id.usernameEditText);
        EditText password = findViewById(R.id.password);
        if (username.getText().toString().equals("user") && password.getText().toString().equals("abc")) {
            Intent intent = new Intent(this, OptionsActivity.class);
            startActivity(intent);
        } else {
            status.setText("Incorrect credentials");
        }
    }
}