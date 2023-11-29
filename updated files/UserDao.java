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

    @Query("SELECT * FROM User WHERE id = :userId")
    LiveData<User> getUserById(int userId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    default <User>
    void insertUser(User user) {

    }

    @Update
    default <User>
    void updateUser(User user) {

    }

    @Query("SELECT * FROM User")
    default <User>
    List<com.tiodev.MealSwap.RoomDB.User> getAll() {
        return null;
    }

    default <User> void updateUser(com.tiodev.MealSwap.RoomDB.User user) {

    }

    // Other DAO methods...
    // Consider adding methods for specific queries if needed
}
