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

public class ReducePlasticActivity extends AppCompatActivity {

    /**Defines different buttons, text views and edits*/
    //region Buttons und so
    FloatingActionButton drpdwn;
    Button backToHabits;
    Button join;
    Button openLink;
    TextView title;
    TextView why;
    TextView whyContnet;
    TextView what;
    TextView parOne;
    TextView parTwo;
    TextView parThree;
    TextView parFour;
    TextView parFive;
    TextView parSix;
    TextView parSeven;
    final ReducePlasticActivity reducePlasticActivity = this;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reduce_plastic);

        /*Contains all assignments from buttons, TextViews and edits*/
        //region Zuweisungen
        drpdwn = findViewById(R.id.dropdownmenu);
        backToHabits = findViewById(R.id.backToHabits);
        join = findViewById(R.id.Join);
        openLink = findViewById(R.id.redPlasticLink);
        title = findViewById(R.id.reducePlasticTitle);
        why = findViewById(R.id.redPlasticWhy);
        whyContnet = findViewById(R.id.redPlasticWhyContent);
        what = findViewById(R.id.redPlasticWhat);
        parOne = findViewById(R.id.parOne);
        parTwo = findViewById(R.id.parTwo);
        parThree = findViewById(R.id.parThree);
        parFour = findViewById(R.id.parFour);
        parFive = findViewById(R.id.parFive);
        parSix = findViewById(R.id.parSix);
        parSeven = findViewById(R.id.parSeven);
        //endregion

        /*Sets all texts out of the language class*/
        //region Texts
        title.setText(Languages.get("redPlasticTitle"));
        why.setText(Languages.get("redPlasticWhy"));
        whyContnet.setText(Languages.get("redPlasticWhyContent"));
        what.setText(Languages.get("redPlasticWhat"));
        parOne.setText(Languages.get("partOne"));
        parTwo.setText(Languages.get("partTwo"));
        parThree.setText(Languages.get("partThree"));
        parFour.setText(Languages.get("partFour"));
        parFive.setText(Languages.get("partFive"));
        parSix.setText(Languages.get("partSix"));
        parSeven.setText(Languages.get("partSeven"));
        openLink.setText(Languages.get("redPlasticLink"));

        backToHabits.setText(Languages.get("BackToHabits"));
        join.setText(Languages.get("JoinHabit"));
        //endregion

        /*uses a function to show the dropown menu*/
        //region Dropdown Menu
        drpdwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v);
            }
        });
        //endregion

        /*Switches Intents back to all habits*/
        //region Back to habits
        backToHabits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent habits = new Intent(reducePlasticActivity, HabitsActivity.class);
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
                JoinHabitFromHabit joining = new JoinHabitFromHabit( "Reduce plastic", "Plastik reduzieren","reducePlastic");
                joining.execute();
            }
        });
        //endregion
    }

    /**opens a german and an english link about sustainability
     *The german link is about reducing and avoiding plastic
     * The english link is sort of a plastic-free guide*/
    public void sustainableLink(View v)
    {
        if(Languages.getCurrentLanguage().equals(Languages.Lang.GERMAN)) {
            Intent linked = new Intent(Intent.ACTION_VIEW, Uri.parse("https://nachhaltig-sein.info/natur/plastik-vermeiden-reduzieren-tipps-plastikfrei-leben"));
            startActivity(linked);
        }
        else if (Languages.getCurrentLanguage().equals(Languages.Lang.ENGLISH))
        {
            Intent linked2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://myplasticfreelife.com/plasticfreeguide/"));
            startActivity(linked2);
        }
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
            Intent langs = new Intent(reducePlasticActivity, LanguageActivity.class);
            startActivity(langs);
            finish();
        }
        else if(clicked.equals(Languages.get("imprint")))
        {
            Intent imprint = new Intent(reducePlasticActivity, ImprintActivity.class);
            startActivity(imprint);
            finish();
        }
        else if(clicked.equals(Languages.get("website")))
        {
            AlertDialog.Builder notification = new AlertDialog.Builder(reducePlasticActivity);
            notification.setMessage(Languages.get("note"));
            notification.setPositiveButton("Ok", null);
            notification.setCancelable(true);
            notification.create().show();
        }
        else if(clicked.equals(Languages.get("home")))
        {
            Intent home = new Intent(reducePlasticActivity, HomeActivity.class);
            startActivity(home);
            finish();
        }
        else if(clicked.equals(Languages.get("calendar")))
        {
            Intent cal = new Intent(reducePlasticActivity, CalendarActivity.class);
            startActivity(cal);
            finish();
        }
        else if(clicked.equals(Languages.get("habits")))
        {
            Intent habits = new Intent(reducePlasticActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
        }
        else if(clicked.equals(Languages.get("myHabits")))
        {
            Intent myHabits = new Intent(reducePlasticActivity, MyHabitsActivity.class);
            startActivity(myHabits);
            finish();
        }

    }

    /**if physical back button from phone is pressed, intent switches
     * back to all habits*/
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            Intent habits = new Intent(reducePlasticActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
            return  true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
