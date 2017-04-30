package com.spaja.metatags.classes;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.view.View;

import com.spaja.metatags.activities.ArticleActivity;

/**
 * Created by Spaja on 28-Apr-17.
 */

public class OnArticleClickListener implements View.OnClickListener {

    private Activity mActivity;
    private String articleUrl;

    public OnArticleClickListener(Activity mActivity, String articleUrl) {
        this.mActivity = mActivity;
        this.articleUrl = articleUrl;
    }

    @Override
    public void onClick(View v) {

        Intent i = new Intent(mActivity, ArticleActivity.class);
        i.putExtra("URL", articleUrl);
        mActivity.startActivity(i);
    }
}
