package com.pdky.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by robot on 2017/5/16.
 */


public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initViews();
    }


    public abstract int getLayoutId();

    public View findView(int vId) {
        return findViewById(vId);
    }

    public abstract void initViews();

}
