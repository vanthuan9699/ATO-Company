package com.example.qlns_ver0406.Fragment.Profile;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qlns_ver0406.Adapter.ProfilePagerAdapter;
import com.example.qlns_ver0406.Fragment.Profile.BangCongFragment;
import com.example.qlns_ver0406.Fragment.Profile.CTLuongFragment;
import com.example.qlns_ver0406.Fragment.Profile.ChamCongFragment;
import com.example.qlns_ver0406.Fragment.Profile.DKyThoiGianFragment;
import com.example.qlns_ver0406.R;
import com.google.android.material.tabs.TabLayout;


public class ProfileFragment extends Fragment {
    View view;
    ViewPager viewPager;
    TabLayout tabLayout;
    public ProfileFragment(){}
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);
        return view;
    }
    //call

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    private void setUpViewPager(ViewPager viewPager) {
        ProfilePagerAdapter adapter = new ProfilePagerAdapter(getChildFragmentManager());
        adapter.addFragment(new BangCongFragment(), "Bảng Công");
        adapter.addFragment(new ChamCongFragment(), "Chấm Công");
        adapter.addFragment(new DKyThoiGianFragment(), "Đăng Ký Thời Gian");
        adapter.addFragment(new CTLuongFragment(), "Chi Tiết Lương");
        viewPager.setAdapter(adapter);
    }
}