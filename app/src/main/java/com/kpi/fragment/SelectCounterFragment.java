package com.kpi.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.model.LatLng;
import com.kpi.utils.DialogUtils;
import com.kpi.utils.NetUtils;
import com.kpi.utils.ToastUtils;
import com.storm.kpi.R;

/**
 * 门店查询
 */
public class SelectCounterFragment extends Fragment implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    private TextureMapView mMapView;
    private LocationClient mLocClient;
    private BaiduMap mBaiduMap;
    public MyLocationListener myListener;
    private boolean isFirst = false;

    public SelectCounterFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_counter, container, false);
        //获取地图控件引用
        mMapView = (TextureMapView) view.findViewById(R.id.bmapView);
        RadioGroup rg = (RadioGroup) view.findViewById(R.id.rg);
        ImageView img_location = (ImageView) getActivity().findViewById(R.id.img_location);
        img_location.setOnClickListener(this);
        rg.setOnCheckedChangeListener(this);
        return view;
    }

    @Override
    public void onDestroy() {
        // 退出时销毁定位
        if (mLocClient != null) {
            mLocClient.stop();
            // 关闭定位图层
            mBaiduMap.setMyLocationEnabled(false);
            mMapView.onDestroy();
            mMapView = null;
            super.onDestroy();
        } else {
            super.onDestroy();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private void showProgressDialog() {
        DialogUtils.showProgressDialog(getActivity(), "正在定位...");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser && NetUtils.isNetworkConnected(getActivity())) {
            getMyLocation();
        }
    }

    //获取实时位置
    private void getMyLocation() {
        isFirst = true;
        showProgressDialog();
        myListener = new MyLocationListener();
        mBaiduMap = mMapView.getMap();
        // 开启定位图层
        mBaiduMap.setMyLocationEnabled(true);
        // 定位初始化
        mLocClient = new LocationClient(getActivity());
        mLocClient.registerLocationListener(myListener);
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setIsNeedAddress(true);  //设置需要位置
        option.setScanSpan(1000);
        mLocClient.setLocOption(option);
        //普通地图
        mLocClient.start();
    }


    @Override
    public void onClick(View v) {
        getMyLocation();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_map_normal:
                //普通地图
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                break;
            case R.id.rb_map_sate:
                //卫星地图
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                break;
        }
    }

    public class MyLocationListener implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            if (bdLocation != null && isFirst) {
                ToastUtils.showMessage(getActivity(), "你当前的区域:" + bdLocation.getCity() + bdLocation.getDistrict());
                MyLocationData locData = new MyLocationData.Builder()
                        .accuracy(bdLocation.getRadius())
                        // 此处设置开发者获取到的方向信息，顺时针0-360
                        .direction(100).latitude(bdLocation.getLatitude())
                        .longitude(bdLocation.getLongitude()).build();
                mBaiduMap.setMyLocationData(locData);
                LatLng ll = new LatLng(bdLocation.getLatitude(),
                        bdLocation.getLongitude());
                MapStatus.Builder builder = new MapStatus.Builder();
                builder.target(ll).zoom(18.0f);
                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
                isFirst = false;
            } else if (bdLocation == null) {
                ToastUtils.showMessage(getActivity(), "定位失败,默认为北京！");
            }
            DialogUtils.dissmissProgressDialog();
        }
    }
}
