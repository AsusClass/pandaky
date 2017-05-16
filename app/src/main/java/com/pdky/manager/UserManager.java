package com.pdky.manager;

import com.pdky.http.Api;
import com.pdky.http.OnHttpRequestListener;
import com.pdky.model.User;

/**
 * Created by robot on 2017/5/16.
 */

public class UserManager {
    private static UserManager _userManager = null;

    private boolean _isLogin = false;

    public static UserManager getInstance() {
        if (_userManager == null)
            _userManager = new UserManager();
        return _userManager;
    }

    public boolean isLogin() {
        return _isLogin;
    }

    /**
     * @param account
     * @param password
     * @param listener
     */
    public void login(final String account, final String password, final OnLoginListener listener) {
        Api.login(account, password, new OnHttpRequestListener<User>() {
            @Override
            public void onSuccess(User user) {
                if (user != null) {
                    listener.onSuccess();
                }
            }

            @Override
            public void onFail(String error) {
                listener.onFail();
            }
        });

    }

    public void resister(final String account, final String password, final OnRegisterListener listener) {

    }


    public interface OnRegisterListener {
        void onSuccess();

        void onFail();
    }


    public interface OnLoginListener {
        void onSuccess();

        void onFail();
    }
}
