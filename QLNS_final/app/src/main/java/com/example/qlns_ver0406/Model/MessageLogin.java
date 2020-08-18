package com.example.qlns_ver0406.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MessageLogin {

@SerializedName("Success")
@Expose
private Boolean success;
@SerializedName("Data")
@Expose
private DataLogin data;
@SerializedName("Msg")
@Expose
private Object msg;

public Boolean getSuccess() {
return success;
}

public void setSuccess(Boolean success) {
this.success = success;
}

public DataLogin getData() {
return data;
}

public void setData(DataLogin data) {
this.data = data;
}

public Object getMsg() {
return msg;
}

public void setMsg(Object msg) {
this.msg = msg;
}

}