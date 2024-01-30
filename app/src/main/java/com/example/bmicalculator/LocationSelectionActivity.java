package com.example.bmicalculator;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LocationSelectionActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnLocation1, btnLocation2, btnLocation3, btnLocation4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_selection);

        // Initialize the buttons
        btnLocation1 = findViewById(R.id.button_lusaka);
        btnLocation2 = findViewById(R.id.button_new_york);
        btnLocation3 = findViewById(R.id.button_sydney);
        btnLocation4 = findViewById(R.id.button_tokyo);

        // Set onClickListeners for the buttons
        btnLocation1.setOnClickListener(this);
        btnLocation2.setOnClickListener(this);
        btnLocation3.setOnClickListener(this);
        btnLocation4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_lusaka:
                navigateToLocation(-15.38229952014083, 28.262526827933335, " FAST TRACK PHARMACY LTD");
                break;
            case R.id.button_new_york:
                navigateToLocation(-15.381548288484362, 28.399196472722917, " Back Bay Gym");
                break;
            case R.id.button_sydney:
                navigateToLocation(-15.393420894014795, 28.41123422669937, "Nawila Medical Center");
                break;
            case R.id.button_tokyo:
                navigateToLocation(-15.388406758084106, 28.39379411639989, "Fair Care Pharmacy");
                break;
        }
    }

    private void navigateToLocation(double lat, double lng, String title) {
        Intent intent = new Intent(LocationSelectionActivity.this, MapsActivity.class);
        intent.putExtra("latitude", lat);
        intent.putExtra("longitude", lng);
        intent.putExtra("title", title);
        startActivity(intent);
        finish();


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
