package com.example.bottomnavigationviewwithfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    BarFragment barFragment;
    PieFragment pieFragment;
    RadarFragment radarFragment;
    LineFragment lineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, barFragment).commit();  //start fragment

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bar_chart:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, barFragment).commit();
                        return true;
                    case R.id.pie_chart:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, pieFragment).commit();
                        return true;
                    case R.id.radar_chart:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, radarFragment).commit();
                        return true;
                    case R.id.line_chart:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, lineFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }

    private void initUi() {
        bottomNavigationView = findViewById(R.id.bottom_nav);
        barFragment = new BarFragment();
        pieFragment = new PieFragment();
        radarFragment = new RadarFragment();
        lineFragment = new LineFragment();
    }
    // for test
}