package com.example.ecolife.otherClasses;

import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import com.example.ecolife.MyHabitsActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class UncheckCheckboxes extends AsyncTask<String,String, Boolean>
{
    @Override
    protected Boolean doInBackground(String... strings)
    {
         /*
        final Handler handler = new Handler();
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                handler.post((new Runnable() {
                    @Override
                    public void run() {
                        Calendar cal = Calendar.getInstance();
                        SimpleDateFormat uhrzeit = new SimpleDateFormat("HH:mm", Locale.GERMANY);
                        String time = uhrzeit.format(cal.getTime());

                        Log.d("uhrzeit", uhrzeit.format(cal.getTime()));
                        Log.d("zeit", time);

                        if (time.equalsIgnoreCase("09:30"))
                        {
                            MyHabitsActivity.uncheckCheckBoxes(MyHabitsActivity.habitsMap);
                        }
                    }
                }));
            }
        };


        timer.schedule(new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat uhrzeit = new SimpleDateFormat("HH:mm", Locale.GERMANY);
                String time = uhrzeit.format(cal.getTime());

                Log.d("uhrzeit", uhrzeit.format(cal.getTime()));
                Log.d("zeit", time);

                if (time.equalsIgnoreCase("08:45"))
                {
                    MyHabitsActivity.uncheckCheckBoxes(MyHabitsActivity.habitsMap);
                }
            }

        }, 60000);
*/
        return null;
    }
}
