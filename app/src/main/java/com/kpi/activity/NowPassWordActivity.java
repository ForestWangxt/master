package com.kpi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.storm.kpi.R;

/**
 * 更新密码----》检查现有密码
 */
public class
NowPassWordActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pass_word);
        Button btn_now_next = (Button) findViewById(R.id.btn_now_next);
        btn_now_next.setOnClickListener(this);
        initToolBar();
    }

    //初始化头部的ToolBar
    protected void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.now_password_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setHomeAsUpIndicator(R.mipmap.left);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, UpdatePasswordActivity.class));
        this.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }
}
