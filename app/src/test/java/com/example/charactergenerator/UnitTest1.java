package com.example.charactergenerator;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnitTest1 {
    @Test
    public void getTAG(){
        assertEquals("CHARACTER_GENERATOR", MainActivity.TAG);
    }

    @Test
    public void getButtonIDNotNull(){
        assertNotEquals(null, R.id.generatorManageUsersButton);
    }

}
