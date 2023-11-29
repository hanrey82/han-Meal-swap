package com.tiodev.MealSwap.RoomDB;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "recipes") // Table for recipes
public class Recipe {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @NonNull
    public String img; // Image URL of the recipe

    @NonNull
    public String title; // Title of the recipe

    @NonNull
    public String des; // Description of the recipe

    @NonNull
    public String ing; // Ingredients

    @NonNull
    public String category; // Category of the recipe

    // Constructor
    public Recipe(String img, String title, String des, String ing, String category) {
        this.img = img;
        this.title = title;
        this.des = des;
        this.ing = ing;
        this.category = category;
    }

    public boolean getImg() {
        return false;
    }

    public CharSequence getTitle() {
        return null;
    }

    public boolean getDes() {
        return false;
    }

    public boolean getIng() {
        return false;
    }

    // Getters and Setters
    // ... (write getters and setters for each field)
}