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
    public static Mood moo;
    RadioButton[] btns = new RadioButton[9];

    public ArrayList<String> pastMoods;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_mood);
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
            Log.w("MainActivity", "created Encouragements & Feedback");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void MoodSelect(View v) throws InvocationTargetException {
        for (int i = 0; i < btns.length; i++) {
            if (btns[i].isChecked()){
                Log.w("MainActivity", String.valueOf(i));
                moo.addMood(i);
                enc.setEnc(i);
                fee.setFeed(i);
                Intent PersonalFeedBackIntent = new Intent(this, PersonalFeedbackActivity.class);
                /*
                Intent history = new Intent(this, MoodHistory.class);
                ArrayList<String> pastMoods = getIntent().getExtras().getStringArrayList("pastMoods");
                history.putStringArrayListExtra("pastMoods", pastMoods);*/

                pastMoods = MainActivity.pastMoods;
                pastMoods.add(String.valueOf(btns[i]));

                this.startActivity(PersonalFeedBackIntent);
            }
        }



    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.happyButton:
                if (checked)
                    for (int i = 0; i < btns.length; i++) {
                        if (btns[0] != btns[i]){
                            btns[i].setChecked(false);
                            Log.w("MainActivity", "It worked");
                        }
                    }
                    break;
            case R.id.sadButton:
                if (checked)
                    if (checked)
                        for (int i = 0; i < btns.length; i++) {
                            if (btns[1] != btns[i]){
                                btns[i].setChecked(false);
                            }
                        }
                    break;
            case R.id.angryButton:
                if (checked)
                    if (checked)
                        for (int i = 0; i < btns.length; i++) {
                            if (btns[2] != btns[i]){
                                btns[i].setChecked(false);
                            }
                        }
                    break;
            case R.id.tiredButton:
                if (checked)
                    if (checked)
                        for (int i = 0; i < btns.length; i++) {
                            if (btns[3] != btns[i]){
                                btns[i].setChecked(false);
                            }
                        }
                    break;
            case R.id.stressedButton:
                if (checked)
                    if (checked)
                        for (int i = 0; i < btns.length; i++) {
                            if (btns[4] != btns[i]){
                                btns[i].setChecked(false);
                            }
                        }
                    break;
            case R.id.depressedButton:
                if (checked)
                    if (checked)
                        for (int i = 0; i < btns.length; i++) {
                            if (btns[5] != btns[i]){
                                btns[i].setChecked(false);
                            }
                        }
                    break;
            case R.id.nervousButton:
                if (checked)
                    if (checked)
                        for (int i = 0; i < btns.length; i++) {
                            if (btns[6] != btns[i]){
                                btns[i].setChecked(false);
                            }
                        }
                    break;
            case R.id.confusedButton:
                if (checked)
                    if (checked)
                        for (int i = 0; i < btns.length; i++) {
                            if (btns[7] != btns[i]){
                                btns[i].setChecked(false);
                            }
                        }
                    break;
            case R.id.mellowButton:
                if (checked)
                    if (checked)
                        for (int i = 0; i < btns.length; i++) {
                            if (btns[8] != btns[i]){
                                btns[i].setChecked(false);
                            }
                        }
                    break;
        }
    }



}

