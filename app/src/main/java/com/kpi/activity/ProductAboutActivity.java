package com.kpi.activity;

import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.storm.kpi.R;

/**
 * 产品简介
 */
public class ProductAboutActivity extends BaseActivity {


    @Override
    public int getLayoutID() {
        return R.layout.activity_product_about;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        PhotoView img_product_about = (PhotoView) findViewById(R.id.img_product_about);
        img_product_about.enable();
        RequestManager manager = Glide.with(this);
        manager.load("http://192.168.0.19:4444/image/productInfo.png").into(img_product_about);
    }

    @Override
    public void initToolBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("产品简介");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
