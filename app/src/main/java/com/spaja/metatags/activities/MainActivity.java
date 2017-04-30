package com.spaja.metatags.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.spaja.metatags.R;

public class MainActivity extends AppCompatActivity {

    private EditText query;
    private Button getNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();

        getNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, NewsListActivity.class);
                i.putExtra("NEWS_QUERY", query.getText().toString());
                MainActivity.this.startActivity(i);
            }
        });

    }

    private void initializeViews() {
        getNews = (Button) findViewById(R.id.get_news);
        query = (EditText) findViewById(R.id.news_query);
    }
}

