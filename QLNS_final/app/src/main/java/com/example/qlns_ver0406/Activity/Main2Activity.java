package com.example.qlns_ver0406.Activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.qlns_ver0406.Adapter.HomePagerAdapter;
import com.example.qlns_ver0406.Fragment.Profile.BangCongFragment;
import com.example.qlns_ver0406.Fragment.Profile.CTLuongFragment;
import com.example.qlns_ver0406.Fragment.Profile.ChamCongFragment;
import com.example.qlns_ver0406.Fragment.Profile.DKyThoiGianFragment;
import com.example.qlns_ver0406.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    TabLayout tlHome;
    ViewPager vpHome;
    ArrayList<Fragment> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        //
        init();
        configVP();
    }

    private void configVP() {
        BangCongFragment bangCongFragment = new BangCongFragment();
        ChamCongFragment chamCongFragment = new ChamCongFragment();
        CTLuongFragment ctLuongFragment = new CTLuongFragment();
        DKyThoiGianFragment dKyThoiGianFragment = new DKyThoiGianFragment();
        data.add(bangCongFragment);
        data.add(chamCongFragment);
        data.add(ctLuongFragment);
        data.add(dKyThoiGianFragment);
        HomePagerAdapter adapter = new HomePagerAdapter(getSupportFragmentManager(), this, data);
        vpHome.setAdapter(adapter);
        tlHome.setupWithViewPager(vpHome);


    }

    private void init() {
        tlHome = findViewById(R.id.tb_home);
        vpHome = findViewById(R.id.vp_home);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id){
            case R.id.nav_profile:
            case R.id.nav_dm:
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}