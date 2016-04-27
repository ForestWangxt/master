package com.kpi.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.storm.kpi.R;

public class LoginActivity extends AppCompatActivity {

    private TextView textView;
    private EditText username;
    private EditText password;
    private String user;
    private String paw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
        }
        init();
        login();

    }

    private void login() {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = username.getText().toString().trim();
                paw = password.getText().toString().trim();
                if (!TextUtils.isEmpty(user) && !TextUtils.isEmpty(paw)) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                } else {
                    Toast.makeText(LoginActivity.this,"请输入用户名和密码", 0).show();
                }
            }
        });
    }

    private void init() {
        textView = (TextView) findViewById(R.id.login);
        username = (EditText) findViewById(R.id.ev_username);
        password = (EditText) findViewById(R.id.ev_password);

    }
}
