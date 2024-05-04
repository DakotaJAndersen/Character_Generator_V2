package com.example.charactergenerator;

import static com.example.charactergenerator.databinding.ActivityMainBinding.inflate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//import android.widget.Toast;

import com.Database.CharacterGeneratorRepository;
import com.example.charactergenerator.databinding.ActivityMainBinding;

/** @noinspection Convert2Lambda*/
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private CharacterGeneratorRepository repository;

    public static final String TAG = "CHARACTER_GENERATOR";

    //TODO:Add login information
    int loggedInUserId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loginUser();

        if(loggedInUserId == -1){
            Intent intent = LoginActivity.loginIntentFactory(getApplicationContext());
            startActivity(intent);
        }

        repository = CharacterGeneratorRepository.getRepository(getApplication());

        binding.generatorSavedCharactersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSavedCharacters();
            }
        });

        binding.generatorGenerateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGenerateCharacter();
            }
        });

        binding.generatorSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });

    }

    private void loginUser() {
        //TODO: create login method
    }

    private void openSavedCharacters(){
        Intent intent = new Intent(this, SavedCharacters.class);
        startActivity(intent);

    }

    private void openGenerateCharacter(){
        Intent intent = new Intent(this, GenerateCharacter.class);
        startActivity(intent);

    }

    private void openSettings(){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);

    }



}