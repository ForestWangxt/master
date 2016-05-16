package com.kpi.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.RelativeLayout;

import com.kpi.activity.BeginHelp;
import com.kpi.activity.InfoActivity;
import com.kpi.activity.InforMessActivity;


import com.storm.kpi.R;

/**
 * 我的智码
 */
public class MyKPIFragment extends Fragment implements View.OnClickListener {

    private ImageView info_img;
    private RelativeLayout begin,informess;


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
        begin = (RelativeLayout) view.findViewById(R.id.beginhelp);
        begin.setOnClickListener(this);
        informess = (RelativeLayout) view.findViewById(R.id.infor_message);
        informess.setOnClickListener(this);
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
            case R.id.beginhelp:
                intent = new Intent(getActivity(), BeginHelp.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
                break;
            case R.id.infor_message:
                intent = new Intent(getActivity(), InforMessActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
                break;
        }
    }
}
