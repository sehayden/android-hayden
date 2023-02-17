package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button chonThucAnBtn = findViewById(R.id.chonThucAnBtn);
        Button chonDoUongBtn = findViewById(R.id.chonDoUongBtn);
        TextView selectedFood = findViewById(R.id.selectedFood);
        TextView selectedDrink = findViewById(R.id.selectedDrink);

        Intent intent = getIntent();
        selectedFood.setText(intent.getStringExtra("selectedFood"));
        selectedDrink.setText(intent.getStringExtra("selectedDrink"));

        chonThucAnBtn.setOnClickListener(view -> {
            Intent foodIntent = new Intent(MainActivity.this, FoodActivity.class);
            foodIntent.putExtra("selectedDrink", intent.getStringExtra("selectedDrink"));
            foodIntent.putExtra("selectedFood", intent.getStringExtra("selectedFood"));
            startActivity(foodIntent);
        });
        chonDoUongBtn.setOnClickListener(view -> {
            Intent drinkIntent = new Intent(MainActivity.this, DrinkActivity.class);
            drinkIntent.putExtra("selectedDrink", intent.getStringExtra("selectedDrink"));
            drinkIntent.putExtra("selectedFood", intent.getStringExtra("selectedFood"));
            startActivity(drinkIntent);
        });

    }
}