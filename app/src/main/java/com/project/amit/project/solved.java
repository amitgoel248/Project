package com.project.amit.project;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;


public class solved extends ActionBarActivity {

    DbaseAdapter dbasehelper;
    DbaseAdapter.Dbasehelper helper;
    public static int value=0;
    public static int i=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar=(Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

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
        TextView et = (TextView)findViewById(R.id.ig2);
        for(int k=0;k<question.l2;k++)
        {
            String data = dbasehelper.getData(question.pica2[k]);
            et.append(data);
            et.append("\n");
        }

    }
    protected void onResume() {
        super.onResume();
        value++;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
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
