package com.example.charactergenerator;

import static com.example.charactergenerator.databinding.ActivityMainBinding.inflate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.charactergenerator.databinding.ActivitySettingsBinding;

public class SettingsActivity extends AppCompatActivity {

    Button generatorChangePasswordButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        generatorChangePasswordButton = findViewById(R.id.generatorChangePasswordButton);

        generatorChangePasswordButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SettingsActivity.this, ChangePassword.class);
                startActivity(intent);
            }
        });

    }
}