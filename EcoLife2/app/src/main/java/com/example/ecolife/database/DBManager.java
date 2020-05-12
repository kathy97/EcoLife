package com.example.ecolife.database;

import android.content.Context;
import android.database.Cursor;

public class DBManager
{
    /**Defines a local database with the name database*/
    private static LocalDatabase database;

    /**Creates the local database*/
    public static void createDatabase(Context context) {
        database = new LocalDatabase(context);
    }

    /**Function saveUser will be called in LogInActivity and mail + password will be saved in db
     * As  mail the user will enter his/her username*/
    public static void saveUser(String mail, String passwort) {
        database.getWriteableDb().execSQL("DELETE FROM Benutzer");
        database.getWriteableDb().execSQL("INSERT INTO Benutzer VALUES ('" + mail + "', '" + passwort + "')");
    }

    /**Function unsafeUser will Delete user from local db*/
    public static void unsafeUser() {
        database.getWriteableDb().execSQL("DELETE FROM Benutzer");
    }

    /**Function checks if user is saved*/
    public static boolean isSavedUser() {
        Cursor cursor = database.getReadableDb().rawQuery("SELECT * FROM Benutzer", null);

        return cursor.moveToFirst();
    }

    /**Is a function to get database which returns the db*/
    public static LocalDatabase getDatabase() {
        return database;
    }



}
