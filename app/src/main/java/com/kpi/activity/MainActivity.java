package com.kpi.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.kpi.adapter.viewPagerAdapter;
import com.kpi.fragment.HomeFragment;
import com.kpi.fragment.MyKPIFragment;
import com.kpi.fragment.MessageFragment;
import com.kpi.fragment.SelectCounterFragment;
import com.kpi.utils.ToastUtils;
import com.storm.kpi.R;

/**
 * 主页面  ————》业务逻辑
 */
public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    private ViewPager viewPager;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private RadioButton radioButton5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        initFragment();
        initViews();
        initToolBar();

//        //抽屉式布局
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();
//        toggle.setHomeAsUpIndicator(new ColorDrawable(Color.WHITE));
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
    }

    protected void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
        }
    }

    //初始化布局
    private void initViews() {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.home);
        radioButton1 = (RadioButton) findViewById(R.id.rb_home);
        radioButton2 = (RadioButton) findViewById(R.id.rb_redian);
        radioButton3 = (RadioButton) findViewById(R.id.rb_shiting);
        //    radioButton4 = (RadioButton) findViewById(R.id.rb_shezhi);
        radioButton5 = (RadioButton) findViewById(R.id.rb_MyKPI);
        radioGroup.setOnCheckedChangeListener(this);
    }


    //初始化Fragment
    private void initFragment() {
        viewPagerAdapter adapter = new viewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new HomeFragment());  //主页面
        adapter.AddFragment(new MessageFragment());   //消息
        adapter.AddFragment(new SelectCounterFragment());   //门店查询
        //adapter.AddFragment(new ContactsFragment());
        adapter.AddFragment(new MyKPIFragment());    //我的智码
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new onPageChange());
        viewPager.setOffscreenPageLimit(3);
        viewPager.setPageTransformer(true, new DepthPageTransformer());
    }


//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }


    //RadioGroup监听事件
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        ImageView img_location = (ImageView) findViewById(R.id.img_location);
        switch (checkedId) {
            case R.id.rb_home:
                viewPager.setCurrentItem(0);
                radioButton1.setChecked(true);
                img_location.setVisibility(View.GONE);
                break;
            case R.id.rb_redian:
                viewPager.setCurrentItem(1);
                radioButton2.setChecked(true);
                img_location.setVisibility(View.GONE);
                break;
            case R.id.rb_shiting:
                viewPager.setCurrentItem(2);
                radioButton3.setChecked(true);
                img_location.setVisibility(View.VISIBLE);
                break;
            //       case R.id.rb_shezhi:
            //       viewPager.setCurrentItem(3);
            //      radioButton4.setChecked(true);
            //          break;
            case R.id.rb_MyKPI:
                viewPager.setCurrentItem(4);
                radioButton5.setChecked(true);
                img_location.setVisibility(View.GONE);
                break;

        }
    }

    //ViewPager当前页面改变---》通知RadioButton字体的颜色
    class onPageChange implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    radioButton1.setChecked(true);
                    break;
                case 1:
                    radioButton2.setChecked(true);
                    break;
                case 2:
                    radioButton3.setChecked(true);
                    break;
                case 3:
                    // radioButton4.setChecked(true);
                    //    break;
                case 4:
                    radioButton5.setChecked(true);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }


    public class DepthPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.75f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            if (position < 0) {
                view.setAlpha(1 + position);
            } else if (position == 0) {
                view.setAlpha(1);
                view.setScaleX(1);  // 缩放
                view.setScaleY(1);
            } else if (position > 0) {
                view.setAlpha(1 - position);
                view.setTranslationX(pageWidth * -position);
                float scaleFactor = MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);
            }
        }
    }


    private long timeMillis;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - timeMillis) > 2000) {
                ToastUtils.showMessage(this, "再按一次退出动量智码");
                timeMillis = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return false;
    }
}
