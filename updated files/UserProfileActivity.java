package com.tiodev.MealSwap;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.tiodev.MealSwap.RoomDB.AppDatabase;
import com.tiodev.MealSwap.RoomDB.User;
import com.tiodev.MealSwap.RoomDB.UserDao;

public class UserProfileActivity extends AppCompatActivity {

    // Initialize your views
    private final EditText fullNameEditText = findViewById(R.id.fullNameEditText);
    private final EditText bioEditText = findViewById(R.id.bioEditText);
    private final EditText locationEditText = findViewById(R.id.locationEditText);
    private final ImageView profileImageView = findViewById(R.id.profileImageView);
    private final Button saveButton = findViewById(R.id.saveButton);

    private UserDao userDao;
    private int userId; // Assuming you have a way to get the current user's ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        // Initialize database and DAO
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();
        userDao = db.userDao();

        // Load user data
        userDao.getUserById(userId).observe(this, this::onChanged);

        saveButton.setOnClickListener(v -> {
            String fullName = fullNameEditText.getText().toString();
            String bio = bioEditText.getText().toString();
            String location = locationEditText.getText().toString();

            int id = 0;
            User user = new User(id); // Create a new User object or get it from the database
            user.setFullName(fullName);
            user.setBio(bio);
            user.setLocation(location);
            // Set the profile image URL if changed

            userDao.updateUser(user);
            // Notify user of success and/or finish the activity
        });
    }

    private void onChanged(Object user) {
        if (user != null) {
            fullNameEditText.setText(user.getClass().getModifiers());
            bioEditText.setText(user.getClass().getModifiers());
            locationEditText.setText(user.getClass().getModifiers());
            // Load profile image using the URL
        }
    }

    // Additional methods for handling profile image upload, etc.
}