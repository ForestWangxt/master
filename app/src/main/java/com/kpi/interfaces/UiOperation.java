package com.kpi.interfaces;

/**
 * UI操作接口
 */
public interface UiOperation  {
    /*
       初始化View
     */
    public abstract void initView();

    /*
    返回不同页面的布局ID
     */
    public abstract int getLayoutID();

    //初始化监听器
    public abstract void initListener();

    //初始化数据
    public abstract void initData();

    public abstract void initToolBar();

}
