package com.example.ecolife.Calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.ecolife.MyHabitsActivity;
import com.example.ecolife.menu.HabitsActivity;
import com.example.ecolife.menu.LanguageActivity;
import com.example.ecolife.R;
import com.example.ecolife.home.HomeActivity;
import com.example.ecolife.menu.ImprintActivity;
import com.example.ecolife.otherClasses.Languages;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

public class CalendarActivity extends AppCompatActivity
{
    /**Defines different buttons, editTexts and variables (static and non static), such as finals*/
    //region Buttons, Variablen und co
    FloatingActionButton dropmenu;
    CalendarView calendarV;
    TextView title;
    final CalendarActivity calendarActivity = this;

    int selected_year = -1;
    int selected_month = -1;
    int selected_day = -1;

    ImageButton back;
    //endregion

    //@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        /*Contains all the assignments from Buttons, TextEdits etc.*/
        //region Zuweisungen
        dropmenu =findViewById(R.id.dropdownmenu);
        calendarV = findViewById(R.id.calendar);
        title =findViewById(R.id.Title);
        back = findViewById(R.id.backButton);
        //endregion

        /*Sets all texts and hint, get content from Languages.class*/
        //region Texts
        title.setText(Languages.get("calendarTitle"));
        //endregion

        /*Uses function to show the DropDownMenu*/
        dropmenu.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showMenu(v);
            }
        });

        /*Gets the selected day, month and year when clicking on a date in the calendar*/
        //region Kalender Klick Funktion
         calendarV.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
         {
             @Override
             public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth)
             {
                 selected_year = year;
                 selected_month = month+1;
                 selected_day = dayOfMonth;

                 showDateOnClick();
             }
         });

        //endregion

        /*the back image button switches intents back to the home activity*/
        //region back
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(calendarActivity, HomeActivity.class);
                startActivity(home);
                finish();
            }
        });
        //endregion

    }

    /**Contains both functions to use the dropdown menu*/
    //region Dropdown Menu

    /**Makes dropdown menu appear
     * Gives each menu item a name - gets names from the language class**/
    public void showMenu(View view)
    {
        PopupMenu menu = new PopupMenu(this, view);

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

    /**makes dropdown menu clickable
     * String clicked is the item title and if clicked equal p.e. imprint it opens the wanted intent**/
    public void onMenuClick(MenuItem item)
    {
        String clicked = item.getTitle().toString();

        if(clicked.equals(Languages.get("languages")))
        {
          Intent langs = new Intent(calendarActivity, LanguageActivity.class);
          startActivity(langs);
          finish();
        }
        else if(clicked.equals(Languages.get("imprint")))
        {
            Intent imprint = new Intent(calendarActivity, ImprintActivity.class);
            startActivity(imprint);
            finish();
        }
        else if(clicked.equals(Languages.get("website")))
        {
            AlertDialog.Builder notification = new AlertDialog.Builder(calendarActivity);
            notification.setMessage(Languages.get("note"));
            notification.setPositiveButton("Ok", null);
            notification.setCancelable(true);
            notification.create().show();
        }
        else if(clicked.equals(Languages.get("home")))
        {
            Intent home = new Intent(calendarActivity, HomeActivity.class);
            startActivity(home);
            finish();
        }
        else if(clicked.equals(Languages.get("calendar")))
        {
            Intent cal = new Intent(calendarActivity, CalendarActivity.class);
            startActivity(cal);
            finish();
        }
        else if(clicked.equals(Languages.get("habits")))
        {
            Intent habits = new Intent(calendarActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
        }
        else if(clicked.equals(Languages.get("myHabits")))
        {
            Intent myHabits = new Intent(calendarActivity, MyHabitsActivity.class);
            startActivity(myHabits);
            finish();
        }

    }
    //endregion

    /**shows the calendar day and the done habits*/
    //region Kalender Tag
    public void showDateOnClick()
   {

        calendarV.isClickable();
        int day = (int) calendarV.getDate();
        long date = calendarV.getDate();


        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date);

        Intent singleDay = new Intent(calendarActivity, SingleDateActivity.class);
        /*puts day, month and year if the selected day into an integer to transfer it to another activity (singleDateActivity)*/
        singleDay.putExtra("day", selected_day);
        singleDay.putExtra("month", selected_month);
        singleDay.putExtra("year", selected_year);
        startActivity(singleDay);
        finish();


    }
    //endregion

    /**if physical back button is pressed, intent switches back to home*/
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            Intent home = new Intent(calendarActivity, HomeActivity.class);
            startActivity(home);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
