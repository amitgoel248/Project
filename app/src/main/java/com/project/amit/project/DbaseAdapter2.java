package com.project.amit.project;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by pulkit on 07-03-2015.
 */

public class DbaseAdapter2 {
    Dbasehelper helper;

    public DbaseAdapter2(Context context){
        helper=new Dbasehelper(context);
    }
//    public String getAllData(int UID){
//        SQLiteDatabase db = helper.getWritableDatabase();
//
//        String[] columns = {Dbasehelper.UID,Dbasehelper.NAME};
//        Cursor cursor = db.query(Dbasehelper.TABLE_NAME, columns, Dbasehelper.UID+"='"+UID+"'", null, null, null, null);
//        StringBuffer buffer = new StringBuffer();
//        while (cursor.moveToNext()) {
//            int index1 = cursor.getColumnIndex(Dbasehelper.UID);
//            int index2 = cursor.getColumnIndex(Dbasehelper.NAME);
//            int cid = cursor.getInt(index1);
//            String des = cursor.getString(index2);
//            buffer.append(cid + " " + des + "\n");
//        }
//        return buffer.toString();
//    }


    public String getData(int UID)
    {
        SQLiteDatabase db = helper.getWritableDatabase();

        String[] columns = {Dbasehelper.UID,Dbasehelper.NAME};
        Cursor cursor = db.query(Dbasehelper.TABLE_NAME, columns, Dbasehelper.UID+"='"+UID+"'", null, null, null, null);
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()) {
            int index1 = cursor.getColumnIndex(Dbasehelper.UID);
            int index2 = cursor.getColumnIndex(Dbasehelper.NAME);
            int cid = cursor.getInt(index1);
            String des = cursor.getString(index2);
            buffer.append(des);
        }
        return buffer.toString();
    }
    public String getString(int UID)
    {
        SQLiteDatabase db = helper.getWritableDatabase();

        String[] columns = {Dbasehelper.UID,Dbasehelper.NAME};
        Cursor cursor = db.query(Dbasehelper.TABLE_NAME, columns, Dbasehelper.UID+"='"+UID+"'", null, null, null, null);
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()) {
            int index1 = cursor.getColumnIndex(Dbasehelper.UID);
            int index2 = cursor.getColumnIndex(Dbasehelper.NAME);
            int cid = cursor.getInt(index1);
            String des = cursor.getString(index2);
            buffer.append(des);
        }
        return buffer.toString();
    }



    static class Dbasehelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "testdatabase";
        private static final String DB_PATH = "/data/data/com.project.amit.project/databases/";
        private static final String TABLE_NAME = "Tips";
        private static final int DATABASE_VERSION = 31;
        private static final String UID = "_id";
        //private static final String LINK = "link";
        private static final String NAME = "Description";
        private Context context;
        private SQLiteDatabase myDataBase;

        //private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " VARCHAR(1000));";

        public Dbasehelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
            //Message.message(context, "CONSTRUCTOR called");
        }

        public void createDataBase() throws IOException {
            boolean dbExist = checkDataBase();
            if (dbExist) {
                //do nothing - database already exist
            }
            else {
                //By calling this method and empty database will be created into the default system path
                //of your application so we are gonna be able to overwrite that database with our database.
                this.getReadableDatabase();
                try {
                    copyDataBase();
                } catch (IOException e) {
                    throw new Error("Error copying database");
                }
            }
        }

        private boolean checkDataBase() {
            SQLiteDatabase checkDB = null;
            try {
                String myPath = DB_PATH + DATABASE_NAME;
                checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
            } catch (SQLiteException e) {
                //database does't exist yet.
            }
            if (checkDB != null) {
                checkDB.close();
            }
            return ((checkDB != null) ? true : false);
        }

        private void copyDataBase() throws IOException {
            //Open your local db as the input stream
            InputStream myInput = context.getAssets().open(DATABASE_NAME);
            // Path to the just created empty db
            String outFileName = DB_PATH + DATABASE_NAME;
            //Open the empty db as the output stream
            OutputStream myOutput = new FileOutputStream(outFileName);
            //transfer bytes from the inputfile to the outputfile
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            //Close the streams
            myOutput.flush();
            myOutput.close();
            myInput.close();
        }

        public void openDataBase() throws java.sql.SQLException {
            //Open the database
            String myPath = DB_PATH + DATABASE_NAME;
            myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        }

        @Override
        public synchronized void close() {
            if (myDataBase != null)
                myDataBase.close();
            super.close();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //nothing in here
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //No need of updating
        }
    }

}
