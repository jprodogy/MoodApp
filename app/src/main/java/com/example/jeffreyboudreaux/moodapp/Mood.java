package com.example.jeffreyboudreaux.moodapp;

import java.util.ArrayList;

public class Mood {
    private ArrayList<Integer> moods;

    public void addMood(int i){
        moods.add(i);
    }
    public ArrayList getMood(){
        return moods;
    }

}
