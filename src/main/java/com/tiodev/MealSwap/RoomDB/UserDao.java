package com.tiodev.MealSwap.RoomDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    // Existing methods

    @Query("SELECT * FROM users WHERE id = :userId")
    <User>
    LiveData<User> getUserById(int userId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    <User>
    void insertUser(User user);

    @Update
    <User>
    void updateUser(User user);

    @Query("SELECT * FROM users")
    <User>
    LiveData<List<User>> getAll();

    // Other DAO methods...
    // Consider adding methods for specific queries if needed
}
