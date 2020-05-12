package com.example.ecolife.database;

import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import com.example.ecolife.MainActivity;

public class ChangeCalendarView extends AsyncTask<String, String,String>
{
    /**Defines all private definitions*/
    private String cView;

    /**Is the method that is called in Activity
     * sets the transferred parameters to the defined ones*/
    public ChangeCalendarView( String cView)
    {
     this.cView = cView;
    }

    /**Does the database stuff in background*/
    @Override
    protected String doInBackground(String... strings)
    {

        SQLiteDatabase DB = MainActivity.database.getWriteableDb();
        DB.execSQL("UPDATE Userdata SET CalendarView='"+this.cView+"';");
        return "succeed";
    }
}
