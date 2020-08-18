package com.example.qlns_ver0406.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataLogin {
@SerializedName("AccessKey")
@Expose
private String accessKey;
@SerializedName("RefreshKey")
@Expose
private String refreshKey;
@SerializedName("AccessKeyExpireTime")
@Expose
private Integer accessKeyExpireTime;
@SerializedName("RefreshKeyExpireTime")
@Expose
private Integer refreshKeyExpireTime;

public String getAccessKey() {
return accessKey;
}

public void setAccessKey(String accessKey) {
this.accessKey = accessKey;
}

public String getRefreshKey() {
return refreshKey;
}

public void setRefreshKey(String refreshKey) {
this.refreshKey = refreshKey;
}

public Integer getAccessKeyExpireTime() {
return accessKeyExpireTime;
}

public void setAccessKeyExpireTime(Integer accessKeyExpireTime) {
this.accessKeyExpireTime = accessKeyExpireTime;
}
public Integer getRefreshKeyExpireTime() {
return refreshKeyExpireTime;
}
public void setRefreshKeyExpireTime(Integer refreshKeyExpireTime) {
this.refreshKeyExpireTime = refreshKeyExpireTime;
}

}