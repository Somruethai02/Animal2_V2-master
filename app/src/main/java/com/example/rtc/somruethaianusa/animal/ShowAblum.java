package com.example.rtc.somruethaianusa.animal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowAblum extends AppCompatActivity {

    //Explicit
    private TextView textView;
    private ImageView imageView;
    private Button preButton, nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_ablum);

        //Bind Widget
        textView = (TextView) findViewById(R.id.textView9);
        imageView = (ImageView) findViewById(R.id.imageView2);
        preButton = (Button) findViewById(R.id.button2);
        nextButton = (Button) findViewById(R.id.button3);

        //SynData
        synData();


    }   // Main Method

    private void synData() {

        try {

            GetAnimal getAnimal = new GetAnimal(ShowAblum.this);
            getAnimal.execute();
            String s = getAnimal.get();
            Log.d("5decV1", "s ==> " + s);

        } catch (Exception e) {
            Log.d("5decV1", "e ==> " + e.toString());
        }

    }   // synData

}   // Main Class
