package com.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.Database.Entities.HairType;

import java.util.List;

@Dao
public interface HairTypeDAO {
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    void insert(HairType ht1);

    @Query("Select * from " + CharacterGeneratorDatabase.hairTypeTable)
    List<HairType> getAllRecords();
}
