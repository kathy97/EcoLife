package com.example.ecolife.database;

import android.app.ProgressDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;

import com.example.ecolife.MainActivity;
import com.example.ecolife.home.HomeActivity;
import com.example.ecolife.otherClasses.Languages;

import java.sql.ResultSet;

public class GetCalendarView extends AsyncTask<String,String, String>
{

    /**Defines all private definitions*/
    private String calendarView;
    private HomeActivity homeActivity;
    private ProgressDialog progress;

    /**Is the method that is called in Activity
     * sets the transferred parameters to the defined ones*/
    public GetCalendarView( HomeActivity homeActivity)
    {
        this.homeActivity = homeActivity;
    }

    @Override
    protected void onPreExecute() {
        progress = ProgressDialog.show(homeActivity, Languages.get("pleaseWaitProgressTitle"), Languages.get("pleaseWaitProgressMessage"));
    }

    /**Does the database stuff in background*/
    @Override
    protected String doInBackground(String... strings)
    {
        SQLiteDatabase DB = MainActivity.database.getWriteableDb();
        Cursor cursor = DB.rawQuery("SELECT CalendarView FROM Userdata;",null);
        Boolean exist = cursor.moveToFirst();

        if (exist){
            do {
                calendarView = cursor.getString(cursor.getColumnIndex("CalendarView"));
            }while(cursor.moveToNext());
            return "found";
        }
        else{
            return "failed";
        }

    }

    /**Does this after the db stuff is done*/
    @Override
    protected void onPostExecute(String s)
    {
        progress.dismiss();
        /*if the string s is equal to found, the calendar view will be transferred to home Activity where calendar view gets set then
        * Else if s is equal to failed, Month is getting transferred to homeActivity and set as the Monthly calendar view then*/
        if(s.equalsIgnoreCase("found"))
        {
            Log.d("calendarView", ""+ calendarView);
           homeActivity.cViewFound(calendarView);
        }
        else if(s.equalsIgnoreCase("failed"))
        {
            homeActivity.cViewFound("Month");
        }

    }
}
