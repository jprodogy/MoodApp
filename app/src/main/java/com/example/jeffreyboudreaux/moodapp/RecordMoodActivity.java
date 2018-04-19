package com.example.jeffreyboudreaux.moodapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.FileNotFoundException;

/**
 * Created by jeffreyboudreaux on 4/10/18.
 */

public class RecordMoodActivity extends AppCompatActivity {
    private Encouragements Enc;
    Button[] btns = new Button[9];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record_mood_activity);
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
        btns[0] = (Button) findViewById(R.id.happyButton);
        btns[1] = (Button) findViewById(R.id.sadButton);
        btns[2] = (Button) findViewById(R.id.angryButton);
        btns[3] = (Button) findViewById(R.id.tiredButton);
        btns[4] = (Button) findViewById(R.id.stressedButton);
        btns[5] = (Button) findViewById(R.id.depressedButton);
        btns[6] = (Button) findViewById(R.id.nervousButton);
        btns[7] = (Button) findViewById(R.id.confusedButton);
        btns[8] = (Button) findViewById(R.id.mellowButton);

        try {
            Enc = new Encouragements();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void MoodSelect(View v){
        for (int i = 0; i < btns.length; i++) {
            if (v == btns[i]){
                Enc.getEnc(i);
            }
        }
    }


}

