package com.example.ecolife.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import androidx.appcompat.app.AlertDialog;

import com.example.ecolife.MainActivity;
import com.example.ecolife.menu.HabitsActivity;

import java.sql.ResultSet;

public class JoinHabit extends AsyncTask<String, String, String>
{
    /**Defines all private definitions*/
    private String HabitName;
    private String germanHabitName;
    private String barName;
    private HabitsActivity habitsActivity;

    /**Is the method that is called in Activity
     * sets the transferred parameters to the defined ones*/
    public JoinHabit( String HabitName, String germanHabitName, String barName, HabitsActivity habitsActivity)
    {
        this.HabitName = HabitName;
        this.germanHabitName = germanHabitName;
        this.habitsActivity = habitsActivity;
        this.barName =  barName;
    }

    /**Does the database stuff in background*/
    @Override
    protected String doInBackground(String... strings)
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
            return "succeed";
        }
        else
        {
            return "exists";
        }

    }

    /**Does this after the db stuff is done*/
    @Override
    protected void onPostExecute(String s)
    {

        /*If String s is equal to succeed the function AddingHabitSucceed in HabitsActivity will be used and user gets an alert to know that he had joined this habit
        * Else If s is equal to failed the function AddingHabitFailed in HabitsActivity will be used and user gets an alert to know that he had not been able to join habit now
        * Else If s is equal to exists the function AlreadyJoined in HabitsActivity will be used and user gets an alert that he already joined the habit*/
        if(s.equalsIgnoreCase("succeed"))
        {
            habitsActivity.AddingHabitSucceed();
        }
        else if(s.equalsIgnoreCase("exists"))
        {
            habitsActivity.AlreadyJoined();
        }
    }

}
