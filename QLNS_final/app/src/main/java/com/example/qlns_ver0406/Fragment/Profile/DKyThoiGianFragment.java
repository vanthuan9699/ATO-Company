package com.example.qlns_ver0406.Fragment.Profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.qlns_ver0406.ExampleDialog;
import com.example.qlns_ver0406.R;

public class DKyThoiGianFragment extends Fragment {
    View view;
    TextView tv_tungay, tv_denngay, tv_lamthem, tv_sogio, tv_nghi, tv_loainghi, tv_lydo, tv_lichlamviec;
    Button btnThemmoi;
    public DKyThoiGianFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_d_ky_thoi_gian, container, false);
        init();
        loadThemmoi();
        return view;
    }

    private void loadThemmoi() {
        btnThemmoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    private void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getFragmentManager(), "example dialog");
    }

    private void init() {
        tv_tungay = view.findViewById(R.id.tv_tungay);
        tv_denngay = view.findViewById(R.id.tv_denngay);
        tv_lamthem = view.findViewById(R.id.tv_lamthem);
        tv_sogio = view.findViewById(R.id.tv_sogio);
        tv_nghi = view.findViewById(R.id.tv_nghi);
        tv_loainghi = view.findViewById(R.id.tv_loainghi);
        tv_lydo = view.findViewById(R.id.tv_lydo);
        tv_lichlamviec = view.findViewById(R.id.tv_lichlamviec);
        btnThemmoi = view.findViewById(R.id.btn_themmoi);
    }
}