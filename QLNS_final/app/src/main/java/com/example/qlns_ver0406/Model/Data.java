package com.example.qlns_ver0406.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

@SerializedName("TimeLog")
@Expose
private List<TimeLog> timeLog = null;
@SerializedName("ChamCong")
@Expose
private List<ChamCong> chamCong = null;
@SerializedName("DangKyThoiGian")
@Expose
private List<Object> dangKyThoiGian = null;
@SerializedName("ChamCongNV")
@Expose
private List<Object> chamCongNV = null;

public List<TimeLog> getTimeLog() {
return timeLog;
}

public void setTimeLog(List<TimeLog> timeLog) {
this.timeLog = timeLog;
}

public List<ChamCong> getChamCong() {
return chamCong;
}

public void setChamCong(List<ChamCong> chamCong) {
this.chamCong = chamCong;
}

public List<Object> getDangKyThoiGian() {
return dangKyThoiGian;
}

public void setDangKyThoiGian(List<Object> dangKyThoiGian) {
this.dangKyThoiGian = dangKyThoiGian;
}

public List<Object> getChamCongNV() {
return chamCongNV;
}

public void setChamCongNV(List<Object> chamCongNV) {
this.chamCongNV = chamCongNV;
}

}