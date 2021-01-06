package com.lhh.simplenotebook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Toast;

import org.litepal.LitePalApplication;
import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText et_username;
    private EditText et_password;
    private Button btn_login;
    private Button btn_regis;
    private CheckBox checkBox_remenber_pw;
    private CheckBox checkBox;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LitePalApplication.initialize(this);
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
        sharedPreferences = getSharedPreferences("rememberPassword", MODE_PRIVATE);
        boolean isRemember = sharedPreferences.getBoolean("isRemember", false);
        if (isRemember) {
            String userAccount = sharedPreferences.getString("userAcc","");
            String userPassword = sharedPreferences.getString("userPass","");
            et_username.setText(userAccount);
            et_password.setText(userPassword);
            checkBox.setChecked(true);

        }

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

                case R.id.button_login:
                    if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                        Toast.makeText(MainActivity.this, "账户密码不能为空", Toast.LENGTH_LONG).show();
                    } else {
                        List<UserInfo> userInfoTable = DataSupport.findAll(UserInfo.class);
                        for (UserInfo userInfo : userInfoTable) {
                            Log.e("my", userInfo.getPassword() + " " + userInfo.getUid());
                            Log.e("my", password + " " + username);
                            if ((userInfo.getUid().equals(Integer.valueOf(username)) && userInfo.getPassword().equals(password))) {
                                Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                if (checkBox.isChecked()){
                                   editor.putBoolean("isRemember",true);
                                   editor.putString("userAcc",username);
                                   editor.putString("userPass",password);
                                }else {
                                    editor.clear();
                                }
                                editor.commit();
                                Intent intent = new Intent(MainActivity.this,NoteContentActivity.class);
                                startActivity(intent);
                                return;
                            }
                        }
                        Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_LONG).show();
                        return;
                    }
                case R.id.button_register:
                    Intent intentRegister = new Intent(MainActivity.this, RegisterActivity.class);
                    startActivity(intentRegister);
            }
        }
    }
}
