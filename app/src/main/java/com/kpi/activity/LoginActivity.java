package com.kpi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.storm.kpi.R;

/**
 * 用户登录
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initToolBar();
        initView();
    }

    public void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.login_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
        }
    }

    protected void initView() {
        Button btn_login = (Button) findViewById(R.id.btn_user_login);
        TextView tv_user_reg = (TextView) findViewById(R.id.tv_user_reg);
        TextView tv_user_forgetPassword = (TextView) findViewById(R.id.tv_user_forgetPassword);
        tv_user_forgetPassword.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        tv_user_reg.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_user_login:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                this.finish();
                this.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                break;
            case R.id.tv_user_reg:
                intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                this.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                break;
            case R.id.tv_user_forgetPassword:
                intent = new Intent(this, FindCodeActivity.class);
                startActivity(intent);
                this.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                break;
        }
    }

    //返回键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK) {
            this.finish();
            return true;
        }
        return false;
    }
}