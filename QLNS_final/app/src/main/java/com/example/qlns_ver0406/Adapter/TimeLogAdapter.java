package com.example.qlns_ver0406.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qlns_ver0406.Config.AppInfo;
import com.example.qlns_ver0406.Fragment.Profile.ChamCongFragment;
import com.example.qlns_ver0406.Model.TimeLog;
import com.example.qlns_ver0406.R;

import java.text.ParseException;
import java.util.List;

public class TimeLogAdapter extends RecyclerView.Adapter<TimeLogAdapter.ViewHolder> {
    List<TimeLog> timeLogs;

    public TimeLogAdapter(ChamCongFragment context, List<TimeLog> timeLogs){
        this.timeLogs = timeLogs;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_time_log, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TimeLog item = timeLogs.get(position);
        setDataView(item, holder.getView());
    }
    @Override
    public int getItemCount() {
        return timeLogs.size();
    }

    private void setDataView(TimeLog item, View view){
        TextView tvMayCham = view.findViewById(R.id.tv_maychamcong);
        tvMayCham.setText( item.getMayCham());

        TextView tvMa = view.findViewById(R.id.tv_machamcongnv);
        tvMa.setText(item.getMaCham()+"");

        TextView tvNgayCham = view.findViewById(R.id.tv_thoigiancham);
        tvNgayCham.setText(item.getNgayCham());
        try {
            tvNgayCham.setText(AppInfo.formatDate(item.getNgayCham(), "yyyy-MM-dd HH:mm:ss", "dd/MM/yyyy HH:mm:ss"));
        } catch (ParseException e) {
            tvNgayCham.setText("--");
            e.printStackTrace();
        }

    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        View view;
        ViewHolder(View view){
            super(view);
            this.view = view;
        }
        View getView(){
            return view;
        }
    }
}