package com.example.jeffreyboudreaux.moodapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        BottomNavigationView toolbar = (BottomNavigationView) findViewById(R.id.navigationView);
        

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.nav_addRecord:
                Intent insertIntent = new Intent(this, RecordMoodActivity.class);
                this.startActivity(insertIntent);
                return true;
            case R.id.nav_viewRecords:
                Intent historyIntent = new Intent(this, MoodHistory.class);
                this.startActivity(historyIntent);
                return true;
            case R.id.nav_homepage:
                Intent mainIntent = new Intent(this, MainActivity.class);
                this.startActivity(mainIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
