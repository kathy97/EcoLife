package com.example.ecolife.habits.habits;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.ecolife.Calendar.CalendarActivity;
import com.example.ecolife.MyHabitsActivity;
import com.example.ecolife.R;
import com.example.ecolife.database.JoinHabitFromHabit;
import com.example.ecolife.home.HomeActivity;
import com.example.ecolife.menu.HabitsActivity;
import com.example.ecolife.menu.ImprintActivity;
import com.example.ecolife.menu.LanguageActivity;
import com.example.ecolife.otherClasses.Languages;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class UpcycleActivity extends AppCompatActivity
{
    /**Defines different buttons and TextViews*/
    Button link1;
    Button link2;
    Button link3;
    FloatingActionButton drpdwn;
    TextView title;
    TextView content;
    Button backToHabits;
    Button Join;
    final UpcycleActivity upcycleActivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcycle);

        /*Contains all assignments from buttons and TextViews*/
        //region Zuweisungen
        link1 = findViewById(R.id.LinkHandmadeKultur);
        link2 = findViewById(R.id.LinkDIYAcademy);
        link3 = findViewById(R.id.LinkDIYMode);
        drpdwn = findViewById(R.id.dropdownmenu);
        title = findViewById(R.id.upcycleTitle);
        content = findViewById(R.id.upcycleContent);
        backToHabits = findViewById(R.id.backToHabits);
        Join = findViewById(R.id.Join);
        //endregion

        /*Sets all texts out of language class*/
        //region Texts
        link1.setText(Languages.get("firstLink"));
        link2.setText(Languages.get("secondLink"));
        link3.setText(Languages.get("thirdLink"));
        title.setText(Languages.get("upcylceTitle"));
        content.setText(Languages.get("upcycleContent"));
        backToHabits.setText(Languages.get("BackToHabits"));
        Join.setText(Languages.get("JoinHabit"));
        //endregion

        /*Uses a function to show dropdown menu*/
        //region Dropdown Menu
        drpdwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v);
            }
        });
        //endregion

        /*Switches intents back too habits*/
        //region Back to Habits
        backToHabits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent habits = new Intent(upcycleActivity, HabitsActivity.class);
                startActivity(habits);
                finish();
            }
        });
        //endregion

        /*on clicking the join button, the userID is getting transferred to the join habit from Habit class
         *along with the german, english and bar name of the habit*/
        //region Join
        Join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JoinHabitFromHabit joining = new JoinHabitFromHabit("Upcycle", "Upcycle","upcycle");
                joining.execute();
            }
        });
        //endregion


    }

    /**Makes menu appear*/
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

    /**Makes dropdown menu clickable
     * p.e. if user clicks imprint, intents switch to imprint*/
    public void onMenuClick(MenuItem item)
    {

        String clicked = item.getTitle().toString();

        if(clicked.equals(Languages.get("languages")))
        {
            Intent langs = new Intent(upcycleActivity, LanguageActivity.class);
            startActivity(langs);
            finish();
        }
        else if(clicked.equals(Languages.get("imprint")))
        {
            Intent imprint = new Intent(upcycleActivity, ImprintActivity.class);
            startActivity(imprint);
            finish();
        }
        else if(clicked.equals(Languages.get("website")))
        {
            AlertDialog.Builder notification = new AlertDialog.Builder(upcycleActivity);
            notification.setMessage(Languages.get("note"));
            notification.setPositiveButton("Ok", null);
            notification.setCancelable(true);
            notification.create().show();
        }
        else if(clicked.equals(Languages.get("home")))
        {
            Intent home = new Intent(upcycleActivity, HomeActivity.class);
            startActivity(home);
            finish();
        }
        else if(clicked.equals(Languages.get("calendar")))
        {
            Intent cal = new Intent(upcycleActivity, CalendarActivity.class);
            startActivity(cal);
            finish();
        }
        else if(clicked.equals(Languages.get("habits")))
        {
            Intent habits = new Intent(upcycleActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
        }
        else if(clicked.equals(Languages.get("myHabits")))
        {
            Intent myHabits = new Intent(upcycleActivity, MyHabitsActivity.class);
            startActivity(myHabits);
            finish();
        }

    }


    /**Opens a german or an english link - depends on selected language
     * Both links are about upcycling*/
    public void handmadeK(View view)
    {
        if(Languages.getCurrentLanguage().equals(Languages.Lang.GERMAN)) {
            Intent linked = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.handmadekultur.de/projekte/upcycling"));
            startActivity(linked);
        }
        else if (Languages.getCurrentLanguage().equals(Languages.Lang.ENGLISH))
        {
            Intent linked2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.onecrazyhouse.com/tag/upcycle/"));
            startActivity(linked2);
        }
    }

    /**Opens a german or an english link - depends on selected language
     * Both links are DIYs and Hacks*/
    public void diyAcademy(View v)
    {
        if(Languages.getCurrentLanguage().equals(Languages.Lang.GERMAN)) {
            Intent linked3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.diy-academy.eu/einrichten-gestalten/upcycling/"));
            startActivity(linked3);
        }
        else if (Languages.getCurrentLanguage().equals(Languages.Lang.ENGLISH))
        {
            Intent linked4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://homehacks.co/category/upcycling/"));
            startActivity(linked4);
        }
    }


    /**Opens a german or an english link - depends on selected language
     *Both are about upcycling */
    public void diyMode(View v)
    {
        if(Languages.getCurrentLanguage().equals(Languages.Lang.GERMAN)) {
            Intent linked5 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.diymode.de/nie-wieder-langeweile-100-upcycling-ideen-zum-naehen-basteln-und-dekorieren/"));
            startActivity(linked5);
        }
        else if (Languages.getCurrentLanguage().equals(Languages.Lang.ENGLISH))
        {
            Intent linked6 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.lifehack.org/articles/lifestyle/30-mind-blowing-ways-upcycle-plastic-bottles-home-and-the-office.html"));
            startActivity(linked6);
        }
    }

    /**Switches intent if physical back button from phone is pressed*/
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            Intent habits = new Intent(upcycleActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
            return  true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
