package com.example.qlns_ver0406.Fragment.Profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qlns_ver0406.Adapter.BangCongAdapter;
import com.example.qlns_ver0406.Model.ChamCong;
import com.example.qlns_ver0406.Model.Message;
import com.example.qlns_ver0406.Network.MessageAPI;
import com.example.qlns_ver0406.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BangCongFragment extends Fragment {
    View view;
    RecyclerView rvBangCong;
    String RREF_NAME = "BanKiem";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bangcong, container, false);
        init();
        conFig();
        return view;
    }

    private void init() {
        rvBangCong = view.findViewById(R.id.rv_bangcong);
    }

    private void conFig(){
        SharedPreferences shared = this.getActivity().getSharedPreferences(RREF_NAME, Context.MODE_PRIVATE);
        String ac = shared.getString("access_key", "");
        MessageAPI.getService().getData(ac).enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message message = response.body();
                if (message != null && message.getSuccess()){
                    initBangCong(message.getData().getChamCong());
                }
            }
            @Override
            public void onFailure(Call<Message> call, Throwable t) {
            }
        });
    }

    private void initBangCong(List<ChamCong> chamCong) {
        BangCongAdapter adapter = new BangCongAdapter(this, chamCong);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvBangCong.setLayoutManager(layoutManager);
        rvBangCong.setAdapter(adapter);
    }

}
