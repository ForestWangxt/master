package com.kpi.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kpi.activity.ContactsAnalystaActivity;
import com.kpi.activity.MyAccountActivity;
import com.kpi.activity.ProductAboutActivity;
import com.kpi.activity.StormAboutActivity;
import com.storm.kpi.R;

/**
 * 联络伺动
 */
public class ContactsFragment extends Fragment implements View.OnClickListener {

    public ContactsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        initView(view);
        return view;

    }

    private void initView(View view) {
        LinearLayout layout_contacts_analysts = (LinearLayout) view.findViewById(R.id.layout_contacts_analysts);   //联络分析师
        LinearLayout layout_strom_about = (LinearLayout) view.findViewById(R.id.layout_strom_about);   //关于伺动
        LinearLayout layout_product_about = (LinearLayout) view.findViewById(R.id.layout_product_about);  //产品简介
        LinearLayout layout_my_account = (LinearLayout) view.findViewById(R.id.layout_my_account);   //我的账户

        layout_contacts_analysts.setOnClickListener(this);
        layout_strom_about.setOnClickListener(this);
        layout_product_about.setOnClickListener(this);
        layout_my_account.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {

            case R.id.layout_contacts_analysts:
                intent = new Intent(getActivity(), ContactsAnalystaActivity.class);
                startActivity(intent);
                break;
            case R.id.layout_strom_about:
                intent = new Intent(getActivity(), StormAboutActivity.class);
                startActivity(intent);
                break;
            case R.id.layout_product_about:
                intent = new Intent(getActivity(), ProductAboutActivity.class);
                startActivity(intent);
                break;
            case R.id.layout_my_account:
                intent = new Intent(getActivity(), MyAccountActivity.class);
                startActivity(intent);
                break;
        }

    }
}
