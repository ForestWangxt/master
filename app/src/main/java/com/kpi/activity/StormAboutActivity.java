package com.kpi.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.kpi.utils.DialogUtils;
import com.storm.kpi.R;

public class StormAboutActivity extends BaseActivity {
    private String[] ul = {"http://192.168.0.19:4444/image/storminfo/p2.PNG",
            "http://192.168.0.19:4444/image/storminfo/p3.PNG",
            "http://192.168.0.19:4444/image/storminfo/p4.PNG",
            "http://192.168.0.19:4444/image/storminf" +
                    "o/p5.PNG",
            "http://192.168.0.19:4444/image/storminfo/p6.PNG",
            "http://192.168.0.19:4444/image/storminfo/p7.PNG",
            "http://192.168.0.19:4444/image/storminfo/p8.PNG",
            "http://192.168.0.19:4444/image/storminfo/p9.PNG",
            "http://192.168.0.19:4444/image/storminfo/p10.PNG",
            "http://192.168.0.19:4444/image/storminfo/p11.PNG",
            "http://192.168.0.19:4444/image/storminfo/p12.PNG",
            "http://192.168.0.19:4444/image/storminfo/p13.PNG",
            "http://192.168.0.19:4444/image/storminfo/p14.PNG",
            "http://192.168.0.19:4444/image/storminfo/p15.PNG",
            "http://192.168.0.19:4444/image/storminfo/p16.PNG",
            "http://192.168.0.19:4444/image/storminfo/p17.PNG",
            "http://192.168.0.19:4444/image/storminfo/p18.PNG",
            "http://192.168.0.19:4444/image/storminfo/p1.PNG"};
    /*getResources().getString(R.string.cidong_about_02),
    getResources().getString(R.string.cidong_about_03),
    getResources().getString(R.string.cidong_about_04),
    getResources().getString(R.string.cidong_about_05),
    getResources().getString(R.string.cidong_about_06),
    getResources().getString(R.string.cidong_about_07),
    getResources().getString(R.string.cidong_about_08),
    getResources().getString(R.string.cidong_about_09),
    getResources().getString(R.string.cidong_about_10),
    getResources().getString(R.string.cidong_about_11),
    getResources().getString(R.string.cidong_about_12),
    getResources().getString(R.string.cidong_about_13),
    getResources().getString(R.string.cidong_about_14),
    getResources().getString(R.string.cidong_about_15),
    getResources().getString(R.string.cidong_about_16),
    getResources().getString(R.string.cidong_about_17),
    getResources().getString(R.string.cidong_about_18),
    getResources().getString(R.string.cidong_about_01)};*/
    RequestManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storm_about);
        initToolBar();
        DialogUtils.showProgressDialog(this, "正在加载...");
        ListView listView = (ListView) findViewById(R.id.image_list);
        MyBaseAdapter myBaseAdapter = new MyBaseAdapter();
        listView.setAdapter(myBaseAdapter);
        manager = Glide.with(this);

    }

    class MyBaseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return ul.length;
        }

        @Override
        public Object getItem(int position) {
            return ul[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = View.inflate(StormAboutActivity.this, R.layout.aboutimage, null);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.storm_about);
            //     SmartImageView imageView = (SmartImageView) convertView.findViewById(R.id.storm_about);
            //   imageView.setImageUrl(ul[position]);
            manager.load(ul[position]).into(imageView);
            DialogUtils.dissmissProgressDialog();
//            Glide.with(StormAboutActivity.this).load(ul[position]).into(imageView);
         /*   ViewHolder viewHolder = null;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(StormAboutActivity.this,R.layout.aboutimage,null);
                viewHolder.imageView = (ImageView) convertView.findViewById(R.id.storm_about);
                convertView.setTag(viewHolder);
            } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }*/
            //   Glide.with(StormAboutActivity.this).load(ul[position]).into(viewHolder.imageView);
          /*  viewHolder.imageView.setTag(R.id.add,position+"");
            String tag = (String) viewHolder.imageView.getTag(R.id.add);
            System.out.println(tag);
            if(tag != null && tag.equals(position+"")){
                manager.load(ul[position]).into(viewHolder.imageView);
            }*/

            return convertView;
        }
    }

    protected void initToolBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("伺动简介");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

}
