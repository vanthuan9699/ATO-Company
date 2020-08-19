package com.example.qlns_ver0406.Fragment.DanhMuc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.qlns_ver0406.Adapter.HomePagerAdapter;
import com.example.qlns_ver0406.Fragment.Profile.BangCongFragment;
import com.example.qlns_ver0406.Fragment.Profile.CTLuongFragment;
import com.example.qlns_ver0406.Fragment.Profile.ChamCongFragment;
import com.example.qlns_ver0406.Fragment.Profile.DKyThoiGianFragment;
import com.example.qlns_ver0406.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class DanhMucFragment extends Fragment {
    View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_danhmuc, container, false);

        return view;
    }


}
