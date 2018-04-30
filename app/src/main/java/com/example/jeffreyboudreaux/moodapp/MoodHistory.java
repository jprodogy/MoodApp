package com.example.jeffreyboudreaux.moodapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MoodHistory extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    public ArrayList<String> pastMoods;
    private int amountOfHistory;
    private float yOfMood;

    private String MH = "MoodHistory";
    protected BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.w(MH, "on top of onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moodhistory);

        navigationView = findViewById(R.id.navigationView);
        navigationView.setOnNavigationItemSelectedListener(this);

        /*super.onCreate(savedInstanceState);
        //pastMoods = getIntent().getExtras().getStringArrayList("pastMoods");
        Log.w(MH, "Retrieving past moods");
        pastMoods = MainActivity.pastMoods;
        amountOfHistory = pastMoods.size();
        yOfMood = 100;
        buildGUI();*/

        pastMoods = MainActivity.pastMoods;
        buildGUI();
    }


    public void buildGUI(){
        RelativeLayout moodHistoryScreen = new RelativeLayout(this);

        history = new TextView(this);
        quote.setText(quotes.get(rand.nextInt(quotes.size())));
        quote.setX(500);
        quote.setY(500);
        quoteScreen.addView(quote)
        ;
        setContentView(quoteScreen);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_addRecord:
                startActivity(new Intent(this, RecordMoodActivity.class));
                return true;
            case R.id.nav_viewRecords:
                startActivity(new Intent(this, MoodHistory.class));
                return true;
            case R.id.nav_homepage:
                startActivity(new Intent(this, MainActivity.class));
                return true;
        }
        return false;
    }

    /*public void buildGUI(){
        Log.w(MH, "Buidling gui");

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
        Log.w(MH, "Built Gui");

    }*/

}
