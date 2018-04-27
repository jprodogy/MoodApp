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
import android.widget.RadioButton;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class RecordMoodActivity extends AppCompatActivity {
    public static Encouragements enc;
    public static Feedback fee;
    RadioButton[] btns = new RadioButton[9];

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
            Log.w("MainActivity","created Encouragements & Feedback");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void MoodSelect(View v){
        for (int i = 0; i < btns.length - 1; i++) {
            if (btns[i].isChecked()){
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

