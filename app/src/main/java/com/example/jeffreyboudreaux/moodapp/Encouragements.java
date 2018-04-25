package com.example.jeffreyboudreaux.moodapp;
import android.content.Context;
import android.renderscript.ScriptGroup;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
public class Encouragements {
    private Map<Integer, String[]> encMap;
    private String encourage;
    private Context context;

    public Encouragements(Context current) throws IOException {
        context = current;
        InputStream ip = context.getResources().openRawResource(R.raw.encouragements);
        BufferedReader bReader = new BufferedReader(new InputStreamReader(ip, Charset.defaultCharset()));
        try {
            bReader.readLine();
            String line;

            int i = 0;
            while((line = bReader.readLine()) != null){
                String[] info = line.split(",");
                encMap.put(i,info);
                i++;
            }
            bReader.close();

        }catch (NullPointerException e){

        }
    }
    public void setEnc(int i){
        Random rand = new Random();
        String[] encList = encMap.get(i);
        encourage = encList[rand.nextInt(encList.length)];
    }
    public String getEnc(){
        return encourage;
    }
}
