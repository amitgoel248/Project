package com.project.amit.project;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;
import java.sql.SQLException;


public class home extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar=(Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        TextView tt2 = (TextView)findViewById(R.id.tt2);
        TextView tt3 = (TextView)findViewById(R.id.tt3);
        TextView tt4 = (TextView)findViewById(R.id.tt4);
        TextView tt5 = (TextView)findViewById(R.id.tt5);
        TextView tt6 = (TextView)findViewById(R.id.tt6);
        TextView tt7 = (TextView)findViewById(R.id.tt7);
        TextView tt8 = (TextView)findViewById(R.id.tt8);
        TextView tt9 = (TextView)findViewById(R.id.tt9);
        TextView tt10 = (TextView)findViewById(R.id.tt10);
        TextView tt11 = (TextView)findViewById(R.id.tt11);
        TextView tt12 = (TextView)findViewById(R.id.tt12);
        TextView tt13 = (TextView)findViewById(R.id.tt13);
        tt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.codechef.com/help"));
                startActivity(intent);
            }
        });
        tt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=math_for_topcoders"));
                startActivity(intent);
            }
        });
        tt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=standardTemplateLibrary"));
                startActivity(intent);
            }
        });
        tt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=importance_of_algorithms"));
                startActivity(intent);
            }
        });
        tt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=primalityTesting"));
                startActivity(intent);
            }
        });
        tt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.codechef.com/wiki/tutorial-number-theory"));
                startActivity(intent);
            }
        });
        tt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=dynProg"));
                startActivity(intent);
            }
        });
        tt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=greedyAlg"));
                startActivity(intent);
            }
        });
        tt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=algorithmGames"));
                startActivity(intent);
            }
        });
        tt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=graphsDataStrucs1"));
                startActivity(intent);
            }
        });
        tt12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=bitManipulation"));
                startActivity(intent);
            }
        });
        tt13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.topcoder.com/tc?d1=tutorials&d2=lowestCommonAncestor&module=Static"));
                startActivity(intent);
            }
        });





    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
