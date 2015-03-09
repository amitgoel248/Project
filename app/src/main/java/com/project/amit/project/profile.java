package com.project.amit.project;

import android.content.Context;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class profile extends ActionBarActivity {
    EditText uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar=(Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        uname=(EditText)findViewById(R.id.edittext);
    }


    public void save (View view) throws FileNotFoundException {
        String text=uname.getText().toString();

        //openFileOutput("UNAME.txt",Context.MODE_PRIVATE);
        File file=getFilesDir();
        FileOutputStream fileOutputStream=openFileOutput("UNAME.txt", Context.MODE_PRIVATE);
        try {
            fileOutputStream.write(text.getBytes());
            //fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, (CharSequence) file.toString(), Toast.LENGTH_SHORT).show();

    }

    public void load(View view){
        FileInputStream fileInputStream=null;
        try {
            fileInputStream=openFileInput("UNAME.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int read=-1;
        StringBuffer buffer=new StringBuffer();
        try {
            //read=fileInputStream.read();
            while((read=fileInputStream.read())!=-1)
                buffer.append((char)read);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, buffer,Toast.LENGTH_SHORT).show();
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
