package com.example.ecolife.habits.habits;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class NoStrawsActivity extends AppCompatActivity
{
    /**Defines different buttons, TextViews/Edits etc*/
    //region Buttons und TextViews
    FloatingActionButton drpdwn;
    Button join;
    Button backToHabits;
    TextView title;
    TextView content;
    TextView alternatives;
    TextView alternativesContent;
    final NoStrawsActivity noStrawsActivity = this;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_straws);

        /*Contains all assignments from buttons, TextViews and Edits*/
        //region Zuweisungen
        drpdwn = findViewById(R.id.dropdownmenu);
        join = findViewById(R.id.join);
        backToHabits = findViewById(R.id.backToHabits);
        title = findViewById(R.id.noStrawsTitle);
        content = findViewById(R.id.noStrawsContent);
        alternatives = findViewById(R.id.noStrawsAlternatives);
        alternativesContent =findViewById(R.id.noStrawsAltContent);
        //endregion

        /*Gets all texts set out of the language.class*/
        //region Texts
        join.setText(Languages.get("JoinHabit"));
        backToHabits.setText(Languages.get("BackToHabits"));
        title.setText(Languages.get("noStrawsTitle"));
        content.setText(Languages.get("noStrawsContent"));
        alternatives.setText(Languages.get("noStrawsAlternatives"));
        alternativesContent.setText(Languages.get("noStrawsAltContent"));
        //endregion

        /*uses a function to show the dropdown menu*/
        //region DropDownMenu
        drpdwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v);
            }
        });
        //endregion

        /*on clicking the join button, the userID is getting transferred to the join habit from Habit class
         *along with the german, english and bar name of the habit*/
        //region Join
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JoinHabitFromHabit joining = new JoinHabitFromHabit("No straws", "Keine Strohhalme","noStraws");
                joining.execute();
            }
        });
        //endregion

        /*Intents switch back to all habits*/
        //region Back to Habits
        backToHabits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent habits = new Intent(noStrawsActivity, HabitsActivity.class);
                startActivity(habits);
                finish();
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
            Intent langs = new Intent(noStrawsActivity, LanguageActivity.class);
            startActivity(langs);
            finish();
        }
        else if(clicked.equals(Languages.get("imprint")))
        {
            Intent imprint = new Intent(noStrawsActivity, ImprintActivity.class);
            startActivity(imprint);
            finish();
        }
        else if(clicked.equals(Languages.get("website")))
        {
            AlertDialog.Builder notification = new AlertDialog.Builder(noStrawsActivity);
            notification.setMessage(Languages.get("note"));
            notification.setPositiveButton("Ok", null);
            notification.setCancelable(true);
            notification.create().show();
        }
        else if(clicked.equals(Languages.get("home")))
        {
            Intent home = new Intent(noStrawsActivity, HomeActivity.class);
            startActivity(home);
            finish();
        }
        else if(clicked.equals(Languages.get("calendar")))
        {
            Intent cal = new Intent(noStrawsActivity, CalendarActivity.class);
            startActivity(cal);
            finish();
        }

        else if(clicked.equals(Languages.get("habits")))
        {
            Intent habits = new Intent(noStrawsActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
        }
        else if(clicked.equals(Languages.get("myHabits")))
        {
            Intent myHabits = new Intent(noStrawsActivity, MyHabitsActivity.class);
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
            Intent habits = new Intent(noStrawsActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
