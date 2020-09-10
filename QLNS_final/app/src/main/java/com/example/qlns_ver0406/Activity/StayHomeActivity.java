package com.example.qlns_ver0406.Activity;

import android.app.AlarmManager;
import android.app.FragmentManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.qlns_ver0406.Fragment.Alarm.AlarmFragment;
import com.example.qlns_ver0406.Fragment.BaoHiem.BaoHiemFragment;
import com.example.qlns_ver0406.Fragment.ChamCong.ChamCongFragment;
import com.example.qlns_ver0406.Fragment.DanhMuc.BoPhanFragment;
import com.example.qlns_ver0406.Fragment.DanhMuc.DanhMucFragment;
import com.example.qlns_ver0406.Fragment.NhanSu.NhanSuFragment;
import com.example.qlns_ver0406.Fragment.Profile.ProfileFragment;
import com.example.qlns_ver0406.Fragment.TinhLuong.TinhLuongFragment;
import com.example.qlns_ver0406.Fragment.TuyenDung.TuyenDungFragment;
import com.example.qlns_ver0406.R;
import com.example.qlns_ver0406.ReminderBroadcast;
import com.google.android.material.navigation.NavigationView;

public class StayHomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stay_home);
        init();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ProfileFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_canhan);
        }

    }

    private void init() {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_canhan:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfileFragment()).commit();
                break;
            case R.id.nav_danhmuc:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DanhMucFragment()).commit();
                break;
            case R.id.nav_baohiem:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new BaoHiemFragment()).commit();
                break;
            case R.id.nav_tinhluong:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TinhLuongFragment()).commit();
                break;
            case R.id.nav_chamcong:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ChamCongFragment()).commit();
                break;
            case R.id.nav_nhansu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new NhanSuFragment()).commit();
                break;
            case R.id.nav_tuyendung:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TuyenDungFragment()).commit();
                break;
            case R.id.nav_alarm:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AlarmFragment()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}