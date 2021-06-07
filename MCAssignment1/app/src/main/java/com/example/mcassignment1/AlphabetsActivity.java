package com.example.mcassignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AlphabetsActivity extends AppCompatActivity {

    ImageView imageViewAlphabets;
    MediaPlayer mediaPlayer;
    char[] alphabets = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    int cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabets);

        /*customize the action bar*/
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(" Words");
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setColor(Color.parseColor("#2478FA"));
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.words_icon);
        actionBar.setDisplayUseLogoEnabled(true);

        if (savedInstanceState != null)
            cursor = savedInstanceState.getInt("cursor") == 0 ? alphabets.length - 1 : savedInstanceState.getInt("cursor") - 1;
        else
            cursor = 0;
        imageViewAlphabets = findViewById(R.id.imageViewAlphabets);
        changeImageAndPlayAudio();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("cursor", cursor);
    }

    public void changeImage(View view) {
        changeImageAndPlayAudio();
    }

    private void changeImageAndPlayAudio() {
        imageViewAlphabets.setImageResource(getImageId());
        playAlphabetAudio();
        cursor = (cursor + 1) % alphabets.length;
    }

    private void playAlphabetAudio() {
        mediaPlayer = MediaPlayer.create(getApplicationContext(), getAudioResourceId());
        mediaPlayer.start();
    }

    private int getImageId() {
        switch (cursor) {
            case 0:
                return R.drawable.a;
            case 1:
                return R.drawable.b;
            case 2:
                return R.drawable.c;
            case 3:
                return R.drawable.d;
            case 4:
                return R.drawable.e;
            case 5:
                return R.drawable.f;
            case 6:
                return R.drawable.g;
            case 7:
                return R.drawable.h;
            case 8:
                return R.drawable.i;
            case 9:
                return R.drawable.j;
            case 10:
                return R.drawable.k;
            case 11:
                return R.drawable.l;
            case 12:
                return R.drawable.m;
            case 13:
                return R.drawable.n;
            case 14:
                return R.drawable.o;
            case 15:
                return R.drawable.p;
            case 16:
                return R.drawable.q;
            case 17:
                return R.drawable.r;
            case 18:
                return R.drawable.s;
            case 19:
                return R.drawable.t;
            case 20:
                return R.drawable.u;
            case 21:
                return R.drawable.v;
            case 22:
                return R.drawable.w;
            case 23:
                return R.drawable.x;
            case 24:
                return R.drawable.y;
            case 25:
                return R.drawable.z;
        }
        return 0;
    }

    private int getAudioResourceId() {
        switch (cursor) {
            case 0:
                return R.raw.apple;
            case 1:
                return R.raw.ball;
            case 2:
                return R.raw.car;
            case 3:
                return R.raw.dog;
            case 4:
                return R.raw.egg;
            case 5:
                return R.raw.flower;
            case 6:
                return R.raw.guitar;
            case 7:
                return R.raw.house;
            case 8:
                return R.raw.icecream;
            case 9:
                return R.raw.jar;
            case 10:
                return R.raw.kite;
            case 11:
                return R.raw.lion;
            case 12:
                return R.raw.moon;
            case 13:
                return R.raw.notebook;
            case 14:
                return R.raw.orange;
            case 15:
                return R.raw.panda;
            case 16:
                return R.raw.queen;
            case 17:
                return R.raw.rabbit;
            case 18:
                return R.raw.sun;
            case 19:
                return R.raw.tree;
            case 20:
                return R.raw.umbrella;
            case 21:
                return R.raw.volcano;
            case 22:
                return R.raw.watermelon;
            case 23:
                return R.raw.xray;
            case 24:
                return R.raw.yoyo;
            case 25:
                return R.raw.zebra;
        }
        return 0;
    }
}