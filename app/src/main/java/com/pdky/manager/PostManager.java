package com.pdky.manager;

import com.pdky.base.App;
import com.pdky.http.Api;
import com.pdky.http.OnHttpRequestListener;
import com.pdky.model.Post;

import java.util.List;

/**
 * Created by robot on 2017/5/16.
 */

public class PostManager {
    private static PostManager _manager = null;

    public static PostManager getInstance() {
        if (_manager == null)
            _manager = new PostManager();
        return _manager;
    }

    public void RequestPost(final int page, final onPostRequestListenr<List<Post>> listenr) {
        Api.postRequest(page, new OnHttpRequestListener<List<Post>>() {
            @Override
            public void onSuccess(List<Post> posts) {
                listenr.onSuccess(posts);
            }

            @Override
            public void onFail(String error) {
                listenr.onFail(error);
            }
        });
    }


    public interface onPostRequestListenr<T> {
        void onSuccess(T t);

        void onFail(String error);
    }


}
