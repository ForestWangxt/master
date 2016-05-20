package com.kpi.activity;


import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.storm.kpi.R;

/**
 * 新手帮助
 */
public class BeginHelpActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginhelp);
        initToolBar();
    }

    public void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.help_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setHomeAsUpIndicator(R.mipmap.left);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

}
