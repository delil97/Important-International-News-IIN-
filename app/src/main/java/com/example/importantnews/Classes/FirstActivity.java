package com.example.importantnews.Classes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.importantnews.R;

public class FirstActivity extends AppCompatActivity {

    // we create a variable for button
    private Button button;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_first);

        button = (Button) findViewById (R.id.button);

        button2 = (Button) findViewById (R.id.button2);

        button3 = (Button) findViewById (R.id.button3);

        button.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                openMainActivity(); // here we call openactivityMain
            }
        });

        button2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                openSecondActivity(); // here we call openactivityMain

            }
        });

        button3.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                openAbout();

            }
        });


    }
    public void openMainActivity(){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity (intent);


    }

    public void openSecondActivity(){
        Intent intent = new Intent (this, SecondActivity.class);
        startActivity (intent);


    }

    public void openAbout(){
        Intent intent = new Intent (this, About.class);
        startActivity (intent);


    }


}
