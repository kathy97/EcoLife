package com.example.ecolife.otherClasses;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.example.ecolife.MainActivity;


public class Notification_reciever extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent repeating_intent = new Intent(context, MainActivity.class /* Hier die Klasse angeben, die aufgerufen werden soll, wenn man auf die Benachrichtigung klickt  */);

        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 100, repeating_intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "default")
                .setContentIntent(pendingIntent)
                .setSmallIcon(android.R.drawable.arrow_up_float) //hier das Logo der Benachrichtigung - kann man eigentlich so lassen
                .setContentTitle(Languages.get("title")) //hier der "Titel", also obere Zeile der Nachricht
                .setContentText(Languages.get("content")) //untere Zeile der Nachricht
                .setAutoCancel(true);

        if (intent.getAction().equals("MY_NOTIFICATION_MESSAGE")) {
            notificationManager.notify(100,builder.build());
        }
    }
}
