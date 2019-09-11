package com.example.festival3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    // 4개의 메뉴에 들어갈 Fragment들
    private FragmentHome fragmentHome = new FragmentHome();
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        BottomNavigationHelper.disableShiftMode(bottomNavigationView);
        FragmentManager fragmentManager=getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, fragmentHome).commitAllowingStateLoss();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.navigation_menu1:
                        fragment = new FragmentHome();
                        transaction.replace(R.id.frame_layout, fragment);
                        transaction.commit();
                        break;
                    case R.id.navigation_menu2: {
                        fragment = new FragmentEvent();
                        transaction.replace(R.id.frame_layout, fragment);
                        transaction.commit();
                        break;
                    }
                    case R.id.navigation_menu3: {
                        fragment = new FragmentAlarm();
                        transaction.replace(R.id.frame_layout, fragment);
                        transaction.commit();
                        break;
                    }
                    case R.id.navigation_menu4: {
                        fragment = new FragmentMypage();
                        transaction.replace(R.id.frame_layout, fragment);
                        transaction.commit();
                    }
                }

                return true;
            }
        });


    }


}
