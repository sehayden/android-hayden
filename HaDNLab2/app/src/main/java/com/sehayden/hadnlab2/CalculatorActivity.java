package com.sehayden.hadnlab2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText first;
    private EditText second;
    private Button btnAdd;
    private Button btnMin;
    private Button btnMul;
    private Button btnDiv;
    private TextView result;
    private double firstD;
    private double secondD;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        btnAdd = findViewById(R.id.btnAdd);
        btnMin = findViewById(R.id.btnMin);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        result = findViewById(R.id.result);

        btnAdd.setOnClickListener(this);
        btnMin.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

    }
    private void add(){
        result.setText(String.valueOf(firstD + secondD));
    }
    private void min(){
        result.setText(String.valueOf(firstD - secondD));
    }
    private void mul(){
        result.setText(String.valueOf(firstD * secondD));
    }
    private void div(){
        if (secondD == 0){
            first.setError("Cannot divide by 0");
            return;
        }
        result.setText(String.valueOf(firstD / secondD));
    }
    @Override
    public void onClick(View v) {
        firstD = Double.parseDouble(first.getText().toString());
        secondD = Double.parseDouble(second.getText().toString());
        switch (v.getId()){
            case R.id.btnAdd:
                add();
                break;
            case R.id.btnMin:
                min();
                break;
            case R.id.btnMul:
                mul();
                break;
            case R.id.btnDiv:
                div();
                break;
        }
    }
}
