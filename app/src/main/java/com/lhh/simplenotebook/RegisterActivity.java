package com.lhh.simplenotebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.LitePalApplication;
import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    private EditText et_account;
    private EditText et_password;
    private EditText et_sure_password;
    private Button btn_sure_rigster;
    private Button btn_back_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LitePalApplication.initialize(this);
        setContentView(R.layout.activity_register);
        et_account = findViewById(R.id.et_reg_account);
        et_password = findViewById(R.id.et_reg_password);
        et_sure_password = findViewById(R.id.et_reg_password2);
        btn_sure_rigster = findViewById(R.id.reg_btn_sureRegister);
        btn_back_login = findViewById(R.id.reg_btn_backLogin);
        btn_sure_rigster.setOnClickListener(new MyRegister());
        btn_back_login.setOnClickListener(new MyRegister());
    }

    private class MyRegister implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.reg_btn_sureRegister:
                    Connector.getDatabase();
                    String accout = et_account.getText().toString();
                    String password = et_password.getText().toString().trim();
                    String surePassword = et_sure_password.getText().toString().trim();
                    if (accout.equals("") || password.equals("")) {
                        Toast.makeText(RegisterActivity.this, "账户密码不能为空", Toast.LENGTH_SHORT).show();
                        return;
                    } else if (password.equals(surePassword)) {
                        Connector.getDatabase();
                        UserInfo userTable1 = new UserInfo();
                        userTable1.setUid(Integer.valueOf(accout));
                        userTable1.setPassword(password);
                        userTable1.save();
                        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        Toast.makeText(RegisterActivity.this, "两次密码不一致", Toast.LENGTH_SHORT).show();
                        return;
                    }
                case R.id.reg_btn_backLogin:
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
            }
        }
    }
}