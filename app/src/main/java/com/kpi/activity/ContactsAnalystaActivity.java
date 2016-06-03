package com.kpi.activity;

import android.os.Bundle;

import com.kpi.image.SmartImageView;
import com.kpi.utils.DialogUtils;
import com.storm.kpi.R;

public class ContactsAnalystaActivity extends BaseActivity {

    private SmartImageView smartImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_analysta);
        initToolBar();
        smartImageView = (SmartImageView) findViewById(R.id.contacts_analysts);
        initView();
    }

    protected void initView() {
        DialogUtils.showProgressDialog(this, "正在加载...");
        smartImageView.setImageUrl("http://192.168.0.19:4444/image/touchMe.jpg");
        DialogUtils.dissmissProgressDialog();
    }


    protected void initToolBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("联络分析师");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

}
