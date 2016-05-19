package com.kpi.activity;

import android.os.Bundle;

import com.storm.kpi.R;

public class MyAccountActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        initToolBar();
    }

    protected void initToolBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("我的账户");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

}
