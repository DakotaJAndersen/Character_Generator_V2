package com.example.charactergenerator;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EditSavedCharacters extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button generatorRemoveSelectedCharactersButton;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_saved_characters);

        generatorRemoveSelectedCharactersButton = findViewById(R.id.generatorRemoveSelectedCharactersButton);

        generatorRemoveSelectedCharactersButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //Follows: The code for the popup with the two options.
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(EditSavedCharacters.this);
                final AlertDialog alertDialog = alertBuilder.create();

                alertBuilder.setMessage("Remove selected characters?");

                alertBuilder.setPositiveButton("Remove", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //logout();
                        CharSequence text = "Saved characters not yet implemented.";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(EditSavedCharacters.this, text, duration);
                        toast.show();
                        alertDialog.dismiss();
                    }
                });
                alertBuilder.setNegativeButton("Go back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.dismiss();
                    }
                });
                alertBuilder.create().show();
            }
            //end code for options popup
        });
    }
}