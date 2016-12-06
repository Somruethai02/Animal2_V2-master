package com.example.rtc.somruethaianusa.animal;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;


/**
 * Created by SmilecomputeR on 22/11/2559.
 */

public class GetAnimal extends AsyncTask<Void, Void, String>{

        //Explicit
    private Context context;
    private static final String urlJSON = "http://swiftcodingthai.com/nan/get_animaluser.php";

    public GetAnimal(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Void... params) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlJSON).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e){
            Log.d("20novV2", "e doIn ==>" + e.toString());
            return null;
        }


    }
}   //Main class
