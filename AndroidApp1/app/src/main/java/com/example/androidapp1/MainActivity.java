package com.example.androidapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button dateBtn = (Button) findViewById(R.id.dateBtn);
        dateBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                EditText editTextYear = (EditText) findViewById(R.id.editTextYear);
                EditText editTextMonth = (EditText) findViewById(R.id.editTextMonth);
                EditText editTextDay = (EditText) findViewById(R.id.editTextDay);
                TextView textViewDate = (TextView) findViewById(R.id.textViewDate);
                textViewDate.setText(editTextMonth.getText().toString() + " " + editTextDay.getText().toString()
                + ", " + editTextYear.getText().toString());
            }
        });
    }
}