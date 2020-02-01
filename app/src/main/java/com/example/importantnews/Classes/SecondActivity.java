package com.example.importantnews.Classes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.importantnews.R;

public class SecondActivity extends AppCompatActivity {

    Button click;
    public static TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_second);

        click = (Button) findViewById (R.id.btnSwedishNews);
        data = (TextView) findViewById (R.id.fetcheddata);

        click.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                FetchData process = new FetchData();
                process.execute ();

            }
        });

    }
}
