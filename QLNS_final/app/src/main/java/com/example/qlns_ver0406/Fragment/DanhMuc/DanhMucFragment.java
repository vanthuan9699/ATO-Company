package com.example.qlns_ver0406.Fragment.DanhMuc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.qlns_ver0406.Adapter.DanhMucPagerAdapter;
import com.example.qlns_ver0406.Adapter.ProfilePagerAdapter;
import com.example.qlns_ver0406.Fragment.Profile.BangCongFragment;
import com.example.qlns_ver0406.Fragment.Profile.CTLuongFragment;
import com.example.qlns_ver0406.Fragment.Profile.ChamCongFragment;
import com.example.qlns_ver0406.Fragment.Profile.DKyThoiGianFragment;
import com.example.qlns_ver0406.R;
import com.google.android.material.tabs.TabLayout;


public class DanhMucFragment extends Fragment {
    View view;
    ViewPager viewPager;
    TabLayout tabLayout;
    public DanhMucFragment(){}
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_danhmuc, container, false);
        viewPager = view.findViewById(R.id.viewPager1);
        tabLayout = view.findViewById(R.id.tabLayout1);
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
        DanhMucPagerAdapter adapter = new DanhMucPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new BoPhanFragment(), "Bộ Phận");
        adapter.addFragment(new ChucVuFragment(), "Chức vụ");
        adapter.addFragment(new QuanHeFragment(), "Quan hệ");
        viewPager.setAdapter(adapter);
    }
}