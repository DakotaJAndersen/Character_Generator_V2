package com.Database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.Database.Entities.HairType;
import com.Database.Entities.User;
import com.example.charactergenerator.MainActivity;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {HairType.class, User.class}, version = 7, exportSchema = false)
public abstract class CharacterGeneratorDatabase extends RoomDatabase {

    public static final String USER_TABLE = "userTable";
    private static final String DATABASE_NAME = "CharacterGeneratorDatabase";
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
                            .addCallback(addDefaultValues)
                            .build();

                }
            }
        }
        return INSTANCE;

    }
        private static final RoomDatabase.Callback addDefaultValues = new RoomDatabase.Callback(){
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db){
                super.onCreate(db);
                Log.i(MainActivity.TAG, "Database Created!");
                databaseWriteExecutor.execute(() -> {
                    UserDAO userdao = INSTANCE.userDAO();
                    //dao.deleteAll();

                    //Default Users
                    User admin = new User("admin1", "admin1");
                    admin.setAdmin(true);
                    userdao.insert(admin);
                    User testUser1 = new User("testuser1", "testuser1");
                    userdao.insert(testUser1);

                    //Preset Hair Types
                    HairTypeDAO hairtypedao = INSTANCE.hairTypeDAO();
                    HairType curly = new HairType("curly");
                    hairtypedao.insert(curly);
                    HairType wavy = new HairType("wavy");
                    hairtypedao.insert(wavy);
                    HairType straight = new HairType("straight");
                    hairtypedao.insert(straight);
                    HairType fancy = new HairType("fancy");
                    hairtypedao.insert(fancy);
                    HairType casualHair = new HairType("casual");
                    hairtypedao.insert(casualHair);
                        });
            }
        };

    public abstract HairTypeDAO hairTypeDAO();

    public abstract UserDAO userDAO();
}
