package com.example.ecolife.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import com.example.ecolife.MainActivity;

public class RemoveHabitFromDone extends AsyncTask <String, String,Boolean>
{
    String date;
    String habit;

    public RemoveHabitFromDone(String date, String habit)
    {
        this.date = date;
        this.habit = habit;
    }
    @Override
    protected Boolean doInBackground(String... strings)
    {
        SQLiteDatabase DB = MainActivity.database.getWriteableDb();
        Cursor cursor = DB.rawQuery("SELECT HabitName FROM DoneHabits WHERE HabitDatum ='"+this.date+"' AND HabitName='"+this.habit+"';",null);
        Boolean exist = cursor.moveToFirst();


        if(exist)
        {
            DB.execSQL("DELETE FROM DoneHabits WHERE HabitName = '"+this.habit+"'AND HabitDatum ='"+ this.date+"';");
            return true;
        }
        else
        {
            return false;
        }


    }
}
