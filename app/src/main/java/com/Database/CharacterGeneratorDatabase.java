package com.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.Database.Entities.HairType;
import com.Database.Entities.SavedCharacters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {HairType.class, SavedCharacters.class}, version = 1, exportSchema = false)
public abstract class CharacterGeneratorDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "CharacterGeneratorDatabase"
    public static final String hairTypeTable = "hairTypeTable";

    private static volatile CharacterGeneratorDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    static CharacterGeneratorDatabase getDatabase(final Context context){
        if(INSTANCE==null){
            synchronized(CharacterGeneratorDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    CharacterGeneratorDatabase.class,
                                    DATABASE_NAME
                                    )
                            .fallbackToDestructiveMigration()
                            //.addCallback(addDefaultValues)
                            .build();

                }
            }
        }
        return INSTANCE;
        /*
        private static final RoomDatabase.Callback addDefaultValues = new RoomDatabase.Callback(){
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db){
                super.onCreate(db);
                //TODO: add databaseWriteExecutor.execute(() -> {...}
            }
        };
        */


    }
}
