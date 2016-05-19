package com.kpi.activity;

import android.os.Bundle;

import com.storm.kpi.R;

/**
 * 找回密码
 */
public class ForgotPassWordActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass_word);
        initToolBar();
    }

    protected void initToolBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("找回密码");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
