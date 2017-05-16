package com.pdky.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.pdky.R;
import com.pdky.manager.UserManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        init();
    }

    private void init() {
        if (checkUpdate()) {

        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (UserManager.getInstance().isLogin()) {

                        startMain();
                    } else {

                        startLogin();
                    }
                }
            }, 2000);
        }
    }

    private void startLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void startMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    private boolean checkUpdate() {
        return false;
    }

}
