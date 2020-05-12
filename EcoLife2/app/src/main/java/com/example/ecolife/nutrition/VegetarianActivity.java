package com.example.ecolife.nutrition;

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

public class VegetarianActivity extends AppCompatActivity {

    /**Defines all needed Buttons, TextViews, Edits etc.*/
    //region Buttons und so
    FloatingActionButton drpdwn;
    Button  backToHabits;
    Button join;
    TextView title;
    TextView inGeneral;
    TextView content;
    TextView advantages;
    TextView vegOne;
    TextView vegTwo;
    TextView vegThree;
    TextView vegFour;
    TextView vegFive;
    TextView vegSix;
    TextView vegSeven;

    final VegetarianActivity vegetarianActivity =this;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetarian);

        /*Contains all assignments from needed Buttons, TextViews, Edits etc.*/
        //region Zuweisungen
        drpdwn = findViewById(R.id.dropdownmenu);
        backToHabits = findViewById(R.id.backToHabits);
        join = findViewById(R.id.Join);
        title =findViewById(R.id.vegetarianTitle);
        inGeneral = findViewById(R.id.vegIg);
        content = findViewById(R.id.vegContent);
        advantages = findViewById(R.id.vegAdvantages);
        vegOne = findViewById(R.id.vegOne);
        vegTwo = findViewById(R.id.vegTwo);
        vegThree = findViewById(R.id.vegThree);
        vegFour = findViewById(R.id.vegFour);
        vegFive = findViewById(R.id.vegFive);
        vegSix = findViewById(R.id.vegSix);
        vegSeven = findViewById(R.id.vegSeven);
        //endregion

        /*Set all texts out of language class*/
        //region Texts
        backToHabits.setText(Languages.get("BackToHabits"));
        join.setText(Languages.get("JoinHabit"));
        title.setText(Languages.get("vegTitle"));
        inGeneral.setText(Languages.get("vegIg"));
        content.setText(Languages.get("vegIgContent"));
        advantages.setText(Languages.get("vegAdv"));
        vegOne.setText(Languages.get("vegOne"));
        vegTwo.setText(Languages.get("vegTwo"));
        vegThree.setText(Languages.get("vegThree"));
        vegFour.setText(Languages.get("vegFour"));
        vegFive.setText(Languages.get("vegFive"));
        vegSix.setText(Languages.get("vegSix"));
        vegSeven.setText(Languages.get("vegSeven"));
        //endregion

        /*uses a function to show the dropown menu*/
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
                JoinHabitFromHabit joining = new JoinHabitFromHabit( "Vegetarian", "Vegetarisch","vegetarian");
                joining.execute();
            }
        });
        //endregion

        /*Switches Intents back to all habits*/
        //region Back to habits
        backToHabits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent habits = new Intent(vegetarianActivity, HabitsActivity.class);
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
            Intent langs = new Intent(vegetarianActivity, LanguageActivity.class);
            startActivity(langs);
            finish();
        }
        else if(clicked.equals(Languages.get("imprint")))
        {
            Intent imprint = new Intent(vegetarianActivity, ImprintActivity.class);
            startActivity(imprint);
            finish();
        }
        else if(clicked.equals(Languages.get("website")))
        {
            AlertDialog.Builder notification = new AlertDialog.Builder(vegetarianActivity);
            notification.setMessage(Languages.get("note"));
            notification.setPositiveButton("Ok", null);
            notification.setCancelable(true);
            notification.create().show();
        }
        else if(clicked.equals(Languages.get("home")))
        {
            Intent home = new Intent(vegetarianActivity, HomeActivity.class);
            startActivity(home);
            finish();
        }
        else if(clicked.equals(Languages.get("calendar")))
        {
            Intent cal = new Intent(vegetarianActivity, CalendarActivity.class);
            startActivity(cal);
            finish();
        }

        else if(clicked.equals(Languages.get("habits")))
        {
            Intent habits = new Intent(vegetarianActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
        }
        else if(clicked.equals(Languages.get("myHabits")))
        {
            Intent myHabits = new Intent(vegetarianActivity, MyHabitsActivity.class);
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
            Intent habits = new Intent(vegetarianActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
