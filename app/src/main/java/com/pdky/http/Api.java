package com.pdky.http;

import android.os.Handler;

import com.pdky.R;
import com.pdky.model.Post;
import com.pdky.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robot on 2017/5/16.
 */

public class Api {

    //    user login
    public static void login(final String account, final String password, final OnHttpRequestListener<User> listenr) {
        if (account.equals("13102405") && password.equals("123456")) {
            listenr.onSuccess(new User("13102405", "123456"));
        } else {
            listenr.onFail("account or password error");
        }
    }


    public static void postRequest(final int page, final OnHttpRequestListener<List<Post>> listener) {
        //    get data by page limit 10
//        String content, int imageId, String time, String tittle, String username
        final List<Post> res = new ArrayList<>();
        for (int i = 0; i < 15; ++i)
            res.add(new Post("相对布局 android:layout_above  为将该控件的底部放在指定id控件的上方" +
                    "android:layout_below   同理类似，将该控件的顶部放在指定id控件的下方", R.drawable.user1, "20分钟前",
                    "你知道小仙女是什么吗？", "我全家都是仙女！"));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onSuccess(res);

            }
        }, 1000);
    }


}
