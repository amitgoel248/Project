package com.project.amit.project;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by pulkit on 07-03-2015.
 */
public class Message {
    public static void message(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
}
