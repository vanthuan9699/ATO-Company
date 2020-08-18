package com.example.qlns_ver0406.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimeLog {

@SerializedName("ID")
@Expose
private Integer iD;
@SerializedName("MayCham")
@Expose
private String mayCham;
@SerializedName("MaCham")
@Expose
private Integer maCham;
@SerializedName("PhutInt")
@Expose
private Integer phutInt;
@SerializedName("NgayInt")
@Expose
private Integer ngayInt;
@SerializedName("NgayCham")
@Expose
private String ngayCham;
@SerializedName("VaoRa")
@Expose
private Integer vaoRa;
@SerializedName("LoaiCham")
@Expose
private Integer loaiCham;
@SerializedName("CongViec")
@Expose
private Integer congViec;

public Integer getID() {
return iD;
}

public void setID(Integer iD) {
this.iD = iD;
}

public String getMayCham() {
return mayCham;
}

public void setMayCham(String mayCham) {
this.mayCham = mayCham;
}

public Integer getMaCham() {
return maCham;
}

public void setMaCham(Integer maCham) {
this.maCham = maCham;
}

public Integer getPhutInt() {
return phutInt;
}

public void setPhutInt(Integer phutInt) {
this.phutInt = phutInt;
}

public Integer getNgayInt() {
return ngayInt;
}

public void setNgayInt(Integer ngayInt) {
this.ngayInt = ngayInt;
}

public String getNgayCham() {
return ngayCham;
}

public void setNgayCham(String ngayCham) {
this.ngayCham = ngayCham;
}

public Integer getVaoRa() {
return vaoRa;
}

public void setVaoRa(Integer vaoRa) {
this.vaoRa = vaoRa;
}

public Integer getLoaiCham() {
return loaiCham;
}

public void setLoaiCham(Integer loaiCham) {
this.loaiCham = loaiCham;
}

public Integer getCongViec() {
return congViec;
}

public void setCongViec(Integer congViec) {
this.congViec = congViec;
}

}
