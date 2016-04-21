package com.kpi.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast工具类
 */
public class ToastUtils {
    private static Toast mToast;

    public static void show(Context context) {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
        mToast = Toast.makeText(context, "连接超时！", Toast.LENGTH_SHORT);
        mToast.show();
    }

    public static void showMessage(Context context, String message) {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
        mToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        mToast.show();
    }

}
