package com.kpi.activity;


import android.support.v7.widget.Toolbar;

import com.storm.kpi.R;

/**
 * 信息资讯
 */
public class InforMessActivity extends BaseActivity {


    @Override
    public void initView() {
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_informess;
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.informess_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setHomeAsUpIndicator(R.mipmap.left);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
