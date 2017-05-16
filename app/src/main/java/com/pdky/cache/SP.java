package com.pdky.cache;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by robot on 2017/5/16.
 */
public class SP {
    static SharedPreferences sp = null;
    static SharedPreferences.Editor editor;

    public static void initialize(Context context, String name) {
        sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public static void putString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public static String getValue(String key) {
        return sp.getString(key, null);
    }

    public static void close() {
        sp = null;
        editor = null;
    }


}

