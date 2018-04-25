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

    private ArrayList<String> pastMoods;
    private int amountOfHistory;
    private float yOfMood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        /*retrieving the history from the selection activity; will need an actual arraylist to be made
        THERE and named "pastMoods" in order to work*/
        pastMoods = getIntent().getExtras().getStringArrayList("pastMoods");
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
