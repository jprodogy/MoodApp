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
import java.util.Random;

public class QuoteResponse extends AppCompatActivity {

    private TextView quote;
    private Random rand;
    private ArrayList<String> quotes;

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
        /*in the selection activity, the arraylist of quotes associated with this mood need to be
        sent to the intent under the name "quotes"
         */
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

}
