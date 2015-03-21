package com.project.amit.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.IOException;
import java.sql.SQLException;


public class Notifications extends ActionBarActivity {

    DbaseAdapter dbasehelper;
    DbaseAdapter.Dbasehelper helper;
    public static int value=0;
    public static int cntr=0;
    public static String s1;
    public static String s2;
    public static String s3;
    public static int i=1;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        cntr++;

        dbasehelper =new DbaseAdapter(this);
        helper =new DbaseAdapter.Dbasehelper(this);
        try {
            helper.createDataBase();
        } catch (IOException e) {
            throw new Error("Unable to create database");
        }
        try {
            helper.openDataBase();
        } catch (SQLException e) {
            //
        }
        viewDetails(null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        value++;
    }
    public TextView getTextView()
    {
        TextView tv = (TextView)findViewById(R.id.nm1);
        return tv;
    }

    public void viewDetails(View view){
        i=1;
        int counter=getvalue();
        while(counter!=0){
            counter--;
            i++;
              }
            String data = dbasehelper.getData(i);
            final String data1= dbasehelper.getString(i);
            String data2= dbasehelper.getString1(i);
            TextView et = (TextView)findViewById(R.id.jaja);
            TextView et2 = (TextView)findViewById(R.id.jajaja);
            TextView tt1 = (TextView)findViewById(R.id.jajajaja);
            s1=data;
            s2=data1;
            s3=data2;
            et.setText(data);
            et2.setText(data1);
            tt1.setText(data2);
            et2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(s2));
                startActivity(intent);
            }
        });

    }
    public int getvalue()
    {
      return value;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tips, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id==android.R.id.home)
        {
            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }
}
