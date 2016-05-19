package com.kpi.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kpi.activity.InfoActivity;
import com.storm.kpi.R;

/**
 * 我的智码
 */
public class MyKPIFragment extends Fragment implements View.OnClickListener {

    private ImageView info_img;

    public MyKPIFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_kpi, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        info_img = (ImageView) view.findViewById(R.id.img_info);
        info_img.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.img_info:
                intent=new Intent(getActivity(), InfoActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);

                break;
        }
    }
}
