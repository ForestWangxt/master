package com.kpi.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.kpi.activity.AboutStormActivity;
import com.kpi.activity.BeginHelpActivity;
import com.kpi.activity.InfoActivity;
import com.kpi.activity.InforMessActivity;
import com.kpi.activity.SetActivity;
import com.storm.kpi.R;

/**
 * 我的智码
 */
public class MyKPIFragment extends Fragment implements View.OnClickListener {


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
        RelativeLayout Layout_info = (RelativeLayout) view.findViewById(R.id.Layout_info);
        RelativeLayout Layout_about_Storm = (RelativeLayout) view.findViewById(R.id.Layout_about_Storm);
        RelativeLayout Layout_Set = (RelativeLayout) view.findViewById(R.id.Layout_Set);
        RelativeLayout beginhelp = (RelativeLayout) view.findViewById(R.id.beginhelp);
        RelativeLayout infor_message = (RelativeLayout) view.findViewById(R.id.infor_message);
        Layout_info.setOnClickListener(this);
        Layout_about_Storm.setOnClickListener(this);
        Layout_Set.setOnClickListener(this);
        beginhelp.setOnClickListener(this);
        infor_message.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.Layout_info:
                intent = new Intent(getActivity(), InfoActivity.class);
                break;
            case R.id.Layout_about_Storm:
                intent = new Intent(getActivity(), AboutStormActivity.class);
                break;
            case R.id.beginhelp:
                intent = new Intent(getActivity(), BeginHelpActivity.class);
                break;
            case R.id.Layout_Set:
                intent = new Intent(getActivity(), SetActivity.class);
                break;
            case R.id.infor_message:
                intent = new Intent(getActivity(), InforMessActivity.class);
                break;
        }
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }
}
