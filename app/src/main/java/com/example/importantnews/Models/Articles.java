package com.example.importantnews.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Articles {

    // These fields are annotated with the @SerializedName annotation.
    // By specifying @SerializedName
    // GSON will not look in json based on variable name & will just use specified @SerializedName.

    @SerializedName("source")
    @Expose
    private Source source;

    @SerializedName("author")
    @Expose
    private String author;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("url")
    @Expose
    private String url;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @SerializedName("urlToImage") // the url for the image
    @Expose
    private String urlToImage;

    @SerializedName("publishedAt") // here we see the news adress
    @Expose
    private String publishedAt;



    public Source getSource() {
        return source;
    }

   // Setter to generate mutator methods for setting the values of class fields
    // Getters and setters was created automatically by pressing Alt+Shift+S, R.
    public void setSource(Source source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}