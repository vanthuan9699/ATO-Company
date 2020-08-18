package com.example.qlns_ver0406.Adapter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class HomePagerAdapter extends FragmentPagerAdapter {
    Context context;
    ArrayList<Fragment> data;

    public HomePagerAdapter(FragmentManager fm, Context context, ArrayList<Fragment> data) {
        super(fm);
        this.context = context;
        this.data = data;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "Bảng công";
            case 1:
                return "Chấm công";
            case 2:
                return "Đăng ký thời gian";
            case 3:
                return "Chi tiết lương";
        }
        return super.getPageTitle(position);
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }
}
