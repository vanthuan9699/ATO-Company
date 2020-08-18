package com.example.qlns_ver0406.Config;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppInfo {
    public static String formatDate (String date, String initDateFormat, String endDateFormat) throws ParseException {
        @SuppressLint("SimpleDateFormat") Date initDate = new SimpleDateFormat(initDateFormat).parse(date);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat(endDateFormat);
        assert initDate != null;
        return formatter.format(initDate);
    }
}
