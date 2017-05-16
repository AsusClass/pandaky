package com.pdky.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pdky.R;
import com.pdky.model.Post;
import com.pdky.widget.CircleImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robot on 2017/5/16.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.HomeItemViewHolder> {

    private List<Post> lists;

    public PostAdapter() {
        this.lists = new ArrayList<>();
    }

    public void refresh(List<Post> ls) {
        for (Post p : ls)
            lists.add(p);
        notifyDataSetChanged();
    }


    public void clear() {
        lists.clear();
        notifyDataSetChanged();
    }

    public void refresh(Post p) {
        lists.add(p);
        notifyDataSetChanged();
    }


    @Override
    public HomeItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeItemViewHolder(View.inflate(parent.getContext(), R.layout.post_item, null));
    }

    @Override
    public void onBindViewHolder(HomeItemViewHolder holder, int position) {
        final Post post = lists.get(position);
        Glide.with(holder.head.getContext()).load(post.imageId).into(holder.head);
        holder.title.setText(post.tittle);
        holder.summary.setText(post.content);
        holder.time.setText(post.time);
        holder.nick.setText(post.username);
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    class HomeItemViewHolder extends RecyclerView.ViewHolder {
        CircleImageView head;
        TextView nick, time, summary, title;


        public HomeItemViewHolder(View itemView) {
            super(itemView);
            head = (CircleImageView) itemView.findViewById(R.id.post_item_head);
            nick = (TextView) itemView.findViewById(R.id.post_item_nick);
            time = (TextView) itemView.findViewById(R.id.post_item_time);
            summary = (TextView) itemView.findViewById(R.id.post_item_summary);
            title = (TextView) itemView.findViewById(R.id.post_item_title);
        }
    }
}
