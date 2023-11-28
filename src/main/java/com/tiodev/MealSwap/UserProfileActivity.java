package com.tiodev.MealSwap;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.tiodev.MealSwap.R;
import com.tiodev.MealSwap.RoomDB.AppDatabase;
import com.tiodev.MealSwap.RoomDB.User;
import com.tiodev.MealSwap.RoomDB.UserDao;

public class UserProfileActivity extends AppCompatActivity {
    private EditText fullNameEditText;
    private EditText bioEditText;
    private EditText locationEditText;
    private ImageView profileImageView;
    private Button saveButton;

    private UserDao userDao;
    private int userId; // Assuming you have a way to get the current user's ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        // Initialize your views
        fullNameEditText = findViewById(R.id.fullNameEditText);
        bioEditText = findViewById(R.id.bioEditText);
        locationEditText = findViewById(R.id.locationEditText);
        profileImageView = findViewById(R.id.profileImageView);
        saveButton = findViewById(R.id.saveButton);

        // Initialize database and DAO
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();
        userDao = db.userDao();

        // Load user data
        userDao.getUserById(userId).observe(this, user -> {
            if (user != null) {
                fullNameEditText.setText(user.getFullName());
                bioEditText.setText(user.getBio());
                locationEditText.setText(user.getLocation());
                // Load profile image using the URL
            }
        });

        saveButton.setOnClickListener(v -> {
            String fullName = fullNameEditText.getText().toString();
            String bio = bioEditText.getText().toString();
            String location = locationEditText.getText().toString();

            User user = new User(); // Create a new User object or get it from the database
            user.setFullName(fullName);
            user.setBio(bio);
            user.setLocation(location);
            // Set the profile image URL if changed

            userDao.updateUser(user);
            // Notify user of success and/or finish the activity
        });
    }

    // Additional methods for handling profile image upload, etc.
}