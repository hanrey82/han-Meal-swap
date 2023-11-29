package com.tiodev.MealSwap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.airbnb.lottie.LottieAnimationView;
import com.tiodev.MealSwap.Adapter.AdapterPopular;
import com.tiodev.MealSwap.Model.ResModel;
import com.tiodev.MealSwap.RoomDB.AppDatabase;
import com.tiodev.MealSwap.RoomDB.User;
import com.tiodev.MealSwap.RoomDB.UserDao;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    ImageView salad, main, drinks, dessert, menu;
    RecyclerView rcview_home;
    List<User> dataPopular = new ArrayList<>();
    LottieAnimationView lottie;
    EditText editText;
    List<ResModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Find views
        salad = findViewById(R.id.salad);
        main = findViewById(R.id.MainDish);
        drinks = findViewById(R.id.Drinks);
        dessert = findViewById(R.id.Desserts);
        rcview_home = findViewById(R.id.rcview_popular);
        lottie = findViewById(R.id.lottie);
        editText = findViewById(R.id.editText);
        menu = findViewById(R.id.imageView);

        // Set layout to recyclerView
        rcview_home.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Set Popular recipes
        setPopularList();

        // Category buttons- start new activity with intent method "start"
        boolean title = false;
        salad.setOnClickListener(v -> start("Salad", "Salad", title));
        main.setOnClickListener(v -> start("Dish", "Main dish", title));
        drinks.setOnClickListener(v -> start("Drinks", "Drinks", title));
        dessert.setOnClickListener(v -> start("Desserts", "Dessert", title));

        // Open search activity
        editText.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
            startActivity(intent);

        });

    }

    public void setPopularList() {

        // Get database
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "db_name").allowMainThreadQueries()
                .createFromAsset("database/recipe.db")
                .build();
        UserDao userDao = db.userDao();

        // Get all recipes from database
        List<User> recipes = userDao.getAll();

        // Filter Popular category from all recipes
        for (int i = 0; i < recipes.size(); i++) {
            if (recipes.get(i).getCategory().contains("Popular")) {
                dataPopular.add(recipes.get(i));
            }
        }

        // Set popular list to adapter
        AdapterPopular adapter = new AdapterPopular(dataPopular, getApplicationContext());
        rcview_home.setAdapter(adapter);

        // Hide progress animation
        lottie.setVisibility(View.GONE);

    }

    // Start MainActivity(Recipe list) with intent message
    public void start(String p, String tittle, boolean title) {
        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
        intent.putExtra("Category", p);
        intent.putExtra("title", title);
        startActivity(intent);
    }
}
