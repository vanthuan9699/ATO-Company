package com.example.qlns_ver0406.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChamCong {

@SerializedName("ID")
@Expose
private Integer iD;
@SerializedName("Ngay")
@Expose
private String ngay;
@SerializedName("Ca")
@Expose
private String ca;
@SerializedName("GioVao")
@Expose
private Object gioVao;
@SerializedName("GioRa")
@Expose
private Object gioRa;
@SerializedName("DiMuon")
@Expose
private Double diMuon;
@SerializedName("VeSom")
@Expose
private Double veSom;
@SerializedName("GioLT")
@Expose
private Double gioLT;
@SerializedName("NgayNghi")
@Expose
private Integer ngayNghi;
@SerializedName("Giocong")
@Expose
private Double giocong;
@SerializedName("DangKyNghi")
@Expose
private Integer dangKyNghi;
@SerializedName("DangKyLamThem")
@Expose
private Object dangKyLamThem;
@SerializedName("LyDo")
@Expose
private String lyDo;
@SerializedName("LoaiPhep")
@Expose
private String loaiPhep;

public Integer getID() {
return iD;
}

public void setID(Integer iD) {
this.iD = iD;
}

public String getNgay() {
return ngay;
}

public void setNgay(String ngay) {
this.ngay = ngay;
}

public String getCa() {
return ca;
}

public void setCa(String ca) {
this.ca = ca;
}

public Object getGioVao() {
return gioVao;
}

public void setGioVao(Object gioVao) {
this.gioVao = gioVao;
}

public Object getGioRa() {
return gioRa;
}

public void setGioRa(Object gioRa) {
this.gioRa = gioRa;
}

public Double getDiMuon() {
return diMuon;
}

public void setDiMuon(Double diMuon) {
this.diMuon = diMuon;
}

public Double getVeSom() {
return veSom;
}

public void setVeSom(Double veSom) {
this.veSom = veSom;
}

public Double getGioLT() {
return gioLT;
}

public void setGioLT(Double gioLT) {
this.gioLT = gioLT;
}

public Integer getNgayNghi() {
return ngayNghi;
}

public void setNgayNghi(Integer ngayNghi) {
this.ngayNghi = ngayNghi;
}

public Double getGiocong() {
return giocong;
}

public void setGiocong(Double giocong) {
this.giocong = giocong;
}

public Integer getDangKyNghi() {
return dangKyNghi;
}

public void setDangKyNghi(Integer dangKyNghi) {
this.dangKyNghi = dangKyNghi;
}

public Object getDangKyLamThem() {
return dangKyLamThem;
}

public void setDangKyLamThem(Object dangKyLamThem) {
this.dangKyLamThem = dangKyLamThem;
}

public String getLyDo() {
return lyDo;
}

public void setLyDo(String lyDo) {
this.lyDo = lyDo;
}

public String getLoaiPhep() {
return loaiPhep;
}

public void setLoaiPhep(String loaiPhep) {
this.loaiPhep = loaiPhep;
}

}