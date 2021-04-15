package com.example.customdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CustomDialog.CustomDialogListener {

    private TextView textViewUsername;
    private TextView textViewPassword;
    Button btnDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewUsername = findViewById(R.id.textViewUsername);
        textViewPassword = findViewById(R.id.textViewPassword);
        btnDialog = findViewById(R.id.btnDialog);
        btnDialog.setOnClickListener(v -> openDialog());
    }

    private void openDialog() {
        CustomDialog customDialog = new CustomDialog();
        customDialog.show(getSupportFragmentManager(), "Custom Dialog");
    }

    @Override
    public void apply(String username, String password) {
        textViewUsername.setText(username);
        textViewPassword.setText(password);
    }
}