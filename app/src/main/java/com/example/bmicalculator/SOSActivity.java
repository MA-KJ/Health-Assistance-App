package com.example.bmicalculator;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class SOSActivity extends AppCompatActivity {

    private LocationManager manager;
    private GPSReceiver receiver;
    double latitude = 0;
    double longitude = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);
        myButtonListenerMethod();
        GPSReceiver receiver = new GPSReceiver();
        LocationManager manager = (LocationManager)
                this.getSystemService(Context.LOCATION_SERVICE);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            return;
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000L, 1.0F, receiver);
    }
    public void myButtonListenerMethod() {
        Button button = findViewById(R.id.sendSOS);
        button.setOnClickListener(v -> {
            SmsManager sms = SmsManager.getDefault();
            String phoneNumber = "+260975745806";
            String messageBody = "Please take me from longitude: " + longitude + " and latitude: " + latitude;
            try {
                sms.sendTextMessage(phoneNumber,
                        null, messageBody ,null, null);

                Toast.makeText(getApplicationContext(), "S.O.S. message sent!", Toast.LENGTH_LONG).show();
            } catch (Exception e) {

                Toast.makeText(getApplicationContext(), "Message sending failed!!!", Toast.LENGTH_LONG).show();
            }
        });
    }
    public class GPSReceiver implements LocationListener {
        @Override
        public void onLocationChanged(Location location)
        {

            if (location != null) {
                latitude = location.getLatitude();
                longitude = location.getLongitude();
                Toast.makeText(getApplicationContext(), "READY TO SEND!!!", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "NOT READY YET...", Toast.LENGTH_LONG).show();
            }
        }
        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {
        }
        @Override
        public void onProviderEnabled(String s) {
            Toast.makeText(getApplicationContext(), "GPS Enabled!", Toast.LENGTH_LONG).show();
        }
        @Override
        public void onProviderDisabled(String s) {
            Toast.makeText(getApplicationContext(), "Please enable GPS!", Toast.LENGTH_LONG).show();


        }
        View decorView =getWindow().getDecorView(); {
        decorView.setSystemUiVisibility(
        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN);
        }
    }
}
