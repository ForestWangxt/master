package com.kpi.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.kpi.activity.BusinessOpportunityActivity;
import com.kpi.activity.SelectCounterActivity;
import com.storm.kpi.R;

public class WorkingFragment extends BaseFragment implements View.OnClickListener {

    private TextView tv_NearbyShop;
    private TextView tv_NearbyBusiness;

    @Override
    public int getLayoutID() {
        return R.layout.fragment_select_counter;
    }

    @Override
    public void initView() {
        tv_NearbyShop = findView(R.id.tv_work_NearbyShop);
        tv_NearbyBusiness = findView(R.id.tv_work_NearbyBusiness);
    }

    @Override
    public void initListener() {
        tv_NearbyShop.setOnClickListener(this);
        tv_NearbyBusiness.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initToolBar() {

    }

    Intent intent = null;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_work_NearbyShop:
                intent = new Intent(getActivity(), SelectCounterActivity.class);
                break;
            case R.id.tv_work_NearbyBusiness:
                intent = new Intent(getActivity(), BusinessOpportunityActivity.class);
                break;
        }
        startActivity(intent);
    }
}
