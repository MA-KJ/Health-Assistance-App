package com.example.bmicalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;


public class BMIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        myButtonListenerMethod();
    }

    @SuppressLint("SetTextI18n")
    public void myButtonListenerMethod() {
        Button button = findViewById(R.id.btn);
        button.setOnClickListener((View v) -> {
            final EditText heightText = findViewById(R.id.height);
            String heightStr = heightText.getText().toString();
            double height = Double.parseDouble(heightStr);
            double heightM = height/100;
            final EditText weightText = findViewById(R.id.weight);
            String weightStr = weightText.getText().toString();
            double weight = Double.parseDouble(weightStr);
            double BMI = (weight) / (heightM * heightM);
            DecimalFormat df = new DecimalFormat("#.#");
            double BMI_trimmed = Double.parseDouble(df.format(BMI));
            final TextView BMIResult = findViewById(R.id.result);
            BMIResult.setText(Double.toString(BMI_trimmed));
            String BMI_Cat;
            if (BMI < 15){
                BMI_Cat = "Very severely underweight";
            }
            else if (BMI >= 15 && BMI < 16){
                BMI_Cat = "Severely underweight";
            }
            else if (BMI >=16 && BMI < 18.5){
                BMI_Cat = "Underweight";
            }
            else if (BMI >=18.5 && BMI < 25){
                BMI_Cat = "Normal";
            }
            else if (BMI >= 25 && BMI < 30){
                BMI_Cat = "Overweight";
            }
            else if (BMI>=30 && BMI < 35 ){
                BMI_Cat = "Obese Class 1 - Moderately Obese";
            }
            else if (BMI>= 35 && BMI < 40){
                BMI_Cat = "Obese Class 2 - Severely Obese";
            }
            else {
                BMI_Cat = "Obese Class 3 - Very Severely Obese";

            }
            final TextView BMICategory = findViewById(R.id.bmiCat);
            BMICategory.setText(BMI_Cat);
        });


        View decorView =getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }
}


