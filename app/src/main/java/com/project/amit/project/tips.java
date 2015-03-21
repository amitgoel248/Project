package com.project.amit.project;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.sql.SQLException;


public class tips extends ActionBarActivity {


    DbaseAdapter2 dbasehelper;
    DbaseAdapter2.Dbasehelper helper;
    public static int value=0;


    public void viewDetails(View view) {
        int i = 1;
        int counter = getvalue();
        while (counter != 0) {
            counter--;
            i++;
        }
        String data = dbasehelper.getData(i);
        TextView et = (TextView) findViewById(R.id.tipstext);
        et.setText(data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        dbasehelper = new DbaseAdapter2(this);
        helper = new DbaseAdapter2.Dbasehelper(this);
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

        Button bt=(Button)findViewById(R.id.go);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(tips.this , MainActivity.class));
            }
        });
    }

    protected void onResume() {
        super.onResume();
        value++;
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
