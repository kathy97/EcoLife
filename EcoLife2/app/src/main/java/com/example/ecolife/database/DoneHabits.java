package com.example.ecolife.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import com.example.ecolife.MainActivity;
import com.example.ecolife.MyHabitsActivity;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class DoneHabits extends AsyncTask<String,String, Boolean>
{
    /**Defines all private definitions*/
    private String date;
    private String habit;

    /**Is the method that is called in Activity
     * sets the transferred parameters to the defined ones*/
    public DoneHabits(String date, String habit)
    {
        this.date = date;
        this.habit = habit;
    }

    /**Does the database stuff in background*/
    @Override
    protected Boolean doInBackground(String... strings)
    {
        SQLiteDatabase DB = MainActivity.database.getWriteableDb();
        Cursor cursor = DB.rawQuery("SELECT HabitName FROM DoneHabits WHERE HabitDatum ='"+this.date+"' AND HabitName='"+this.habit+"';",null);
        Boolean exist = cursor.moveToFirst();


        if(!exist)
        {
            DB.execSQL("INSERT INTO DoneHabits(HabitName,HabitDatum) VALUES ('"+this.habit+"','"+ this.date+"')");
            return true;
        }
        else
        {
            return false;
        }

    }

}
