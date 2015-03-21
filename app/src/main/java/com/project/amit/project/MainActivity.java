package com.project.amit.project;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.Toolbar;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;


public class MainActivity extends ActionBarActivity {

    private PendingIntent pendingIntent;
    private AlarmManager manager;
    public static int pass=0;

    private android.support.v7.widget.Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(pass==0)
        startActivity(new Intent(this,tips.class));

        Intent alarmIntent = new Intent(this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0);

        toolbar =(android.support.v7.widget.Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       NavigationDrawerFragment drawerFragment =(NavigationDrawerFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setup(R.id.fragment_navigation_drawer,(DrawerLayout)findViewById(R.id.drawer_layout), toolbar);
         pass=1;

    }

    public void onSaveInstanceState(Bundle savedInstanceState) {

        pass=1;
        super.onSaveInstanceState(savedInstanceState);

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

        return super.onOptionsItemSelected(item);
    }


    public void startAlarm(View view) {
        manager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        int interval = 120000; // 120 seconds

        manager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pendingIntent);
        Toast.makeText(this, "Notifications Enabled", Toast.LENGTH_SHORT).show();
    }

    public void cancelAlarm(View view) {
        if (manager != null) {
            manager.cancel(pendingIntent);
            Toast.makeText(this, "Notifications Disabled", Toast.LENGTH_SHORT).show();
        }
    }


}
