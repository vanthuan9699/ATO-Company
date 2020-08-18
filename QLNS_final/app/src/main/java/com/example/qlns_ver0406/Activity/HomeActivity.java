package com.example.qlns_ver0406.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qlns_ver0406.Model.Message;
import com.example.qlns_ver0406.Network.MessageAPI;
import com.example.qlns_ver0406.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    RecyclerView rvTimeLog, rvChamCong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        init();
        getData();
    }
    private void getData() {
        String accessKey = getIntent().getStringExtra("access_key");
        MessageAPI.getService().getData(accessKey).enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message message = response.body();
                if (message != null && message.getSuccess()){
//                    initTimeLog(message.getData().getTimeLog());
//                    initChamCong(message.getData().getChamCong());
                }
            }
            @Override
            public void onFailure(Call<Message> call, Throwable t) {
            }
        });
    }
//    private void initChamCong(List<ChamCong> chamCong) {
//        BangCongAdapter adapter = new BangCongAdapter(this, chamCong);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        rvChamCong.setLayoutManager(layoutManager);
//        rvChamCong.setAdapter(adapter);
//    }
//    private void initTimeLog(List<TimeLog> timeLog) {
//        TimeLogAdapter adapter = new TimeLogAdapter(this, timeLog);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        rvTimeLog.setLayoutManager(layoutManager);
//        rvTimeLog.setAdapter(adapter);
//
//    }

    private void init() {
        rvTimeLog = findViewById(R.id.rv_timelog);
        rvChamCong = findViewById(R.id.rv_chamcong);
    }

}