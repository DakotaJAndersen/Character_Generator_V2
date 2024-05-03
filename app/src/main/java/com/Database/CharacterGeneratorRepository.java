package com.Database;

import android.app.Application;

import com.Database.Entities.HairType;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CharacterGeneratorRepository {
    private HairTypeDAO htDAO;
    public HairType hairType;
    private List<HairType> allHairTypes;

    public CharacterGeneratorRepository(Application application) {
        CharacterGeneratorDatabase db = CharacterGeneratorDatabase.getDatabase(application);
        this.htDAO = db.hairTypeDAO();
        this.allHairTypes = this.htDAO.getAllRecords();
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

    public void insertHairType(HairType ht){
        CharacterGeneratorDatabase.databaseWriteExecutor.execute(()->
        {
            htDAO.insert(hairType);
        });
    }

}

