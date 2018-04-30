package com.example.jeffreyboudreaux.moodapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class QuoteResponse extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private TextView quote;
    private Random rand;
    private ArrayList<String> quotes;
    protected BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        navigationView = findViewById(R.id.navigationView);
        navigationView.setOnNavigationItemSelectedListener(this);

        super.onCreate(savedInstanceState);
        quotes = getIntent().getExtras().getStringArrayList("quotes");
        buildGUI();
    }
    public void buildGUI(){
        RelativeLayout quoteScreen = new RelativeLayout(this);
        rand = new Random();
        quote = new TextView(this);
        quote.setText(quotes.get(rand.nextInt(quotes.size())));
        quote.setX(500);
        quote.setY(500);
        quoteScreen.addView(quote);
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

}
