package com.example.jeffreyboudreaux.moodapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by jeffreyboudreaux on 4/18/18.
 */

public class Feedback {
    private Map<Integer, String[]> feeMap;
    private String feed;

    public Feedback() throws FileNotFoundException {
        Scanner filereader = new Scanner(new File("feedback.csv"));
        int i = 0;
        while(filereader.hasNextLine()){
            String[] info = filereader.nextLine().split(",");
            feeMap.put(i, info);
            i++;
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
