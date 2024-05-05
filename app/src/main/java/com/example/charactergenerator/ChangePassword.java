package com.example.charactergenerator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChangePassword extends AppCompatActivity {
    Button generatorChangePasswordButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        generatorChangePasswordButton = findViewById(R.id.generatorChangePasswordButton);

        generatorChangePasswordButton.setOnClickListener(view -> Toast.makeText(ChangePassword.this, "Alas!  None of this is yet implemented.", Toast.LENGTH_SHORT).show());
    }
}