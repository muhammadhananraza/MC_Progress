package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String data[] = {"Earth", "Plato", "Mars", "Venus", "Mercury", "Jupiter", "Sun", "Moon", "Saturn",
            "Uranus", "Neptune", "Eris", "Comets", "Triton", "Nereid", "Miranda", "Lepidus", "Titan", "Mamas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rcView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapter(data));
    }
}