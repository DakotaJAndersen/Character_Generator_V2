package com.Database.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.Database.CharacterGeneratorDatabase;

import java.util.Objects;

@Entity(tableName = CharacterGeneratorDatabase.hairTypeTable)
public class HairType {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private Integer hairTypeID = 0;
    private String hairType;

    //FOLLOWS: AUTOGENERATED GETTERS AND SETTERS
    @NonNull
    public Integer getHairTypeID() {
        return hairTypeID;
    }

    public void setHairTypeID(@NonNull Integer hairTypeID) {
        this.hairTypeID = hairTypeID;
    }

    public String getHairType() {
        return hairType;
    }

    public void setHairType(String hairType) {
        this.hairType = hairType;
    }
    //END AUTOGENERATED GETTERS AND SETTERS
    //FOLLOWS: AUTOGENERATED EQUALS AND HASHCODE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HairType hairType1 = (HairType) o;
        return Objects.equals(hairTypeID, hairType1.hairTypeID) && Objects.equals(hairType, hairType1.hairType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hairTypeID, hairType);
    }
    //END AUTOGENERATED EQUALS AND HASHCODE

    //I don't want it to be possible to initialize
    //a new HairType object with no hairType.  Thus
    //the constructor requires a hairType.
    public HairType(String hairType) {
        this.hairType = hairType;
    }
}
