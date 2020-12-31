package com.lhh.simplenotebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.tablemanager.Connector;

public class MainActivity extends AppCompatActivity {
    private EditText et_username;
    private EditText et_password;
    private Button btn_login;
    private Button btn_regis;
    private CheckBox checkBox_remenber_pw;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.button_login);
        btn_regis = findViewById(R.id.button_register);
        checkBox = findViewById(R.id.checkBox);
        Button login = findViewById(R.id.button_login);
        Button register = findViewById(R.id.button_register);
        login.setOnClickListener(new MyButton());
        register.setOnClickListener(new MyButton());


    }

    /**
     * 先注册，注册后保存
     */
    public class MyButton implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String username = et_username.getText().toString().trim();
            String password = et_password.getText().toString().trim();
            switch (v.getId()) {
                case R.id.button_register :
                    Connector.getDatabase();
                    Intent intentRegister= new Intent(MainActivity.this, RegisterActivity.class);
                    startActivity(intentRegister);
                case R.id.button_login:
                    if (TextUtils.isEmpty(username) && TextUtils.isEmpty(password)) {
                        Toast.makeText(MainActivity.this, "账户密码不能为空", Toast.LENGTH_LONG);
                    } else {

                        if (checkBox.isChecked()){

                        }
                    }
            }
        }
    }

}