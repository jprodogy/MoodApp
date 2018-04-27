package com.example.jeffreyboudreaux.moodapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;

import java.lang.reflect.InvocationTargetException;

public class RecordMoodActivity extends AppCompatActivity {
    public static Encouragements enc;
    public static Feedback fee;
    RadioButton[] btns = new RadioButton[9];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_mood);
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        btns[0] = (RadioButton) findViewById(R.id.happyButton);
        btns[1] = (RadioButton) findViewById(R.id.sadButton);
        btns[2] = (RadioButton) findViewById(R.id.angryButton);
        btns[3] = (RadioButton) findViewById(R.id.tiredButton);
        btns[4] = (RadioButton) findViewById(R.id.stressedButton);
        btns[5] = (RadioButton) findViewById(R.id.depressedButton);
        btns[6] = (RadioButton) findViewById(R.id.nervousButton);
        btns[7] = (RadioButton) findViewById(R.id.confusedButton);
        btns[8] = (RadioButton) findViewById(R.id.mellowButton);


        try {
            enc = new Encouragements(this);
            fee = new Feedback(this);
            Log.w("MainActivity","created Encouragements & Feedback");
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.RDgroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if (group. == true)
                group.clearCheck();
            }
        });
        */
    }

    /*
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
        if (id == R.id.action_record) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    public void MoodSelect(View v) throws InvocationTargetException {
        for (int i = 0; i < btns.length; i++) {
            if (btns[i].isChecked()){
                Log.w("MainActivity", String.valueOf(i));
                enc.setEnc(i);
                fee.setFeed(i);
                Intent myIntent = new Intent(this, PersonalFeedbackActivity.class);
                Intent history = new Intent(this, MoodHistory.class);
                ArrayList<String> pastMoods = getIntent().getExtras().getStringArrayList("pastMoods");
                //HERE IS WHERE WE ADD THE THING
                history.putStringArrayListExtra("pastMoods", pastMoods);
                this.startActivity(myIntent);
            }
        }



    }




}

