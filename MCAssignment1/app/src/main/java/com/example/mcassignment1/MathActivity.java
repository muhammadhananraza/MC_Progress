package com.example.mcassignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MathActivity extends AppCompatActivity {

    int num1, num2;
    char operator;
    TextView textViewQuestion, textViewOption1, textViewOption2, textViewStatus;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        /*customize the action bar*/
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(" Maths");
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setColor(Color.parseColor("#2478FA"));
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.maths_icon);
        actionBar.setDisplayUseLogoEnabled(true);

        if (savedInstanceState != null) {
            num1 = savedInstanceState.getInt("num1");
            num2 = savedInstanceState.getInt("num2");
            operator = savedInstanceState.getChar("operator");
        } else {
            selectNumbersRandomly();
        }
        textViewQuestion = findViewById(R.id.textViewQuestion);
        textViewOption1 = findViewById(R.id.textViewOption1);
        textViewOption2 = findViewById(R.id.textViewOption2);
        textViewStatus = findViewById(R.id.textViewStatus);
        setQuestionAndOptions();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("num1", num1);
        outState.putInt("num2", num2);
        outState.putChar("operator", operator);
    }

    @SuppressLint("SetTextI18n")
    private void setQuestionAndOptions() {
        textViewQuestion.setText(num1 + " " + operator + " " + num2 + " = ");
        textViewOption1.setText(Integer.toString(getAnswer()));
        textViewOption2.setText(Integer.toString(getAnswer() + new Random().nextInt(9) + 1));
    }


    private int getAnswer() {
        switch (operator) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case 'x': return num1 * num2;
        }
        return 0;
    }

    @SuppressLint("SetTextI18n")
    private void verifyAnswer(int ans) {
        if (ans == getAnswer()) {
            textViewStatus.setTextColor(Color.parseColor("#37FA21"));
            textViewStatus.setText("Correct Answer");
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.great);
        } else {
            textViewStatus.setTextColor(Color.parseColor("#DC1414"));
            textViewStatus.setText("Incorrect Answer");
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.oops);
        }
        mediaPlayer.start();
    }

    public void checkOption1(View view) {
        verifyAnswer(Integer.parseInt(textViewOption1.getText().toString()));
    }

    public void checkOption2(View view) {
        verifyAnswer(Integer.parseInt(textViewOption2.getText().toString()));
    }

    private void selectNumbersRandomly() {
        Random random = new Random();
        num1 = random.nextInt(10) + 1;
        num2 = random.nextInt(10) + 1;
        switch (random.nextInt(3)) {
            case 0: operator = '+'; break;
            case 1: operator = '-'; break;
            case 2: operator = 'x';
        }
    }

    private void clearStatus() {
        textViewStatus.setText("");
    }

    public void moveToNextQuestion(View view) {
        clearStatus();
        selectNumbersRandomly();
        setQuestionAndOptions();
    }
}