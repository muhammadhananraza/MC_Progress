package com.example.mcassignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class ColorsActivity extends AppCompatActivity {

    String[] colors = {"Red", "Green", "Blue", "Yellow", "Pink", "Purple", "Black", "Orange", "Brown", "White"};
    int cursor;
    TextView textViewColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        /*customize the action bar*/
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(" Colors");
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setColor(Color.parseColor("#2478FA"));
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.colors_icon);
        actionBar.setDisplayUseLogoEnabled(true);

        if (savedInstanceState != null)
            cursor = savedInstanceState.getInt("cursor") == 0 ? colors.length - 1 : savedInstanceState.getInt("cursor") - 1;
        else
            cursor = new Random().nextInt(colors.length);

        textViewColor = findViewById(R.id.textViewColors);
        changeColorAndText();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("cursor", cursor);
    }

    public void changeView(View view) {
        changeColorAndText();
    }

    private void changeColorAndText() {
        textViewColor.setBackgroundColor(Color.parseColor(getRGB(colors[cursor].toUpperCase())));

        if (colors[cursor].toUpperCase().equals("WHITE"))
            textViewColor.setTextColor(Color.parseColor(getRGB("BLACK")));
        else
            textViewColor.setTextColor(Color.parseColor(getRGB("WHITE")));

        textViewColor.setText(colors[cursor++]);

        cursor %= colors.length;
    }

    private String getRGB(String color) {
        switch (color) {
            case "RED":
                return "#F51010";
            case "GREEN":
                return "#2DEE21";
            case "BLUE":
                return "#1D41E7";
            case "ORANGE":
                return "#F1640E";
            case "YELLOW":
                return "#FFFF06";
            case "PINK":
                return "#F50FE7";
            case "BROWN":
                return "#BF8A05";
            case "BLACK":
                return "#000000";
            case "PURPLE":
                return "#8A2BE2";
            case "WHITE":
                return "#FFFFFF";
        }
        return "#FFFFFF";
    }
}