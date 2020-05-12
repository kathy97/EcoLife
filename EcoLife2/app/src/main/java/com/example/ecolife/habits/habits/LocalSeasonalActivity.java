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
import com.example.ecolife.database.DBManager;
import com.example.ecolife.database.JoinHabitFromHabit;
import com.example.ecolife.home.HomeActivity;
import com.example.ecolife.menu.HabitsActivity;
import com.example.ecolife.menu.ImprintActivity;
import com.example.ecolife.menu.LanguageActivity;
import com.example.ecolife.otherClasses.Languages;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LocalSeasonalActivity extends AppCompatActivity
{

    /**Defines different buttons, editTexts and variables (static and non static), such as finals*/
    //region Buttons und so
    FloatingActionButton drpdwn;
    Button join;
    Button backToHabits;
    Button firstLink;
    Button secondLink;
    Button thirdLink;
    TextView title;
    TextView content;
    final LocalSeasonalActivity localSeasonalActivity = this;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_seasonal);

        /*Contains all the assignments from Buttons, TextEdits etc.*/
        //region Zuweisungen
        drpdwn = findViewById(R.id.dropdownmenu);
        join = findViewById(R.id.join);
        backToHabits = findViewById(R.id.backToHabits);
        firstLink = findViewById(R.id.firstLink);
        secondLink = findViewById(R.id.secondLink);
        thirdLink = findViewById(R.id.thirdLink);
        title = findViewById(R.id.localSeasonalTitle);
        content = findViewById(R.id.localSeasonalContent);
        //endregion

        /*Sets all texts and hint, get content from Languages.class*/
        //region Texts
        join.setText(Languages.get("JoinHabit"));
        backToHabits.setText(Languages.get("BackToHabits"));
        firstLink.setText(Languages.get("lsLink1"));
        secondLink.setText(Languages.get("lsLink2"));
        thirdLink.setText(Languages.get("lsLink3"));
        title.setText(Languages.get("localSeasonalTitle"));
        content.setText(Languages.get("localSeasonalContent"));
        //endregion

        /*Uses function to show the DropDownMenu*/
        //region DropDownMenu
        drpdwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v);
            }
        });
        //endregion

        /*on this button click intents switch back to all habits*/
        //region Back to Habits
        backToHabits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent habits = new Intent(localSeasonalActivity, HabitsActivity.class);
                startActivity(habits);
                finish();
            }
        });
        //endregion

        /*on clicking the join button, the userID is getting transferred to the join habit from Habit class
         *along with the german, english and bar name of the habit*/
        //region Join
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JoinHabitFromHabit joining = new JoinHabitFromHabit( "Local and Seasonal", "Regional und Saisonal","localSeasonal");
                joining.execute();
            }
        });
        //endregion
    }

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
            Intent langs = new Intent(localSeasonalActivity, LanguageActivity.class);
            startActivity(langs);
            finish();
        }
        else if(clicked.equals(Languages.get("imprint")))
        {
            Intent imprint = new Intent(localSeasonalActivity, ImprintActivity.class);
            startActivity(imprint);
            finish();
        }
        else if(clicked.equals(Languages.get("website")))
        {
            AlertDialog.Builder notification = new AlertDialog.Builder(localSeasonalActivity);
            notification.setMessage(Languages.get("note"));
            notification.setPositiveButton("Ok", null);
            notification.setCancelable(true);
            notification.create().show();
        }
        else if(clicked.equals(Languages.get("home")))
        {
            Intent home = new Intent(localSeasonalActivity, HomeActivity.class);
            startActivity(home);
            finish();
        }
        else if(clicked.equals(Languages.get("calendar")))
        {
            Intent cal = new Intent(localSeasonalActivity, CalendarActivity.class);
            startActivity(cal);
            finish();
        }
        else if(clicked.equals(Languages.get("habits")))
        {
            Intent habits = new Intent(localSeasonalActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
        }
        else if(clicked.equals(Languages.get("myHabits")))
        {
            Intent myHabits = new Intent(localSeasonalActivity, MyHabitsActivity.class);
            startActivity(myHabits);
            finish();
        }

    }

    /**Opens a german and an english link about local and seasonal foods
     * The german link is about those foods in austria
     * The english link is about those foods in the uk(united kingdom)*/
    public void openFirstLink(View v)
    {
        if(Languages.getCurrentLanguage().equals(Languages.Lang.GERMAN)) {
            Intent austria = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gesundheit.gv.at/leben/ernaehrung/saisonkalender/inhalt"));
            startActivity(austria);
        }
        else if (Languages.getCurrentLanguage().equals(Languages.Lang.ENGLISH))
        {
            Intent uk = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.goodtoknow.co.uk/food/seasonal-food-calendar-71128"));
            startActivity(uk);
        }
    }

    /**Opens a german and an english link about local and seasonal foods
     * The german link is about those foods in germany
     * The english link is about those foods in the western/northern europe*/
    public void openSecondLink(View v)
    {
        if(Languages.getCurrentLanguage().equals(Languages.Lang.GERMAN)) {
            Intent germany = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.geo.de/natur/nachhaltigkeit/21420-thma-geo-saisonkalender"));
            startActivity(germany);
        }
        else if (Languages.getCurrentLanguage().equals(Languages.Lang.ENGLISH))
        {
            Intent europe = new Intent(Intent.ACTION_VIEW, Uri.parse("http://na-nu.com/terfloth.org/Kitchen/Season_Cal.pdf"));
            startActivity(europe);
        }
    }

    /**Opens a german and an english link about local and seasonal foods
     * The german link is about why a local and seasonal nutrition is better
     * The english link is about those foods in the us (united states of america)*/
    public void openThirdLink(View v)
    {
        if(Languages.getCurrentLanguage().equals(Languages.Lang.GERMAN)) {
            Intent why = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gesund-aktiv.com/wissenswertes/warum-saisonal-und-regional-einkaufen"));
            startActivity(why);
        }
        else if (Languages.getCurrentLanguage().equals(Languages.Lang.ENGLISH))
        {
            Intent us = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.thehealthy.com/nutrition/fruits-vegetables-in-season-every-month-of-year/"));
            startActivity(us);
        }
    }

    /**if physical back button from phone is pressed, intent switches
     * back to all habits*/
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            Intent habits = new Intent(localSeasonalActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
