package com.tiodev.MealSwap.RoomDB;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tiodev.MealSwap.RecipeActivity;
import com.tiodev.MealSwap.R;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private final List<Recipe> data;
    private final Context context;

    public RecipeAdapter(List<Recipe> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_item, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        final Recipe currentRecipe = data.get(position);

        holder.bind(currentRecipe);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView, categoryBtn;
        TextView titleTextView;

        RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.img);
            categoryBtn = itemView.findViewById(R.id.card_btn);
            titleTextView = itemView.findViewById(R.id.txt1);

            categoryBtn.setOnClickListener(v -> openRecipeActivity());
        }

        void bind(Recipe recipe) {
            titleTextView.setText(recipe.getTitle());
            Glide.with(imgView.getContext()).load(recipe.getImg()).into(imgView);
        }

        private void openRecipeActivity() {
            Recipe currentRecipe = data.get(getAdapterPosition());

            Intent intent = new Intent(context, RecipeActivity.class);
            intent.putExtra("img", currentRecipe.getImg());
            intent.putExtra("tittle", currentRecipe.getTitle());
            intent.putExtra("des", currentRecipe.getDes());
            intent.putExtra("ing", currentRecipe.getIng());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}



