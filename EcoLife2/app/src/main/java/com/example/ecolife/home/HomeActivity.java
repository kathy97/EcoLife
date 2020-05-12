package com.example.ecolife.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.ecolife.Calendar.CalendarActivity;
import com.example.ecolife.Calendar.SingleDateActivity;
import com.example.ecolife.MyHabitsActivity;
import com.example.ecolife.database.ChangeCalendarView;
import com.example.ecolife.database.GetCalendarView;
import com.example.ecolife.database.GetLogInDate;
import com.example.ecolife.menu.HabitsActivity;
import com.example.ecolife.menu.ImprintActivity;
import com.example.ecolife.menu.LanguageActivity;
import com.example.ecolife.R;
import com.example.ecolife.otherClasses.Languages;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity {

    /**
     * Defines different buttons, editTexts and variables (static and non static), such as finals
     */
    //region Buttons, Variablen und co
    FloatingActionButton drpdwn;
    CalendarView calendarV;
    Button changeCView;
    Button mHabits;
    TextView dayOfWeek;
    TextView dayOfMonth;
    TextView year_;
    TextView month;

    final HomeActivity homeActivity = this;
    int selected_year = -1;
    int selected_month = -1;
    int selected_day = -1;

    String weekday;
    String dateOfMonth;
    String Year;
    String Month;
    LinearLayout singleDay;
    String content;

    public static List<String> LoggedInDates;
    public static String Date__;
    public static String currentDate_;

    public static String path;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /*Contains all the assignments from Buttons, TextEdits etc.*/
        //region Zuweisungen
        drpdwn = findViewById(R.id.dropdownmenu);
        calendarV = findViewById(R.id.calendar);
        changeCView = findViewById(R.id.changeCV);
        mHabits = findViewById(R.id.myHabits);

        dayOfWeek = findViewById(R.id.weekday);
        dayOfMonth = findViewById(R.id.dayOfMonth);
        year_ = findViewById(R.id.year);
        month = findViewById(R.id.month);
        singleDay = findViewById(R.id.singleDay);
        //endregion

        /*the current date as a single calendar sheet*/
        //region Single Day calendarView

        /*gets the current day from the calendar instance*/
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        /*In the switch case the weekday got his name in german or english*/
        //region Name of weekday
        switch (day) {
            case Calendar.SUNDAY:
                weekday = Languages.get("sunday");
                break;
            case Calendar.MONDAY:
                weekday = Languages.get("monday");
                break;
            case Calendar.TUESDAY:
                weekday = Languages.get("tuesday");
                break;
            case Calendar.WEDNESDAY:
                weekday = Languages.get("wednesday");
                break;
            case Calendar.THURSDAY:
                weekday = Languages.get("thursday");
                break;
            case Calendar.FRIDAY:
                weekday = Languages.get("friday");
                break;
            case Calendar.SATURDAY:
                weekday = Languages.get("saturday");
                break;
        }
        //endregion

        /*with the simpleDateFormat, I get here the current date as string
         * then I split the string where the dots are and get them in own variables*/
        SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);
        final String Date = date.format(new Date());
        String[] dateparts = Date.split("\\.");
        String Day = dateparts[0];
        String month_ = dateparts[1];
        String year = dateparts[2];

        /*the name of the month as word, since it would be just a number*/
        //region Name of month
        if (month_.equalsIgnoreCase("01")) {
            Month = Languages.get("january");
        } else if (month_.equalsIgnoreCase("02")) {
            Month = Languages.get("february");
        } else if (month_.equalsIgnoreCase("03")) {
            Month = Languages.get("march");
        } else if (month_.equalsIgnoreCase("04")) {
            Month = Languages.get("april");
        } else if (month_.equalsIgnoreCase("05")) {
            Month = Languages.get("may");
        } else if (month_.equalsIgnoreCase("06")) {
            Month = Languages.get("june");
        } else if (month_.equalsIgnoreCase("07")) {
            Month = Languages.get("july");
        } else if (month_.equalsIgnoreCase("08")) {
            Month = Languages.get("august");
        } else if (month_.equalsIgnoreCase("09")) {
            Month = Languages.get("september");
        } else if (month_.equalsIgnoreCase("10")) {
            Month = Languages.get("october");
        } else if (month_.equalsIgnoreCase("11")) {
            Month = Languages.get("november");
        } else if (month_.equalsIgnoreCase("12")) {
            Month = Languages.get("december");
        }
        //endregion

        /*First the strings for the date and month get set
         * Second the text from the TextViews get set*/
        dateOfMonth = Day;
        Year = year;
        //Month = month_;

        dayOfWeek.setText(weekday);
        dayOfMonth.setText(dateOfMonth);
        year_.setText(Year);
        month.setText(Month);

        Date__ = dateOfMonth + "." + month_ + "." + Year;
        //endregion

        /*opens class to get the saved calendar view from the database*/
        GetCalendarView getCalView = new GetCalendarView(homeActivity);
        getCalView.execute();


        /*check whether the language is currently german or english
         * if the language is german, the calendar view is displayed in german
         * else if the language is english, the calendar view is displayed in english*/
        //region Language of Calendar
        if (Languages.getCurrentLanguage().equals(Languages.Lang.GERMAN)) {
            Locale locale = new Locale("de_DE");
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            calendarV.getResources().updateConfiguration(config, null);
        }
        else if (Languages.getCurrentLanguage().equals(Languages.Lang.ENGLISH)) {
            Locale locale = new Locale("en_US");
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            calendarV.getResources().updateConfiguration(config, null);
        }
        //endregion

        /*Uses function to show the DropDownMenu*/
        //region Dropdown Menu Show
        drpdwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v);
            }
        });
        //endregion

        /*on the calendar click parameters get transferred and the showDateOnClick function is used*/
        //region Calendar Click
        calendarV.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                /*gets the selected date and opens the function to show the clicked date*/
                selected_day = dayOfMonth;
                selected_month = month + 1;
                selected_year = year;

                showDateOnClick();
            }
        });
        //endregion

        /*Sets all texts and hint, get content from Languages.class*/
        //region Texts
        changeCView.setText(Languages.get("homeChangeCV"));
        mHabits.setText(Languages.get("homeMyHabits"));
        //endregion

        /*Changes the calendar view onClick*/
        //region Change Calendar View
        changeCView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*If the whole month is shown, it get set on invisible and the single date gets visible
                 * Else the single date gets invisible and the month gets visible
                 * In both cases, the new CalendarView gets saved in the database*/
                if (calendarV.getVisibility() == View.VISIBLE) {
                    ChangeCalendarView change = new ChangeCalendarView( "Day");
                    change.execute();
                    calendarV.setVisibility(View.INVISIBLE);
                    singleDay.setVisibility(View.VISIBLE);
                } else {
                    ChangeCalendarView change = new ChangeCalendarView("Month");
                    change.execute();
                    calendarV.setVisibility(View.VISIBLE);
                    singleDay.setVisibility(View.INVISIBLE);
                }
            }
        });
        //endregion


        /*Switches intent to MyHabitsActivity*/
        //region myHabits click listener
        mHabits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myHabits = new Intent(homeActivity, MyHabitsActivity.class);
                startActivity(myHabits);
                finish();
            }
        });
        //endregion

        GetLogInDate getDate = new GetLogInDate(homeActivity, currentDate_);
        getDate.execute();

    }

    /**Contains both functions for the Dropdown menu to show and to be clickable**/
    //region Dropdown Menu

    /**
     * Makes dropdown menu appear
     * Gives each menu item a name - gets names from the language class
     **/
    public void showMenu(View v) {
        PopupMenu menu = new PopupMenu(this, v);

        menu.getMenuInflater().inflate(R.menu.dropdown_menu_logged_in, menu.getMenu());

        menu.getMenu().findItem(R.id.home).setTitle(Languages.get("home"));
        menu.getMenu().findItem(R.id.habits).setTitle(Languages.get("habits"));
        menu.getMenu().findItem(R.id.myhabits).setTitle(Languages.get("myHabits"));
        menu.getMenu().findItem(R.id.calendar).setTitle(Languages.get(("calendar")));
        menu.getMenu().findItem(R.id.website).setTitle(Languages.get("website"));
        menu.getMenu().findItem(R.id.languages).setTitle(Languages.get("languages"));
        menu.getMenu().findItem(R.id.imprint).setTitle(Languages.get("imprint"));

        menu.show();
    }

    /**
     * makes dropdown menu clickable
     * String clicked is the item title and if clicked equal p.e. imprint it opens the wanted intent
     **/
    public void onMenuClick(MenuItem item) {

        String clicked = item.getTitle().toString();

        if (clicked.equals(Languages.get("languages"))) {
            Intent langs = new Intent(homeActivity, LanguageActivity.class);
            startActivity(langs);
            finish();
        } else if (clicked.equals(Languages.get("imprint"))) {
            Intent imprint = new Intent(homeActivity, ImprintActivity.class);
            startActivity(imprint);
            finish();
        } else if (clicked.equals(Languages.get("website"))) {
            AlertDialog.Builder notification = new AlertDialog.Builder(homeActivity);
            notification.setMessage(Languages.get("note"));
            notification.setPositiveButton("Ok", null);
            notification.setCancelable(true);
            notification.create().show();
        } else if (clicked.equals(Languages.get("home"))) {
            Intent home = new Intent(homeActivity, HomeActivity.class);
            startActivity(home);
            finish();
        } else if (clicked.equals(Languages.get("calendar"))) {
            Intent cal = new Intent(homeActivity, CalendarActivity.class);
            startActivity(cal);
            finish();
        }  else if (clicked.equals(Languages.get("habits"))) {
            Intent habits = new Intent(homeActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
        } else if (clicked.equals(Languages.get("myHabits"))) {
            Intent myHabits = new Intent(homeActivity, MyHabitsActivity.class);
            startActivity(myHabits);
            finish();
        }


    }
    //endregion

    /**
     * opens the single date view where the user get to know whether he had done some habits or not
     **/
    public void showDateOnClick() {
        calendarV.isClickable();
        int day = (int) calendarV.getDate();
        long date = calendarV.getDate();

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date);

        Intent singleDay = new Intent(homeActivity, SingleDateActivity.class);

        singleDay.putExtra("day", selected_day);
        singleDay.putExtra("month", selected_month);
        singleDay.putExtra("year", selected_year);
        startActivity(singleDay);
        finish();
    }

    /**
     * the postExecute function from the getCalendarView class returns the saved view and switches right when the user is logged in
     * to the right calendar view
     **/
    public void cViewFound(String cView)
    {
        if (cView.equalsIgnoreCase("Day")) {
            calendarV.setVisibility(View.INVISIBLE);
            singleDay.setVisibility(View.VISIBLE);
        } else if (cView.equalsIgnoreCase("Month")) {
            calendarV.setVisibility(View.VISIBLE);
            singleDay.setVisibility(View.INVISIBLE);
        }

    }

    /**
     * Since I made every part of the single day calendar sheet clickable, it get the integer from the SimpleDateFormat string after it is splitted
     * in three parts again
     * Then it opens the single Day where user see which or if he had done some habits
     **/
    public void openDay(View v) {
        int _Date = 0;
        int _Month = 0;
        int _Year = 0;
        int cDate;
        int cMonth;
        int cYear;

        Intent singleDay = new Intent(homeActivity, SingleDateActivity.class);

        SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);
        final String Date = date.format(new java.util.Date());
        String[] dateparts = Date.split("\\.");
        String Day = dateparts[0];
        String month_ = dateparts[1];
        String year = dateparts[2];

        try {
            _Date = Integer.parseInt(Day);
            _Month = Integer.parseInt(month_);
            _Year = Integer.parseInt(year);
        } catch (NumberFormatException nfe) {
        }
        cDate = _Date;
        cMonth = _Month;
        cYear = _Year;

        singleDay.putExtra("day", cDate);
        singleDay.putExtra("month", cMonth);
        singleDay.putExtra("year", cYear);
        startActivity(singleDay);
        finish();
    }

    /**
     * Happens if physical back button from phone is pressed
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        /*If the keycode is the keycode back event...*/
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            /*...appears another if clause
             * if the current language is english, the message in the alert is in english
             * else if the language is german, the message in the alert is in german
             *
             * The AlertDialog asks the user if he/she want to quit the app or  not
             * If the user presses the yes/ja or in other words the positive button, the app closes
             * If the user presses the no/nein or in other words the negative button, the app stays open*/
            if (Languages.getCurrentLanguage().equals(Languages.Lang.ENGLISH)) {
                AlertDialog.Builder quit = new AlertDialog.Builder(homeActivity);
                quit.setMessage("Do you really want to leave the app?");
                DialogInterface.OnClickListener quitListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                finish();
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:

                                break;
                        }
                    }
                };
                quit.setPositiveButton("Yes", quitListener);
                quit.setNegativeButton("No", quitListener);
                quit.create().show();
            } else if (Languages.getCurrentLanguage().equals(Languages.Lang.GERMAN)) {
                AlertDialog.Builder quit = new AlertDialog.Builder(homeActivity);
                quit.setMessage("Möchtest du die App wirklich verlassen?");
                DialogInterface.OnClickListener quitListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                finish();
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:

                                break;
                        }
                    }
                };
                quit.setPositiveButton("Ja", quitListener);
                quit.setNegativeButton("Nein", quitListener);
                quit.create().show();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    public void getDate(String date)
    {
        currentDate_ = date;

    }

}