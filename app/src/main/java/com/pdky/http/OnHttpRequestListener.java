package com.pdky.http;

/**
 * Created by robot on 2017/5/16.
 */

public interface OnHttpRequestListener<T> {
    void onSuccess(T t);

    void onFail(String error);
}
