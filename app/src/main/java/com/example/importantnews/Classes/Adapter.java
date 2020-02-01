package com.example.importantnews.Classes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.importantnews.Models.Articles;
import com.example.importantnews.R;
import com.squareup.picasso.Picasso;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context; // context of current state of the application/object.
    List<Articles> articles; // List of articles

    public Adapter(Context context, List<Articles> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override // It tells the compiler that the following method overrides a method of its superclass
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from (parent.getContext ()).inflate (R.layout.items, parent, false);
        return new ViewHolder (view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Articles a = articles.get (position);
        holder.tvTitle.setText (a.getTitle());
        holder.tvSource.setText(a.getSource().getName());
        holder.tvDate.setText ("\u2022"+dateTime (a.getPublishedAt ()));

        String imageUrl = a.getUrlToImage ();
        String url = a.getUrl ();

        Picasso.with (context).load (imageUrl).into(holder.imageView); //  image downloading and caching library for Android.
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // In order to use the CardView we need to add it to our layout file.
                //  recieves data with Intent..
                Intent intent = new Intent (context,Detailed.class);
                intent.putExtra("title",a.getTitle());
                intent.putExtra("source",a.getSource().getName());
                intent.putExtra("time",dateTime(a.getPublishedAt()));
                intent.putExtra("desc",a.getDescription());
                intent.putExtra("imageUrl",a.getUrlToImage());
                intent.putExtra("url",a.getUrl());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() { // getItemCount method should return the number of list items.
        return articles.size ();
    }

    public class ViewHolder extends RecyclerView.ViewHolder { // This ViewHolder class describes the item view and metadata about its place within the RecyclerView.
        TextView tvTitle, tvSource, tvDate;
        ImageView imageView;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) { // describes an item view and metadata about its place within the RecyclerView.
            super (itemView);

            // findViewById() is used to find a view in the layout of our Activity. This is not
            // possible in a Fragment for example
            tvTitle = itemView.findViewById (R.id.tvTitle);
            tvSource = itemView.findViewById (R.id.tvSource);
            tvDate = itemView.findViewById (R.id.tvDate);
            imageView = itemView.findViewById (R.id.image);
            cardView = itemView.findViewById (R.id.cardView);

        }
    }

    public String dateTime(String t){
        PrettyTime prettyTime = new PrettyTime(new Locale(getCountry())); // Pretty time library to get a
        // formatted date string with a text in my android application.
        String time = null;
        // the date format, shows in hours and minutes
        try { // Error handling
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:",Locale.ENGLISH);
            Date date = simpleDateFormat.parse (t);
            time = prettyTime.format(date);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    public String getCountry(){ // Returns the country/region code for this locale

        Locale locale = Locale.getDefault ();
        String country = locale.getCountry();
        return country.toLowerCase();
    }
}
