package com.example.jeffreyboudreaux.moodapp;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.FileNotFoundException;

public class PersonalFeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        TextView encTxt = (TextView) findViewById(R.id.encouragementView);
        TextView feeTxt = (TextView) findViewById(R.id.feedbackView);

        try {
            String d = RecordMoodActivity.enc.getEnc();
            encTxt.setText(d);
            Log.w("MainActivity","created Encouragements & Feedback");

        }catch (NullPointerException npe){
            Log.w("PersonalFeedbackActvity", "It did not work");
        }
    }
}
