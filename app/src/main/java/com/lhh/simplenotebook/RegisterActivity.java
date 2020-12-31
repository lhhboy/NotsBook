package com.lhh.simplenotebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    private EditText et_account;
    private EditText et_password;
    private EditText et_sure_password;
    private Button btn_sure_rigster;
    private Button btn_back_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
            switch (v.getId()){
                case R.id.reg_btn_sureRegister:

                case R.id.reg_btn_backLogin:
            }
        }
    }
}