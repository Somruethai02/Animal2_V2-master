package com.example.rtc.somruethaianusa.animal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

public class DetailListView extends AppCompatActivity {

    //Explicit
    private ListView listView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list_view);

        //Bind Widget
        listView = (ListView) findViewById(R.id.livAnimal);
        button = (Button) findViewById(R.id.button);

        //Create ListView
        try {

            GetAnimal getAnimal = new GetAnimal(DetailListView.this);
            getAnimal.execute();
            String strJSON = getAnimal.get();
            Log.d ("21novV2" ,"JSoN ==> " + strJSON);
            JSONArray jsonArray = new JSONArray(strJSON);

            String[] nameStrings = new String[jsonArray.length()];
            String[] detailStrings = new String[jsonArray.length()];
            String[] imageStrings = new String[jsonArray.length()];

            for (int i=0;i<jsonArray.length();i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                nameStrings[i] = jsonObject.getString("Name");
                detailStrings[i] = jsonObject.getString("Detail");
                imageStrings[i] = jsonObject.getString("Image");

            }   // for

            MyAdapter myAdapter = new MyAdapter(DetailListView.this, detailStrings,
                    nameStrings, imageStrings);
            listView.setAdapter(myAdapter);




        } catch (Exception e){
            Log.d ("21novV2", "e onCreate ==> "+ e.toString());

        }

        //Button Controller
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }   //Main Method

}   //Main class
