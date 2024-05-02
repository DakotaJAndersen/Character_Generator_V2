package com.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.Database.Entities.HairType;
import com.Database.Entities.SavedCharacters;

@Database(entities = {HairType.class, SavedCharacters.class}, version = 1, exportSchema = false)
public abstract class CharacterGeneratorDatabase extends RoomDatabase {


    public static final String hairTypeTable = "hairTypeTable";


}
