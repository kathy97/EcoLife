package com.example.ecolife.database;

import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import com.example.ecolife.MainActivity;

public class FirstCVEntry extends AsyncTask<String, String, Boolean>
{
    private  String date;

    public  FirstCVEntry(String date)
    {
      this.date = date;
    }

    @Override
    protected Boolean doInBackground(String... strings)
    {
        SQLiteDatabase DB = MainActivity.database.getWriteableDb();
        DB.execSQL("INSERT INTO Userdata(CalendarView, LogInDate,InstallDate) VALUES ('Month', '"+this.date+
                "','"+this.date+"');");
        return null;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }
}
