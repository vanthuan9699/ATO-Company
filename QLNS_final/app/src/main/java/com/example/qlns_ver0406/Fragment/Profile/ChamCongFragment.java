package com.example.qlns_ver0406.Fragment.Profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.qlns_ver0406.Adapter.TimeLogAdapter;
import com.example.qlns_ver0406.Model.Message;
import com.example.qlns_ver0406.Model.TimeLog;
import com.example.qlns_ver0406.Network.MessageAPI;
import com.example.qlns_ver0406.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChamCongFragment extends Fragment {
    View view;
    RecyclerView rvTimeLog;
    String RREF_NAME = "BanKiem";
    SwipeRefreshLayout refreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chamcong, container, false);
        init();
        conFig();
        refresh();
        return view;
    }

    private void refresh() {
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                conFig();
                refreshLayout.setRefreshing(false);
            }
        });
    }

    private void conFig() {
        SharedPreferences share = this.getActivity().getSharedPreferences(RREF_NAME, Context.MODE_PRIVATE);
        String ac = share.getString("access_key", "");
        MessageAPI.getService().getData(ac).enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message message = response.body();
                if (message != null && message.getSuccess()){
                    initTimeLog(message.getData().getTimeLog());
                }
                Log.d("xxxxx", "onResponse: " + response.body().getSuccess());
            }
            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Log.d("xxxxx", "onFailure: " + t);
            }
        });
    }
    private void initTimeLog(List<TimeLog> timeLog) {
        TimeLogAdapter adapter = new TimeLogAdapter(this, timeLog);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        adapter.notifyDataSetChanged();
        rvTimeLog.setLayoutManager(layoutManager);
        rvTimeLog.setAdapter(adapter);
    }
    private void init() {
        rvTimeLog = view.findViewById(R.id.rv_timelogcanhan);
        refreshLayout = view.findViewById(R.id.refresh_chamcong);
    }
}
