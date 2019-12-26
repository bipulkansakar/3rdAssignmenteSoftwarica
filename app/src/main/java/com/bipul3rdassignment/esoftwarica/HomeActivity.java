package com.bipul3rdassignment.esoftwarica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.bipul3rdassignment.esoftwarica.AboutUs.AboutUsFragment;
import com.bipul3rdassignment.esoftwarica.AddStudent.AddStudentFragment;
import com.bipul3rdassignment.esoftwarica.Home.HomeFragment;
import com.bipul3rdassignment.esoftwarica.Model.Students;
import com.example.esoftwarica.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    public static List<Students> studentsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListner);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();


        studentsList = new ArrayList<>();
        studentsList.add(new Students("Bipul Kansakar","Bagbazar","Male",26,R.drawable.boy));
        studentsList.add(new Students("Maria Sharapova","Kathmandu","Female",26,R.drawable.girl));



    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectFragment = null;
                    switch (item.getItemId()){

                        case R.id.nav_home:
                            selectFragment = new HomeFragment();
                            break;
                        case R.id.nav_add:
                            selectFragment = new AddStudentFragment();
                            break;
                        case R.id.nav_about:
                            selectFragment = new AboutUsFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectFragment).commit();
                    return true;
                }
            };
}
