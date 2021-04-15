package com.example.customdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class CustomDialog extends AppCompatDialogFragment {
    private EditText editTextUsername;
    private EditText editTextPassword;
    private CustomDialogListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_alert, null);
        builder.setView(view);
        builder.setTitle("Login");
        builder.setNegativeButton("Cancel", (dialog, which) -> Toast.makeText(getContext(), "Canceled", Toast.LENGTH_LONG).show());
        builder.setPositiveButton("OK", (dialog, which) -> {
            listener.apply(editTextUsername.getText().toString(), editTextPassword.getText().toString());
        });
        builder.setCancelable(false);
        editTextUsername = view.findViewById(R.id.editTextUsername);
        editTextPassword = view.findViewById(R.id.editTextPassword);

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (CustomDialogListener) context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface CustomDialogListener {
        void apply(String username, String password);
    }
}