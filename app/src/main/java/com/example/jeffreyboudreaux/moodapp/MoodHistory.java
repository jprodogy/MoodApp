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
    private String MH = "MoodHistory";
    public ArrayList<String> pastMoods;
    TextView display;
    protected BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.w(MH, "on top of onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moodhistory);

        Log.w(MH,"Creating display");
        display = (TextView)findViewById(R.id.moodHistoryDisplay);
        pastMoods = MainActivity.pastMoods;
        printHistory();

        navigationView = findViewById(R.id.navigationView);
        navigationView.setOnNavigationItemSelectedListener(this);
    }
    public void printHistory(){
        Log.w(MH,"On top of print history");
        StringBuilder moodHistoryStringBuilder = new StringBuilder();
        for (int i = 0; i < pastMoods.size()-1 ; i++) {
            moodHistoryStringBuilder.append(pastMoods.get(i));
            moodHistoryStringBuilder.append("\n");
            Log.w(MH, pastMoods.get(i));
        }
        Log.w(MH,"Setting text");
        display.setText(moodHistoryStringBuilder.toString());
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


}
