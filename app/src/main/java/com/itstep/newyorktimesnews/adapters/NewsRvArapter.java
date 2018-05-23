package com.itstep.newyorktimesnews.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itstep.newyorktimesnews.R;
import com.itstep.newyorktimesnews.entities.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsRvArapter extends RecyclerView.Adapter<NewsRvArapter.ViewHolder> {

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
        this.notifyDataSetChanged();
    }

    private List<News> newsList = new ArrayList<>();


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_news_recycler,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(newsList.get(position));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.newsImageView) ImageView newsImageView;
        @BindView(R.id.newsTextView) TextView newsTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
        public void bind(News news){
            Picasso.get().load(news.getMedia().get(0).getMediaMetadata().get(1).getUrl()).into(newsImageView);
            newsTextView.setText(news.getTitle());
        }
    }
}
