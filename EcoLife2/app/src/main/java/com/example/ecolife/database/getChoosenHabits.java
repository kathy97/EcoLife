package com.example.ecolife.database;

import android.app.ProgressDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;

import com.example.ecolife.MainActivity;
import com.example.ecolife.MyHabitsActivity;
import com.example.ecolife.otherClasses.Languages;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class getChoosenHabits extends AsyncTask<String, String, List<String>>
{
    /**Defines all private definitions*/

    public List<String>myHabits = new ArrayList<>();
    private MyHabitsActivity activity;
    private ProgressDialog progress;

    /**Is the method that is called in Activity
     * sets the transferred parameters to the defined ones*/
    public getChoosenHabits( MyHabitsActivity activity)
    {

        this.activity = activity;
    }

    /**Before Database stuff is about to be done, this will show a progress dialog along with a message,
     * so the user will know that loading  will take a moment of time.*/
    @Override
    protected void onPreExecute() {
        progress = ProgressDialog.show(activity, Languages.get("pleaseWaitProgressTitle"), Languages.get("pleaseWaitProgressMessage"));
    }


    /**Does the database stuff in background*/
    @Override
    protected List<String> doInBackground(String... strings)
    {
        SQLiteDatabase DB = MainActivity.database.getWriteableDb();
        Cursor cursor = DB.rawQuery("SELECT barname FROM Habits;",null);
        Boolean exist = cursor.moveToFirst();

        if (exist){
            do {
                myHabits.add(cursor.getString(cursor.getColumnIndex("barName")));
            }while(cursor.moveToNext());
        }

        return myHabits;



    }

    /**Does this after the db stuff is done*/
    @Override
    protected void onPostExecute(List<String> strings)
    {
        /*Progress message will be dismissed*/
        progress.dismiss();
        /*Transfers the strings out of the list to the activity which belongs to this class and
        *makes them visible there*/

        if(myHabits.isEmpty())
        {
            activity.noHabits();
        }
        else
        {
            activity.setVisible(strings);
        }



    }
}
