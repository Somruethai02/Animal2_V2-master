package com.example.rtc.somruethaianusa.animal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

public class ShowAblum extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private TextView textView;
    private ImageView imageView;
    private Button preButton, nextButton;
    private String[] nameStrings;
    private String[] imageStrings;
    private int animalAnInt, indexAnInt= 0;

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

        //Button Controller
        preButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);


    }   // Main Method

    private void synData() {

        try {

            GetAnimal getAnimal = new GetAnimal(ShowAblum.this);
            getAnimal.execute();
            String s = getAnimal.get();
            Log.d("5decV1", "s ==> " + s);

            JSONArray jsonArray = new JSONArray(s);
            nameStrings = new String[jsonArray.length()];
            imageStrings = new String[jsonArray.length()];
            animalAnInt = jsonArray.length();

            for (int i=0;i<jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                nameStrings[i] = jsonObject.getString("Name");
                imageStrings[i] = jsonObject.getString("Image");

            }   // for

            changeView(0);

        } catch (Exception e) {
            Log.d("5decV1", "e ==> " + e.toString());
        }

    }   // synData

    private void changeView(int index) {

        textView.setText(nameStrings[index]);
        Picasso.with(ShowAblum.this).load(imageStrings[index]).into(imageView);

    }

    @Override
    public void onClick(View view) {

        try {

            switch (view.getId()) {
                case R.id.button2:
                    if (indexAnInt <= 0) {
                        indexAnInt = animalAnInt;
                    } else {
                        indexAnInt -= 1;
                    }

                    break;
                case R.id.button3:

                    if (indexAnInt >= animalAnInt) {
                        indexAnInt = 0;
                    } else {
                        indexAnInt += 1;
                    }

                    break;
            }

            changeView(indexAnInt);

        } catch (Exception e) {
            Log.d("5decV1", "e onClick ==> " + e.toString());
        }



    }   // onClick
}   // Main Class
