package com.example.jeffreyboudreaux.moodapp;

import java.util.ArrayList;

public class Mood {
    private ArrayList<String> moods;

    public void addMood(int i){
        if (i == 0){
            moods.add("Happy");
        }else if (i == 1){
            moods.add("Sad");
        }else if (i == 2){
            moods.add("Mad");
        }else if (i == 3){
            moods.add("Tired");
        }else if (i == 4){
            moods.add("Stressed");
        }else if (i == 5){
            moods.add("Depressed");
        }else if (i == 6){
            moods.add("Nervous");
        }else if (i == 7){
            moods.add("Confused");
        }else if (i == 8){
            moods.add("Mellow");
        }

    }
    public ArrayList getMood(){
        return moods;
    }

}
