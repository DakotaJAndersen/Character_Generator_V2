package com.Database;

import android.app.Application;
import android.util.Log;

import com.Database.Entities.HairType;
import com.Database.Entities.User;
import com.example.charactergenerator.MainActivity;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CharacterGeneratorRepository {
    private HairTypeDAO htDAO;
    private final UserDAO userDAO;
    public HairType hairType;
    private List<HairType> allHairTypes;

    private static CharacterGeneratorRepository repository;

    private CharacterGeneratorRepository(Application application) {
        CharacterGeneratorDatabase db = CharacterGeneratorDatabase.getDatabase(application);
        this.htDAO = db.hairTypeDAO();
        this.allHairTypes = this.htDAO.getAllRecords();
        this.userDAO = db.userDAO();
    }

    public List<HairType> getAllHairTypes() {
        Future<List<HairType>> future = CharacterGeneratorDatabase.databaseWriteExecutor.submit(
                new Callable<List<HairType>>() {
                    @Override
                    public List<HairType> call() throws Exception {
                        return htDAO.getAllRecords();
                    }
                }
            );
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static CharacterGeneratorRepository getRepository(Application application){
        if(repository!= null){
            return repository;
        }
        Future<CharacterGeneratorRepository> future = CharacterGeneratorDatabase.databaseWriteExecutor.submit(
                new Callable<CharacterGeneratorRepository>() {
                    @Override
                    public CharacterGeneratorRepository call() throws Exception {
                        return new CharacterGeneratorRepository(application);
                    }
                }
        );
        try{
            return future.get();
        }catch(InterruptedException | ExecutionException e){
            Log.d(MainActivity.TAG, "Problem getting CharacterGeneratorRepository, thread error.");
        }
        return null;
    }

    public void insertHairType(HairType ht){
        CharacterGeneratorDatabase.databaseWriteExecutor.execute(()->
        {
            htDAO.insert(hairType);
        });
    }

    public void insertUser(User... user){
        CharacterGeneratorDatabase.databaseWriteExecutor.execute(()->
        {
            userDAO.insert(user);
        });
    }

}

