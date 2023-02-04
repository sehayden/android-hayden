package com.sehayden.hadnlab2;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RandomGeneratorActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText min;
    private EditText max;

    private Button btnGenerate;
    private TextView result;

    private final String REQUIRE = "Require";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_generator);
        min = findViewById(R.id.min);
        max = findViewById(R.id.max);
        btnGenerate = findViewById(R.id.btnGenerate);
        result = findViewById(R.id.result);

        btnGenerate.setOnClickListener(this);

    }
    private boolean checkInput(){
        if (TextUtils.isEmpty(min.getText().toString())){
            min.setError(REQUIRE);
            return false;
        }
        if (TextUtils.isEmpty(max.getText().toString())){
            max.setError(REQUIRE);
            return false;
        }
        return true;
    }
    private void randomize(){
        if (!checkInput()){
            return;
        }
        double minInt = Double.parseDouble(min.getText().toString());
        double maxInt = Double.parseDouble(max.getText().toString());
        if (minInt > maxInt){
            Toast.makeText(this, "Min must be smaller than max", Toast.LENGTH_SHORT).show();
            return;
        }
        int randomResult = (int) (minInt + Math.random() * (maxInt - minInt + 1));
        result.setText(String.valueOf(randomResult));
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnGenerate) {
            randomize();
        }
    }
}
