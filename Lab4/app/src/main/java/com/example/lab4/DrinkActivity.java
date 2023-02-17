package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DrinkActivity extends AppCompatActivity {

    RadioGroup group;
    String selectedDrink;
    Button datMonBtn;
    boolean selected = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        group = findViewById(R.id.drinkGroup);
        RadioButton pepsi = findViewById(R.id.pepsi);
        RadioButton heineken = findViewById(R.id.heineken);
        RadioButton tiger = findViewById(R.id.tiger);
        RadioButton saiGonDo = findViewById(R.id.saiGonDo);

        Intent receivingIntent = getIntent();

        datMonBtn = findViewById(R.id.datMonBtn);
        datMonBtn.setOnClickListener(view -> {
            if (pepsi.isChecked()) {
                selectedDrink = pepsi.getText().toString();
                selected = true;
            } else if (heineken.isChecked()) {
                selectedDrink = heineken.getText().toString();
                selected = true;
            } else if (tiger.isChecked()) {
                selectedDrink = tiger.getText().toString();
                selected = true;
            } else if (saiGonDo.isChecked()) {
                selectedDrink = saiGonDo.getText().toString();
                selected = true;
            } else {
                Toast.makeText(getApplicationContext(), "Chọn một món", Toast.LENGTH_LONG).show();
            }
            if (selected) {
                Intent sendingIntent = new Intent(DrinkActivity.this, MainActivity.class);
                sendingIntent.putExtra("selectedDrink", selectedDrink);
                sendingIntent.putExtra("selectedFood", receivingIntent.getStringExtra("selectedFood"));
                startActivity(sendingIntent);
            }
        });
    }
}
