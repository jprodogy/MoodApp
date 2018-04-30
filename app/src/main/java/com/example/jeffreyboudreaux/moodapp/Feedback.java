package com.example.jeffreyboudreaux.moodapp;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Feedback {
    private Map<Integer, String[]> feeMap;
    private String feed;
    private Context context;


    public Feedback(Context current) throws IOException {
        context = current;
        InputStream ip = context.getResources().openRawResource(R.raw.feedback);
        BufferedReader bReader = new BufferedReader(new InputStreamReader(ip, Charset.defaultCharset()));
        feeMap = new HashMap<>();

        try {
            String line;
            int i = 0;
            while((line = bReader.readLine()) != null){
                String[] info = line.split(",");
                feeMap.put(i,info);
                i++;
            }
        }catch (NullPointerException e){

        }

    }

    public void setFeed(int i){
        Random rand = new Random();
        String[] encList = feeMap.get(i);
        feed = encList[rand.nextInt(encList.length)];

    }

    public String getFeed(){
        return feed;
    }
}
