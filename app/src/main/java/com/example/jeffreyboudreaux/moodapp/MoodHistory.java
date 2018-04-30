package com.example.jeffreyboudreaux.moodapp;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
public class MoodHistory extends AppCompatActivity {
    public ArrayList<String> pastMoods;
    private int amountOfHistory;
    private float yOfMood;

    //k
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //pastMoods = getIntent().getExtras().getStringArrayList("pastMoods");
        pastMoods = MainActivity.pastMoods;
        amountOfHistory = pastMoods.size();
        yOfMood = 100;
        buildGUI();
    }

    public void buildGUI(){
        RelativeLayout historyLayout = new RelativeLayout(this);
        //goes through while loop placing all moods from arraylist into view
        while(amountOfHistory > 0){
            TextView mood = new TextView(this);
            mood.setY(yOfMood);
            yOfMood += 100;
            mood.setText(pastMoods.get(amountOfHistory));
            amountOfHistory--;
            historyLayout.addView(mood);
        }
        setContentView(historyLayout);
    }

}
