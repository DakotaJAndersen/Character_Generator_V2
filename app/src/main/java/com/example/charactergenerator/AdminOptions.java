package com.example.charactergenerator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdminOptions extends AppCompatActivity {

    Button generatorManageUsersButton;
    Button generatorManageListsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_options);

        generatorManageUsersButton = findViewById(R.id.generatorManageUsersButton);
        generatorManageListsButton = findViewById(R.id.generatorManageListsButton);

        generatorManageUsersButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(AdminOptions.this, ManageUsers.class);
                startActivity(intent);
            }
        });

        generatorManageListsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(AdminOptions.this, ManageLists.class);
                startActivity(intent);
            }
        });
    }
}