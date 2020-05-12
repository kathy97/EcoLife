package com.example.ecolife.database;

import android.app.ProgressDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.ecolife.Calendar.SingleDateActivity;
import com.example.ecolife.MainActivity;
import com.example.ecolife.otherClasses.Languages;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GetDoneHabits extends AsyncTask<String, String, List<String>>
{
    /**Defines all private definitions*/

    private SingleDateActivity singleDateActivity;
    private String Date;
    public List<String> myHabits = new ArrayList<>();

    private ProgressDialog progress;


    /**Is the method that is called in Activity
     * sets the transferred parameters to the defined ones*/
    public  GetDoneHabits( SingleDateActivity singleDateActivity, String Date)
    {
        this.singleDateActivity = singleDateActivity;
        this.Date = Date;
    }

    /**Before Database stuff is about to be done, this will show a progress dialog along with a message,
     * so the user will know that loading  will take a moment of time.*/
    @Override
    protected void onPreExecute()
    {
        progress = ProgressDialog.show(singleDateActivity, Languages.get("pleaseWaitProgressTitle"), Languages.get("pleaseWaitProgressMessage"));
    }


    /**Does the database stuff in background*/
    @Override
    protected List<String> doInBackground(String... strings)
    {


        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SQLiteDatabase DB = MainActivity.database.getWriteableDb();
        Cursor cursor = DB.rawQuery("SELECT HabitName FROM DoneHabits WHERE HabitDatum= '"+this.Date+"';",null);
        Boolean exist = cursor.moveToFirst();
        Log.d("Exist", String.valueOf(exist));
        if (exist){
            do {
                String habit = cursor.getString(cursor.getColumnIndex("HabitName"));
                myHabits.add(habit);
                //Log.d("test", String.valueOf(cursor.moveToNext()));

                System.out.println("DoneHabit "+ habit);
            }while(cursor.moveToNext());
        }

        return myHabits;

    }

    /**Does this after the db stuff is done*/
    @Override
    protected void onPostExecute(List<String> strings)
    {
        /*The progress message will be dismissed*/
        progress.dismiss();

        /*If list myHabits is not empty the function setVisible sets the transferred strings in singleDateActivity on visible
        * else The user will get an alert that he/she had not done any habits this day.*/
        if(myHabits.isEmpty())
        {
            singleDateActivity.noDoneHabitsThisDay();
        }
        else
        {
            singleDateActivity.setVisible(strings);
        }

    }


}
