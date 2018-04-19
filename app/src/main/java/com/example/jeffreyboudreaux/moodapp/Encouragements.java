package com.example.jeffreyboudreaux.moodapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by jeffreyboudreaux on 4/18/18.
 */

public class Encouragements {
    private Map<Integer, String[]> encMap;
    private String encourage;

    public Encouragements() throws FileNotFoundException {
        Scanner filereader = new Scanner(new File("Encouragements.csv"));
        int i = 0;
        while(filereader.hasNextLine()){
            String[] info = filereader.nextLine().split(",");
            encMap.put(i, info);
            i++;
        }
    }

    public void setEnc(int i){
        Random rand = new Random();
        String[] encList = encMap.get(i);
        encourage = encList[rand.nextInt()];
    }

    public String getEnc(){
        return encourage;
    }
}
