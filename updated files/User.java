package com.tiodev.MealSwap.RoomDB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Collection;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title; // Changed from CharSequence, assuming you don't need specific CharSequence features
    private String img; // Assuming this is an image URL or path
    private String des; // Description as String
    private String ing; // Ingredients as String
    private String location;
    private String bio;
    private String fullName;

    // Constructor, getters, and setters

    public User(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title != null ? title : null;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getIng() {
        return ing;
    }

    public void setIng(String ing) {
        this.ing = ing;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBio() {
        return bio;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public int getId() {
        return id;
    }

    // Setter method for 'id' (optional if you have autoGenerate set to true)
    public void setId(int id) {
        this.id = id;
    }

    public Collection<Object> getCategory() {
        return null;
    }
}
