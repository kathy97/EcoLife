package com.example.ecolife.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;

import com.example.ecolife.MainActivity;
import com.example.ecolife.home.HomeActivity;

import java.sql.ResultSet;

public class AddLogInDate extends AsyncTask<String, String, Boolean>
{


    private String datum;


    public AddLogInDate(String datum)
    {
        this.datum = datum;
    }



    @Override
    protected Boolean doInBackground(String... strings)
    {
        SQLiteDatabase DB = MainActivity.database.getWriteableDb();
        Cursor cursor = DB.rawQuery("SELECT LogInDate FROM Userdata WHERE LogInDate ='"+this.datum+"';",null);
        Boolean exist = cursor.moveToFirst();

        if (exist){
            do {
                cursor.getString(cursor.getColumnIndex("LogInDate"));
            }while(cursor.moveToNext());
        }

        if(!exist)
        {
            DB.execSQL("UPDATE Userdata SET LogInDate= '"+this.datum+"';");
            return true;
        }
        else
        {
            return false;
        }

    }


}
