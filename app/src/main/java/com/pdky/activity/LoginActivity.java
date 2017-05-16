package com.pdky.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.pdky.R;
import com.pdky.base.BaseActivity;
import com.pdky.manager.UserManager;
import com.pdky.utils.ToastUtils;

public class LoginActivity extends BaseActivity {

    private EditText accountET;
    private EditText passwordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initViews() {
        accountET = (EditText) findView(R.id.login_account);
        passwordET = (EditText) findView(R.id.login_password);

    }

    private String getAccount() {
        return TextUtils.isEmpty(accountET.getText().toString().trim()) ? null :
                accountET.getText().toString().trim();
    }


    private String getPassword() {
        return TextUtils.isEmpty(passwordET.getText().toString().trim()) ? null :
                passwordET.getText().toString().trim();

    }


    public void onLogin(View v) {
        if (getAccount() != null && getPassword() != null) {
            UserManager.getInstance().login(getAccount(), getPassword(), new UserManager.OnLoginListener() {
                @Override
                public void onSuccess() {
                    MainActivity.start(LoginActivity.this);
                    LoginActivity.this.finish();
                }

                @Override
                public void onFail() {
                    ToastUtils.show(LoginActivity.this, "account or password incorrect");

                }
            });
        } else {
            ToastUtils.show(this, "account or password shouldn't be empty");
        }

    }


    public void onRegister(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }


}
