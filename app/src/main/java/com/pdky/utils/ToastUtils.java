package com.pdky.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by robot on 2017/5/16.
 */

public class ToastUtils {
    public static void show(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
