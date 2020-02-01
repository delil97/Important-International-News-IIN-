package com.example.importantnews.Classes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.importantnews.R;
import com.squareup.picasso.Picasso;

public class Detailed extends AppCompatActivity { // this offers a backport of the action bar

    TextView tvTitle,tvSource,tvTime,tvDesc;
    ImageView imageView;
    WebView webView;
    ProgressBar loader;

    @SuppressLint("WrongViewCast") // Indicates that Lint should ignore the specified warnings for the annotated element.
    @Override
    protected void onCreate(Bundle savedInstanceState) { // here is where we initialize our activity.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        //findViewById() is used to find a view in the layout of our Activity
        tvTitle = findViewById(R.id.tvTitle);
        tvSource = findViewById(R.id.tvSource);
        tvTime = findViewById(R.id.tvDate);
        tvDesc = findViewById(R.id.tvDesc);

        //ImageView displays image resources, for example Bitmap or Drawable resources.
        // ImageView is also commonly used to apply tints to an image and handle image scaling.
        // In our case we see the different images of the news
        imageView = findViewById (R.id.imageView);

        // webView objects allow us to display web content as part of our activity layout,
        // in other words, it is a View that displays web pages.
        webView = findViewById (R.id.webView);

        // With the loader API we load data from content provider or other data source
        // for display in an FragmentActivity or Fragment.
        loader = findViewById (R.id.webViewLoader);
        loader.setVisibility(View.VISIBLE);

        Intent intent = getIntent(); // We get all data from adapter using getIntent
        String title = intent.getStringExtra("title");
        String source = intent.getStringExtra("source");
        String time = intent.getStringExtra("time");
        String desc = intent.getStringExtra("desc");
        String imageUrl = intent.getStringExtra("imageUrl");
        String url = intent.getStringExtra("url");

        tvTitle.setText(title);
        tvSource.setText(source);
        tvTime.setText(time);
        tvDesc.setText(desc);

        Picasso.with(Detailed.this).load(imageUrl).into(imageView); // free image loading
        //shows webview under details
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
        if (webView.isShown()){
            loader.setVisibility(View.INVISIBLE);
        }
    }
}