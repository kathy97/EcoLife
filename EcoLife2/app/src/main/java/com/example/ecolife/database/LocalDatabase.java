package com.example.ecolife.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LocalDatabase extends SQLiteOpenHelper {

    /**is a local db with Eco-Life as name
     * it is the first version*/
    public LocalDatabase(Context context)
    {
        super(context, "Eco-Life", null,1);
    }


    /**onCreate creates a new table called Benutzer (User) if it does not exist
     * in the table we save the mail (or Username) and the password*/
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS Habits (HabitName varchar(255), GermanName varchar(255)" +
                    ", barName varchar(255));");

            //einfach hier neue tabelle erstellen
            db.execSQL("CREATE TABLE IF NOT EXISTS DoneHabits (HabitName varchar(255), HabitDatum varachar(255));");

            db.execSQL("CREATE TABLE IF NOT EXISTS Userdata (CalendarView varchar(255), LogInDate varchar(255), InstallDate varchar(255));");


        }catch (Exception ex) {
            System.out.println("Fehler beim anlegen der Tabelle: " + ex.getMessage());
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    /**Returns a readable db*/
    public SQLiteDatabase getReadableDb() {
        return getReadableDatabase();
    }
    /**Returns a writable db*/
    public SQLiteDatabase getWriteableDb() {
        return getWritableDatabase();
    }
}
