package com.example.rtc.somruethaianusa.animal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private TextView cat1TextView, cat2TextView, cat3TextView, cat4TextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        cat1TextView = (TextView) findViewById(R.id.textView2);
        cat2TextView = (TextView) findViewById(R.id.textView3);
        cat3TextView = (TextView) findViewById(R.id.textView4);
        cat4TextView = (TextView) findViewById(R.id.textView5);

        //TextView Controller
        cat1TextView.setOnClickListener(this);
        cat2TextView.setOnClickListener(this);
        cat3TextView.setOnClickListener(this);
        cat4TextView.setOnClickListener(this);


    }   //Main Method

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.textView2:
                break;
            case R.id.textView3:

                Intent intent = new Intent(MainActivity.this, DetailListView.class);
                startActivity(intent);


                break;
            case R.id.textView4:
                break;
            case R.id.textView5:
                break;

        }

    }   //onClick

}   //Main class
