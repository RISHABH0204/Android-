package com.example.diceroller.db;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNote(User user);

    /*@Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(list<User> user);*/

    @Query("SELECT * From history")
    List<User> getAllData();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User... users);
}
