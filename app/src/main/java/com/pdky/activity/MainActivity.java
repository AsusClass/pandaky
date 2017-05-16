package com.pdky.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.pdky.R;
import com.pdky.adapter.MainContentViewAdapter;
import com.pdky.base.App;
import com.pdky.fragment.BuddyFragment;
import com.pdky.fragment.FocusFragment;
import com.pdky.fragment.HistoryFragment;
import com.pdky.fragment.HomeFragment;
import com.pdky.widget.NoScrollViewPager;

public class MainActivity extends AppCompatActivity {


    private NoScrollViewPager mContentView;

    private int cur_index = 0;
    private String[] titles = {"首页", "关注", "好友", "历史"};
    private Long firstTime = 0L;

    private TextView title;

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.main_home:
                    cur_index = 0;
                    updateTitle(cur_index);

                    mContentView.setCurrentItem(cur_index);
                    return true;
                case R.id.main_focus:
                    cur_index = 1;
                    updateTitle(cur_index);

                    mContentView.setCurrentItem(cur_index);
                    return true;
                case R.id.main_buddy:
                    cur_index = 2;
                    updateTitle(cur_index);

                    mContentView.setCurrentItem(cur_index);
                    return true;
                case R.id.main_history:
                    cur_index = 3;
                    updateTitle(cur_index);

                    mContentView.setCurrentItem(cur_index);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getInstance().registerActivity(this);
        setContentView(R.layout.activity_main);
        initView();

    }

    void updateTitle(int index) {
        title.setText(titles[index]);
    }


    void initView() {
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        title = (TextView) findViewById(R.id.main_title);
        mContentView = (NoScrollViewPager) findViewById(R.id.viewPager);
        MainContentViewAdapter adapter = new MainContentViewAdapter(getSupportFragmentManager(),
                this);
        adapter.add(new HomeFragment());
        adapter.add(new FocusFragment());
        adapter.add(new BuddyFragment());
        adapter.add(new HistoryFragment());
        mContentView.setAdapter(adapter);
        mContentView.setCurrentItem(0);
        updateTitle(cur_index);
    }

    @Override
    public void onBackPressed() {
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 1500) {
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
            firstTime = secondTime;
        } else {
            App.getInstance().exitApp();
        }
    }

}
