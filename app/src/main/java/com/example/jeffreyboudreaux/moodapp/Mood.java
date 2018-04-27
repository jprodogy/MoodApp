package com.example.jeffreyboudreaux.moodapp;

import java.util.ArrayList;

/**
 * Created by jeffreyboudreaux on 4/27/18.
 */

public class Mood {
    private ArrayList<Integer> moods;

    public void addMood(int i){
        moods.add(i);
    }
    public ArrayList getMood(){
        return moods;
    }

}
