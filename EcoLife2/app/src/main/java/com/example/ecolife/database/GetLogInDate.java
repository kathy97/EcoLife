package com.example.ecolife.database;

import android.app.ProgressDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import com.example.ecolife.MainActivity;
import com.example.ecolife.home.HomeActivity;
import com.example.ecolife.otherClasses.Languages;

import java.util.ArrayList;
import java.util.List;

public class GetLogInDate extends AsyncTask<String, String, String>
{


    private String datum;
    private ProgressDialog progress;
    private HomeActivity homeActivity;

    public GetLogInDate( HomeActivity homeActivity, String datum)
    {

        this.datum = datum;
        this.homeActivity = homeActivity;
    }

    @Override
    protected void onPreExecute() {
        progress = ProgressDialog.show(homeActivity, Languages.get("pleaseWaitProgressTitle"), Languages.get("pleaseWaitProgressMessage"));
    }

    @Override
    protected String doInBackground(String... strings)
    {

        SQLiteDatabase DB = MainActivity.database.getWriteableDb();
        Cursor cursor = DB.rawQuery("SELECT LogInDate FROM Userdata;",null);
        Boolean exist = cursor.moveToFirst();

        if (exist){
            do {
                datum = cursor.getString(cursor.getColumnIndex("LogInDate"));
                //Log.d("test", String.valueOf(cursor.moveToNext()));


            }while(cursor.moveToNext());
        }
        return datum;
    }

    @Override
    protected void onPostExecute(String strings) {
        progress.dismiss();
        homeActivity.getDate(datum);
    }
}

