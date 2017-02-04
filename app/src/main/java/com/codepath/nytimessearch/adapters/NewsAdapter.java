package com.codepath.nytimessearch.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.nytimessearch.R;
import com.codepath.nytimessearch.models.Multimedium;
import com.codepath.nytimessearch.models.News;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lindseyl on 2/1/17.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private Context mContext;
    private List<News> mNewsList;

    private String BASE_URL = "http://www.nytimes.com/";

    public NewsAdapter(Context context, List<News> newsList) {
        this.mContext = context;
        this.mNewsList = newsList;
    }

    public Context getContext() {
        return mContext;
    }

    @Override public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View newsView = inflater.inflate(R.layout.item_news, parent, false);

        // Return a new holder instance
        NewsViewHolder viewHolder = new NewsViewHolder(newsView);
        return viewHolder;
    }

    @Override public void onBindViewHolder(NewsViewHolder holder, int position) {
        // Get the data model based on position
        News news = mNewsList.get(position);

        // Set item views based on your views and data model
        TextView tvTitle = holder.tvTitle;
        tvTitle.setText(news.getHeadline().getMain());
        // TODO: load thumbnail
        String thumbnailUrl = getThumbnailUrl(news.getMultimedia());
        if (!thumbnailUrl.isEmpty()) {
            Glide.with(mContext).load(BASE_URL + thumbnailUrl).into(holder.ivThumbnail);
        }
    }

    @Override public int getItemCount() {
        return mNewsList.size();
    }

    private String getThumbnailUrl(List<Multimedium> mediaList) {
        List<String> urls = new ArrayList<>();
        if (mediaList != null) {
            urls.addAll(mediaList.stream()
                    .filter(medium -> (medium.getType() != null) &&
                    (medium.getType().equals("image")))
                    .map(Multimedium::getUrl)
                    .collect(Collectors.toList()));
            return urls.get(new Random().nextInt(urls.size()));
        }
        return "";
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivThumbnail)
        ImageView ivThumbnail;
        @BindView(R.id.tvTitle)
        TextView tvTitle;

        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
