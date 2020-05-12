package com.example.ecolife;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.ecolife.database.FirstCVEntry;
import com.example.ecolife.database.LocalDatabase;
import com.example.ecolife.home.HomeActivity;
import com.example.ecolife.otherClasses.Languages;
import com.example.ecolife.otherClasses.Notification_reciever;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends Activity {

    public static LocalDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = new LocalDatabase(this);
        Languages.setLanguages();
        Languages.setCurrentLanguage(Languages.Lang.GERMAN);



        //region First Start
        SharedPreferences prefs = getSharedPreferences("prefs",MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);
        if (firstStart)
        {
            firstInserts();
        }
        //endregion


        Intent intent = new Intent(this, HomeActivity.class);

        startActivity(intent);
        finish();


        //PUSH-NACHRICHT
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel("default", "Default Channel",
                    NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("Reminder");
            NotificationManager notificationManager = (NotificationManager)
                    getSystemService(NOTIFICATION_SERVICE);
            if (notificationManager != null)
            {
                notificationManager.createNotificationChannel(channel);
            }

        }

        Calendar calendar = Calendar.getInstance();
        //hier Zeit ändern
        // 13 0 0 = 13 Uhr
        calendar.set(Calendar.HOUR_OF_DAY, 18);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 0);


        Intent inteent = new Intent(getApplicationContext(), Notification_reciever.class);
        inteent.setAction("MY_NOTIFICATION_MESSAGE");

        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 100, inteent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY *1
       /*AlarmManager.INTERVAL_DAY bedeutet jeden Tag um die Uhrzeit, die oben eingestellt wurde */ /* AlarmManager.INTERVAL_DAY * 3 bedeutet zum Beispiel jeden 3ten Tag */, pendingIntent);


    }

    /**Makes the first insert into the local userdata database - only when starting app at the first time*/
    public  void firstInserts()
    {
        SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);
        final String dateFormat = date.format(new java.util.Date());

        FirstCVEntry first = new FirstCVEntry(dateFormat);
        first.execute();

        SharedPreferences prefs = getSharedPreferences("prefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();


    }


}
