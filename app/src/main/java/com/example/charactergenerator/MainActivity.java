package com.example.charactergenerator;

import static com.example.charactergenerator.databinding.ActivityMainBinding.inflate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
//import android.widget.Toast;

import com.Database.CharacterGeneratorRepository;
import com.Database.Entities.User;
import com.example.charactergenerator.databinding.ActivityMainBinding;


/**
 * @author Dakota Andersen
 * Title: Character Generator
 * Description: This is an application intended to create
 * and optionally save randomly generated character descriptions
 * with attributes selected from database tables.
 * */
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private CharacterGeneratorRepository repository;

    public static final String TAG = "CHARACTER_GENERATOR";

    //Note: Login not currently in use.  TODO:Add login information
    //private int loggedInUserId = -1;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //NOTE: NO LONGER USING LOGIN DUE TO ERRORS
        //loginUser();

        invalidateOptionsMenu();


        //NOTE: NO LONGER USING LOGIN DUE TO ERRORS
        /*
        if(loggedInUserId == -1){
            Intent intent = LoginActivity.loginIntentFactory(getApplicationContext());
            startActivity(intent);
        }
         */

        repository = CharacterGeneratorRepository.getRepository(getApplication());

        //Makes the Saved Characters button direct to Saved Characters screen
        binding.generatorSavedCharactersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSavedCharacters();
            }
        });

        //Makes Generate Character button direct to Generate Character screen
        binding.generatorGenerateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGenerateCharacter();
            }
        });

        //Makes Settings button direct to Settings screen
        binding.generatorSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });

        binding.generatorAdminOptionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdminOptions();
            }
        });

    }




    //NOTE: NO LONGER USING LOGIN DUE TO ERRORS
    /*
    private void loginUser() {
        //TODO: make login method functional
        user = new User("Drew", "password");
    }
     */

    //The following code relates to the Options menu (Logout menu)
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logout_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        MenuItem item = menu.findItem(R.id.menuLogout);
        item.setVisible(true);
        //This commented out line would make the Options menu (logout menu) display username instead of Logged In
        //item.setTitle(user.getUsername());
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(){
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item){
                showLogoutDialog();
                return false;
            }
        });
        return true;
    }

    //Follows: Dialog box for Logging Out (note: login not currently implemented)
    private void showLogoutDialog() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
        final AlertDialog alertDialog = alertBuilder.create();

        alertBuilder.setMessage("Log out?");

        alertBuilder.setPositiveButton("logout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //logout();
                CharSequence text = "Login not yet implemented.";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(MainActivity.this, text, duration);
                toast.show();
                alertDialog.dismiss();
            }
        });
    alertBuilder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            alertDialog.dismiss();
        }
    });
        alertBuilder.create().show();
    }
    //End dialog box code

    //NOTE: LOGIN SCREEN NOT CURRENTLY IN USE
    /*
    private void logout() {
        //Todo: Finish logout method
        startActivity(LoginActivity.loginIntentFactory(getApplicationContext()));
    }
     */

    //This method makes the button press for Saved Characters run.
    private void openSavedCharacters(){
        Intent intent = new Intent(this, SavedCharacters.class);
        startActivity(intent);

    }

    //This method makes the button press for Generate Character run.
    private void openGenerateCharacter(){
        Intent intent = new Intent(this, GenerateCharacter.class);
        startActivity(intent);

    }

    //This method makes the button press for Settings run.
    private void openSettings(){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);

    }

    //This method makes the button press for AdminOptions run.
    private void openAdminOptions() {
        Intent intent = new Intent (this, AdminOptions.class);
        startActivity(intent);
    }



}