package com.example.ecolife.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import com.example.ecolife.MainActivity;
import com.example.ecolife.menu.HabitsActivity;

import java.sql.ResultSet;

public class JoinHabitFromHabit extends AsyncTask<String, String, Boolean> {
    /**All needed Assignments in private*/

    private String HabitName;
    private String germanHabitName;
    private String barName;

    /**Parameters get transferred from one Activity to this class
     * everything  which is getting transferred is assigned as this*/
    public JoinHabitFromHabit( String HabitName, String germanHabitName, String barName)
    {

        this.HabitName = HabitName;
        this.germanHabitName = germanHabitName;
        this.barName = barName;
    }

    /**Does the database stuff in the background as an async task*/
    @Override
    protected Boolean doInBackground(String... strings)
    {
        SQLiteDatabase DB = MainActivity.database.getWriteableDb();
        Cursor cursor = DB.rawQuery("SELECT barname FROM Habits WHERE barname ='"+this.barName+"';",null);
        Boolean exist = cursor.moveToFirst();

        if (exist){
            do {
                cursor.getString(cursor.getColumnIndex("barName"));
            }while(cursor.moveToNext());
        }

        if(!exist)
        {
            DB.execSQL("INSERT INTO Habits(HabitName,GermanName, barName) VALUES ('"+this.HabitName+"','"+
                    this.germanHabitName+"','"+this.barName+"')");
            return true;
        }
        else
        {
            return false;
        }

    }


}