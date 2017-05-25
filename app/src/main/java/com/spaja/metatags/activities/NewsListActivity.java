package com.spaja.metatags.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.spaja.metatags.R;
import com.spaja.metatags.adapters.NewsAdapter;
import com.spaja.metatags.model.ResponseData;
import com.spaja.metatags.networking.NewsAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsListActivity extends AppCompatActivity {

    private NewsAdapter newsAdapter;
    private RecyclerView newsRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

        initializeToolbar();

        String query = getIntent().getStringExtra("NEWS_QUERY");

        getSupportActionBar().setTitle(query + " News");

        getNewsList(query);

        initializeNewsRecycler();

    }

    private void initializeToolbar() {
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initializeNewsRecycler() {

        newsRecycler = (RecyclerView) findViewById(R.id.news_list_recycler);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        newsRecycler.setLayoutManager(manager);
    }

    private void getNewsList(String query) {

        NewsAPI.service.getNewsData(query, "rss", "fr").enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {

                newsAdapter = new NewsAdapter(NewsListActivity.this, response.body());
                newsRecycler.setAdapter(newsAdapter);

            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                int i = 0;
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
