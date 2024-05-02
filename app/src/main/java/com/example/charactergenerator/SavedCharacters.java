package com.example.charactergenerator;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.charactergenerator.databinding.ActivitySavedCharactersBinding;

public class SavedCharacters extends AppCompatActivity {
    ActivitySavedCharactersBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_saved_characters);
        //Following line makes saved character details scroll
        binding.generatorSavedCharacterDetails.setMovementMethod(new ScrollingMovementMethod());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}