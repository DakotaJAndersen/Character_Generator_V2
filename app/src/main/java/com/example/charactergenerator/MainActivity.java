package com.example.charactergenerator;

import static com.example.charactergenerator.databinding.ActivityMainBinding.inflate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.charactergenerator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.generatorSavedCharactersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Saved Character Screen not yet implemented", Toast.LENGTH_SHORT).show();
            }
        });
    }
}