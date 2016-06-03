package com.kpi.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kpi.utils.ToastUtils;
import com.storm.kpi.R;

/**
 * 关于伺动
 */
public class AboutStormActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_strom);
        initToolBar();
        initView();
    }

    protected void initToolBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("关于伺动");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    protected void initView() {
        TextView tv_storm_advice = (TextView) findViewById(R.id.tv_storm_advice);   //反馈
        TextView tv_storm_gradle = (TextView) findViewById(R.id.tv_storm_gradle);  //新版本
        TextView tv_storm_version = (TextView) findViewById(R.id.tv_storm_version);  //评分
        tv_storm_advice.setOnClickListener(this);
        tv_storm_gradle.setOnClickListener(this);
        tv_storm_version.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.tv_storm_advice:
                intent = new Intent(this, FeedBackActivity.class);
                break;
            case R.id.tv_storm_gradle:
                //打开第三方的Market
                Uri uri = Uri.parse("market://details?id=" + getPackageName());
                intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                break;
            case R.id.tv_storm_version:
                ToastUtils.showMessage(this, "已是最新版本");
                break;
        }
        startActivity(intent);
        this.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);

    }
}
