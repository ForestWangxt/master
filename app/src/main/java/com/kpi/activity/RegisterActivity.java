package com.kpi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.kpi.utils.CountDownTimer;
import com.storm.kpi.R;

/**
 * 用户注册  ————>通过手机号完成验证码验证功能
 */
public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private Button btn_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initTooBar();
        Button btn_register_next = (Button) findViewById(R.id.btn_register_next);
        btn_code = (Button) findViewById(R.id.btn_get_code);
        btn_code.setOnClickListener(this);
        btn_register_next.setOnClickListener(this);
    }

    private void initTooBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.reg_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle("");
                getSupportActionBar().setHomeAsUpIndicator(R.mipmap.left);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register_next:
                startActivity(new Intent(this, PassWordActivity.class));
                this.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                break;
            case R.id.btn_get_code:
                new TimeCount(60 * 1000, 1000).start();
                break;
        }
    }

    /***
     * 获取验证码倒计时
     */
    private class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            btn_code.setClickable(false);
            btn_code.setText(millisUntilFinished / 1000 + "秒后可重发");
        }

        @Override
        public void onFinish() {
            btn_code.setText("重新获取");
            btn_code.setClickable(true);
        }
    }
}
