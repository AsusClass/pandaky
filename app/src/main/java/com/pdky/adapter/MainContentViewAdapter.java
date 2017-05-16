package com.pdky.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sky on 2017/1/4.
 */

public class MainContentViewAdapter extends FragmentPagerAdapter {
    private Context context;
    private List<Fragment> list = new ArrayList<>();

    public MainContentViewAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    public void add(Fragment fragment) {
        list.add(fragment);
    }


    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

}
