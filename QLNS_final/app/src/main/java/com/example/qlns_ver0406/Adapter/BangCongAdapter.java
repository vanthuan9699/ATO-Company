package com.example.qlns_ver0406.Adapter;
import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qlns_ver0406.Config.AppInfo;
import com.example.qlns_ver0406.Fragment.Profile.BangCongFragment;
import com.example.qlns_ver0406.Model.ChamCong;
import com.example.qlns_ver0406.R;

import java.text.ParseException;
import java.util.List;
public class BangCongAdapter extends RecyclerView.Adapter<BangCongAdapter.ViewHolder> {
    List<ChamCong> chamCongs;
    public BangCongAdapter(BangCongFragment context, List<ChamCong> timeLogs) {
        this.chamCongs = timeLogs;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChamCong item = chamCongs.get(position);
        setDataView(item, holder.getView());
    }
    @Override
    public int getItemCount() {
        return chamCongs.size();
    }
    @SuppressLint("SetTextI18n")
    private void setDataView(ChamCong item, View view) {
        TextView tvNgayCham = view.findViewById(R.id.lblNgayCham);
        try {
            tvNgayCham.setText(AppInfo.formatDate(item.getNgay(), "yyyy-MM-dd HH:mm:ss", "dd/MM/yyyy"));
        } catch (ParseException e) {
            tvNgayCham.setText("--");
            e.printStackTrace();
        }
//        tvNgayCham.setText(AppInfo.formatDate(item.getNgay(), "yyyy-MM-dd HH:mm:ss", "dd/MM/yyyy"));
//        tvNgayCham.setText(item.getNgay());
        TextView tvCa = view.findViewById(R.id.lblCa);
        tvCa.setText("Ca : " + item.getCa());
        TextView tvGioVao = view.findViewById(R.id.lblGioVao);
        try {
            tvGioVao.setText("Giờ vào : " + AppInfo.formatDate(item.getGioVao() + "", "yyyy-MM-dd HH:mm:ss", "HH:mm:ss"));
        } catch (ParseException e) {
            tvGioVao.setText("--");
            e.printStackTrace();
        }
//        tvGioVao.setText("Giờ vào : " + AppInfo.formatDate(item.getGioVao() + "", "yyyy-MM-dd HH:mm:ss", "HH:mm:ss"));
//        tvGioVao.setText("Giờ Vào " +  item.getGioVao());
        TextView tvGioRa = view.findViewById(R.id.lblGioRa);
        try {
            tvGioRa.setText("Giờ ra : " + AppInfo.formatDate(item.getGioRa() + "", "yyyy-MM-dd HH:mm:ss", "HH:mm:ss"));
        } catch (ParseException e) {
            tvGioRa.setText("--");
            e.printStackTrace();
        }
//        tvGioRa.setText("Giờ Ra" + item.getGioRa());
        TextView tvDiMuon = view.findViewById(R.id.lblDiMuon);
        tvDiMuon.setText("Đi muộn : " + item.getDiMuon() + "");

        TextView tvVeSom = view.findViewById(R.id.lblVeSom);
        tvVeSom.setText("Về sớm : " + item.getVeSom() + "");

        TextView tvLoaiPhep = view.findViewById(R.id.lblLoaiphep);
        tvLoaiPhep.setText("Loại phép : " + item.getLoaiPhep());
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        View view;

        ViewHolder(View view) {
            super(view);
            this.view = view;
        }
        View getView() {
            return view;
        }
    }
}