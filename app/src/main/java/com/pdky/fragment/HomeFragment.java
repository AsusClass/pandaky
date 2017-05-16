package com.pdky.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.pdky.R;
import com.pdky.adapter.PostAdapter;
import com.pdky.manager.PostManager;
import com.pdky.model.Post;
import com.pdky.utils.ToastUtils;

import java.util.List;

/**
 * Created by robot on 2017/5/16.
 */

public class HomeFragment extends Fragment {

    View view = null;

    XRecyclerView rcv = null;
    PostAdapter adapter = null;

    int cur_page = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = View.inflate(container.getContext(), R.layout.fragment_home_layout, null);
            rcv = (XRecyclerView) view.findViewById(R.id.rcv);
            rcv.setLayoutManager(new LinearLayoutManager(getContext()));
            adapter = new PostAdapter();
            rcv.setLoadingListener(new XRecyclerView.LoadingListener() {
                @Override
                public void onRefresh() {
                    refresh();
                }

                @Override
                public void onLoadMore() {
                    load();
                }
            });
            rcv.setAdapter(adapter);
            refresh();
        }

        return view;
    }


    private void load() {
        cur_page++;
        PostManager.getInstance().RequestPost(cur_page, new PostManager.onPostRequestListenr<List<Post>>() {
            @Override
            public void onSuccess(List<Post> posts) {
                adapter.refresh(posts);
                rcv.loadMoreComplete();
            }

            @Override
            public void onFail(String error) {
                rcv.loadMoreComplete();
                cur_page--;
                ToastUtils.show(getContext(), "服务器繁忙，请稍后再试");
            }
        });
    }


    private void refresh() {
        cur_page = 1;
        PostManager.getInstance().RequestPost(cur_page, new PostManager.onPostRequestListenr<List<Post>>() {
            @Override
            public void onSuccess(List<Post> posts) {
                rcv.refreshComplete();
                adapter.clear();
                adapter.refresh(posts);
            }

            @Override
            public void onFail(String error) {
                rcv.refreshComplete();
                ToastUtils.show(getContext(), "服务器繁忙，请稍后再试");
            }
        });
    }

}
