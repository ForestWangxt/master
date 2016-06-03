package com.kpi.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;

import com.storm.kpi.R;

/**
 * 基类Activity
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApp.getInstance().addActivity(this);
    }

    /**
     *初始化控件
     */
    protected void initView() {

    }

    /**
     * 布局
     *
     * @return
     */
    protected int getLayoutId() {
        return 0;
    }

    /**
     * 初始化数据
     */
    protected void initData(){

    }
    /**
     * ToolBar
     */
    protected void initToolBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * 返回的箭头
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            this.overridePendingTransition(0, R.anim.fade_out);
        }
        return false;
    }


    //返回键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK) {
            this.finish();
            this.overridePendingTransition(0, R.anim.fade_out);
            return true;
        }
        return false;
    }
}
