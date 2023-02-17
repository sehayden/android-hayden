package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FoodActivity extends AppCompatActivity {

    RadioGroup group;
    String selectedFood;
    Button datMonBtn;
    boolean selected = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        group = findViewById(R.id.foodGroup);
        RadioButton bunBoHue = findViewById(R.id.bunBoHue);
        RadioButton phoHaNoi = findViewById(R.id.phoHaNoi);
        RadioButton miQuang = findViewById(R.id.miQuang);
        RadioButton huTiuSaiGon = findViewById(R.id.huTiuSaiGon);

        Intent receivingIntent = getIntent();

        datMonBtn = findViewById(R.id.datMonBtn);
        datMonBtn.setOnClickListener(view -> {
            if (bunBoHue.isChecked()) {
                selectedFood = bunBoHue.getText().toString();
                selected = true;
            } else if (phoHaNoi.isChecked()) {
                selectedFood = phoHaNoi.getText().toString();
                selected = true;
            } else if (miQuang.isChecked()) {
                selectedFood = miQuang.getText().toString();
                selected = true;
            } else if (huTiuSaiGon.isChecked()) {
                selectedFood = huTiuSaiGon.getText().toString();
                selected = true;
            } else {
                Toast.makeText(getApplicationContext(), "Chọn một món", Toast.LENGTH_LONG).show();
            }
            if (selected) {
                Intent intent = new Intent(FoodActivity.this, MainActivity.class);
                intent.putExtra("selectedFood", selectedFood);
                intent.putExtra("selectedDrink", receivingIntent.getStringExtra("selectedDrink"));
                startActivity(intent);
            }
        });
    }
}
