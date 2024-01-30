package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup button click listeners
        Button btnBMI = findViewById(R.id.btnBMI);
        btnBMI.setOnClickListener(view -> navigateToBMIActivity());

        Button btnSOS = findViewById(R.id.btnSOS);
        btnSOS.setOnClickListener(view -> navigateToSOSActivity());

        Button btnNearbyUtilities = findViewById(R.id.btnNearbyUtilities);
        btnNearbyUtilities.setOnClickListener(view -> navigateToNearbyUtilitiesActivity());
    }

    public void navigateToBMIActivity() {
        Intent intent = new Intent(this, BMIActivity.class);
        startActivity(intent);
    }

    public void navigateToSOSActivity() {
        Intent intent = new Intent(this, SOSActivity.class);
        startActivity(intent);
    }

    public void navigateToNearbyUtilitiesActivity() {
        Intent intent = new Intent(this, LocationSelectionActivity.class);
        startActivity(intent);

    }

}


