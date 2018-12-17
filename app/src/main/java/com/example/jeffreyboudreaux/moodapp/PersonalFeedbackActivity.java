package com.example.jeffreyboudreaux.moodapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
            encTxt.setText(RecordMoodActivity.enc.getEnc());
            feeTxt.setText(RecordMoodActivity.fee.getFeed());

            Log.w("MainActivity","created Encouragements & Feedback");

        }catch (NullPointerException npe){
            Log.w("PersonalFeedbackActvity", "It did not work");
        }
    }

    /*
    @Override
    public boolean onNavigationItemSelect(@NonNull MenuItem item) {
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
    */
}
