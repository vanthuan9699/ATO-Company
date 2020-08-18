package com.example.qlns_ver0406.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlns_ver0406.Model.MessageLogin;
import com.example.qlns_ver0406.Network.MessageAPI;
import com.example.qlns_ver0406.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Button btnLogin;
    private String username;
    private String password;
    private static ProgressDialog mProgressDialog;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String USERNAME_KEY = "user";
    String PASSWORD_KEY = "pass";
    CheckBox cbRemember;
    String RREF_NAME = "BanKiem";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = edtUsername.getText().toString().trim();
                password = edtPassword.getText().toString().trim();
                MessageAPI.getService().login(username, password).enqueue(new Callback<MessageLogin>() {
                    @Override
                    public void onResponse(Call<MessageLogin> call, Response<MessageLogin> response) {
                        if (response.isSuccessful()) {
                            MessageLogin messageLogin = response.body();
                            if (messageLogin.getSuccess() == true) {
//                                Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                                String accessKey = messageLogin.getData().getAccessKey();
                                Bundle bundle = new Bundle();
                                bundle.putString("access_key", accessKey);
                                SharedPreferences share = getSharedPreferences(RREF_NAME, Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor1 = share.edit();
                                editor1.putString("access_key", accessKey);
                                editor1.apply();
                                intent.putExtras(bundle);
                                startActivity(intent);
                                finish();
                                Progress();
                                if (cbRemember.isChecked()){
                                    editor = sharedPreferences.edit();
                                    editor.putString(USERNAME_KEY, edtUsername.getText().toString());
                                    editor.putString(PASSWORD_KEY, edtPassword.getText().toString());
                                    editor.putBoolean("checked", true);
//                                    editor.putString("access_key", accessKey);
                                    editor.commit();
                                }else {
                                    editor = sharedPreferences.edit();
                                    editor.remove(USERNAME_KEY);
                                    editor.remove(PASSWORD_KEY);
                                    editor.remove("checked");
                                    editor.commit();
                                }
                                Log.d("xxxxx", "onResponse: " + response.body().getSuccess());
                            }
                        }
                    }
                    @Override
                    public void onFailure(Call<MessageLogin> call, Throwable t) {
                        Log.d("xxxxx", "onFailure: " + t);
                    }
                });
            }
        });
        sharedPreferences = getSharedPreferences("loginsave", MODE_PRIVATE);
        edtUsername.setText(sharedPreferences.getString(USERNAME_KEY, ""));
        edtPassword.setText(sharedPreferences.getString(PASSWORD_KEY, ""));
        cbRemember.setChecked(sharedPreferences.getBoolean("checked", false));
    }

    private void Progress() {
        mProgressDialog = new ProgressDialog(MainActivity.this);

        mProgressDialog.show();

        mProgressDialog.setContentView(R.layout.progress_dialog);

        mProgressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }

    @Override
    public void onBackPressed() {
        mProgressDialog.dismiss();
    }

    private void init() {
        edtUsername = findViewById(R.id.username);
        edtPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btn_login);
        cbRemember = findViewById(R.id.cb_remember);
    }
}
