package com.kpi.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.gson.Gson;
import com.kpi.activity.AreaPerformanceActivity;
import com.kpi.activity.IndexTrendActivity;
import com.kpi.activity.KpiIndexActivity;
import com.kpi.activity.ProductPerformanceActivity;
import com.kpi.activity.UnusualAccountActivity;
import com.kpi.bean.KpiTrend;
import com.kpi.utils.JsonRequest;
import com.kpi.utils.NetUtils;
import com.kpi.utils.UrlUtils;
import com.storm.kpi.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态智码Fragment
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private LineChart mLineChart;
    private RequestQueue queue;
    private KpiTrend mKpiTrend;

    public HomeFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        queue = Volley.newRequestQueue(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        UrlUtils.qSearchType = "1";
        View view = inflater.inflate(R.layout.content_main, container, false);
        initView(view);
        if (NetUtils.isNetworkConnected(getActivity())) {
            RequestChartValue();
        }
        return view;

    }

    private void initView(View view) {
        LinearLayout KpiIndex = (LinearLayout) view.findViewById(R.id.layout_kpiIndex); //重要KPI指标
        LinearLayout indexTrend = (LinearLayout) view.findViewById(R.id.layout_IndexTrend);  //指标趋势
        LinearLayout areaPer = (LinearLayout) view.findViewById(R.id.layout_area);     //区域表现
        LinearLayout productPer = (LinearLayout) view.findViewById(R.id.layout_product);  //产品表现
        LinearLayout unusualAccount = (LinearLayout) view.findViewById(R.id.layout_unusual);  //异常账户
        mLineChart = (LineChart) view.findViewById(R.id.home_LineChart);   //折线图表
        KpiIndex.setOnClickListener(this);
        indexTrend.setOnClickListener(this);
        areaPer.setOnClickListener(this);
        productPer.setOnClickListener(this);
        unusualAccount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.layout_kpiIndex:
                intent = new Intent(getActivity(), KpiIndexActivity.class);
                startActivity(intent);
                break;
            case R.id.layout_IndexTrend:
                intent = new Intent(getActivity(), IndexTrendActivity.class);
                startActivity(intent);
                break;
            case R.id.layout_area:
                intent = new Intent(getActivity(), AreaPerformanceActivity.class);
                startActivity(intent);
                break;
            case R.id.layout_product:
                intent = new Intent(getActivity(), ProductPerformanceActivity.class);
                startActivity(intent);
                break;
            case R.id.layout_unusual:
                intent = new Intent(getActivity(), UnusualAccountActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void RequestChartValue() {
        JsonRequest request = new JsonRequest(new UrlUtils().KpiTrend_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                mKpiTrend = new Gson().fromJson(jsonObject.toString(), KpiTrend.class);
                if (mKpiTrend.isSuccess()) {
                    UpdateChartValue();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        queue.add(request);
    }

    private void UpdateChartValue() {
        XAxis xAxis = mLineChart.getXAxis();
        //设置X轴的文字在底部
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //设置描述文字
        mLineChart.setDescription("一周走势图");
        KpiTrend.DataEntity dateEntity = mKpiTrend.getData();
        List<KpiTrend.DataEntity.DataListDetailEntity> list = dateEntity.getDataListDetail();
        ArrayList<String> xValues = new ArrayList<>();
        //模拟第二组组y轴数据(存放y轴数据的是一个Entry的ArrayList) 他是构建LineDataSet的参数之一
        ArrayList<Entry> scanCount = new ArrayList<>();
        ArrayList<Entry> customerCount = new ArrayList<>();
        ArrayList<Entry> addCount = new ArrayList<>();
        for (int i = 0, count = list.size(); i < count; i++) {
            //时间-->X轴
            xValues.add(list.get(i).getDateMd());
            //扫码件数
            scanCount.add(new Entry(list.get(i).getScanCount(), i));
            //扫码人数
            customerCount.add(new Entry(list.get(i).getCustomerCount(), i));
            //注册人数
            addCount.add(new Entry(list.get(i).getAddCount(), i));
        }
        LineDataSet scanCountSet = new LineDataSet(scanCount, "扫码件数");
        scanCountSet.setColor(Color.RED);
        scanCountSet.setHighLightColor(Color.RED);


        LineDataSet customerCountSet = new LineDataSet(customerCount, "扫码人数");
        customerCountSet.setColor(Color.BLUE);
        customerCountSet.setHighLightColor(Color.BLUE);

        LineDataSet addCountSet = new LineDataSet(addCount, "注册人数");
        addCountSet.setColor(Color.GREEN);
        addCountSet.setHighLightColor(Color.GREEN);


        //构建一个类型为LineDataSet的ArrayList 用来存放所有y的LineDataSet
        // 他是构建最终加入LineChart数据集所需要的参数
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(scanCountSet);
        dataSets.add(customerCountSet);
        dataSets.add(addCountSet);

        //构建一个LineData 将dataSets放入
        LineData lineData = new LineData(xValues, dataSets);
        mLineChart.animateX(2000); // 立即执行的动画,x轴
        mLineChart.animateY(2000); // 立即执行的动画,Y轴
        mLineChart.setDragEnabled(true);// 是否可以拖拽
        mLineChart.setScaleEnabled(true);// 是否可以缩放
        //设置不绘画值
        lineData.setDrawValues(true);
        //将数据插入
        mLineChart.setData(lineData);
    }
}
