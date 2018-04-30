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

public class QuoteResponse extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private String QR = "QuoteResponse";
    private ArrayList<String> quotes;
    private TextView quote;
    private Random rand;
    protected BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.w(QR, "on top of onCreate");
        super.onCreate(savedInstanceState);
        quotes = getIntent().getExtras().getStringArrayList("quotes");

        Log.w(QR, "Creating layout");
        buildGUI();

        Log.w(QR, "Nav bar");
        navigationView = findViewById(R.id.navigationView);
        navigationView.setOnNavigationItemSelectedListener(this);
    }
    public void buildGUI(){
        Log.w(QR, "Inside buildGui");
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
        Log.w(QR, "Nav bar action");
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
