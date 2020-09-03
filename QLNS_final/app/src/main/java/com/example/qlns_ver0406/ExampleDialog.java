package com.example.qlns_ver0406;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ExampleDialog extends AppCompatDialogFragment {
    View view;
    EditText edt_ngay, edt_songay, edt_sogio, edt_tugio, edt_dengio, edt_noidung;
    CheckBox cb_nghi, cb_lamthem, cb_xinduyet;
    Spinner sp_loainghi;
    int t1Hour, t1Minute;
    ArrayAdapter adapter;
    ArrayList<String> arrayList;
    ;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.themmoi_dialog, null);
        builder.setView(view)
                .setTitle("Thêm mới")
                .setNegativeButton("Đóng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                })
                .setPositiveButton("Lưu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        init();

        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item, arrayList);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        adapter.notifyDataSetChanged();

        arrayList.add("Loại nghỉ");
        arrayList.add("Chủ Nhật");
        arrayList.add("Công tác");
        arrayList.add("Công tác vào CN");
        arrayList.add("Cộng tác viên");
        arrayList.add("Nghỉ không lương cả ngày");
        arrayList.add("Nghỉ không lương nửa ngày");
        arrayList.add("Nghỉ không lý do cả ngày");
        arrayList.add("Nghỉ không lý do nửa ngày");
        arrayList.add("Nghỉ bù");
        arrayList.add("Nghỉ lễ");
        arrayList.add("Nghỉ cưới");
        arrayList.add("Nghỉ tang lễ");
        arrayList.add("Ốm");
        arrayList.add("Ốm dài ngày");
        arrayList.add("Nghỉ phép cả ngày");
        arrayList.add("Nghỉ phép nửa ngày");
        arrayList.add("Nghỉ hưởng 50% lương");
        arrayList.add("Nghỉ hưởng 80% lương");
        arrayList.add("Thưởng lương CB");
        sp_loainghi.setAdapter(adapter);

        edt_ngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChonNgay();
            }
        });
        edt_tugio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TuGio();
            }
        });
        edt_dengio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DenGio();
            }
        });
        return builder.create();
    }

    private void TuGio() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), android.R.style.Theme_Holo_Dialog_NoActionBar_MinWidth,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        t1Hour = hourOfDay;
                        t1Minute = minute;

                        String time = t1Hour + ":" + t1Minute;
                        SimpleDateFormat f24Hours = new SimpleDateFormat(
                                "HH:mm"

                        );
                        try {
                            Date date = f24Hours.parse(time);
                            SimpleDateFormat f12Hours = new SimpleDateFormat(
                                    "hh:mm aa"
                            );
                            edt_tugio.setText(f12Hours.format(date));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }, 12, 0, false);
        timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        timePickerDialog.updateTime(t1Hour, t1Minute);
        timePickerDialog.show();
    }
    private void DenGio() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), android.R.style.Theme_Holo_Dialog_NoActionBar_MinWidth,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        t1Hour = hourOfDay;
                        t1Minute = minute;

                        String time = t1Hour + ":" + t1Minute;
                        SimpleDateFormat f24Hours = new SimpleDateFormat(
                                "HH:mm"

                        );
                        try {
                            Date date = f24Hours.parse(time);
                            SimpleDateFormat f12Hours = new SimpleDateFormat(
                                    "hh:mm aa"
                            );
                            edt_dengio.setText(f12Hours.format(date));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }, 12, 0, false);
        timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        timePickerDialog.updateTime(t1Hour, t1Minute);
        timePickerDialog.show();
    }

    private void ChonNgay() {
        final Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                edt_ngay.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, nam, thang, ngay);
        datePickerDialog.show();
    }

    private void init() {
        edt_ngay = view.findViewById(R.id.edt_ngay);
        edt_songay = view.findViewById(R.id.edt_songay);
        edt_sogio = view.findViewById(R.id.edt_sogio);
        edt_tugio = view.findViewById(R.id.edt_tugio);
        edt_dengio = view.findViewById(R.id.edt_dengio);
        edt_noidung = view.findViewById(R.id.edt_noidung);
        cb_nghi = view.findViewById(R.id.cb_nghi);
        cb_lamthem = view.findViewById(R.id.cb_lamthem);
        cb_xinduyet = view.findViewById(R.id.cb_xinduyet);
        sp_loainghi = view.findViewById(R.id.sp_loainghi);
    }
}
