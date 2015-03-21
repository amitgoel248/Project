package com.project.amit.project;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class question extends ActionBarActivity {
    public static TextView tv;
    public static TextView tv1;
    public static TextView tv2;
    public static int pica[]= new int[10];
    public static int t=0;
    public static int l=0;
    public static int pica2[]= new int[10];
    public static int t2=0;
    public static int l2=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        tv  = (TextView)findViewById(R.id.nm3);
        tv.setText(Notifications.s1);
        tv1  = (TextView)findViewById(R.id.nm5);
        tv1.setText(Notifications.s2);
        tv2  = (TextView)findViewById(R.id.nm7);
        tv2.setText(Notifications.s3);
        Button btn = (Button)findViewById(R.id.bt8);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 pica[t]=Notifications.i;
                 t++;
                 l=pica.length;
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question, menu);
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
