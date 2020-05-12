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
import com.example.ecolife.database.JoinHabitFromHabit;
import com.example.ecolife.home.HomeActivity;
import com.example.ecolife.menu.HabitsActivity;
import com.example.ecolife.menu.ImprintActivity;
import com.example.ecolife.menu.LanguageActivity;
import com.example.ecolife.otherClasses.Languages;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NutritionActivity extends AppCompatActivity {

    /**Defines all needed Buttons, TextViews, Edits etc.*/
    //region Buttons und so
    FloatingActionButton drpdwn;
    Button backToHabits;
    Button join;
    TextView title;
    TextView inGeneral;
    TextView content;
    TextView tips;
    TextView partOne;
    TextView partTwo;
    TextView partThree;
    TextView partFour;
    TextView partFive;
    TextView partSix;
    TextView partSeven;
    final NutritionActivity nutritionActivity = this;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);

        /*Contains all assignments from needed Buttons, TextViews, Edits etc.*/
        //region Zuweisungen und so
        drpdwn = findViewById(R.id.dropdownmenu);
        join = findViewById(R.id.Join);
        backToHabits = findViewById(R.id.backToHabits);
        title = findViewById(R.id.nutrTitle);
        inGeneral = findViewById(R.id.nutrIG);
        content = findViewById(R.id.nutrContent);
        tips = findViewById(R.id.nutrTipps);
        partOne = findViewById(R.id.nutrOne);
        partTwo = findViewById(R.id.nutrTwo);
        partThree  = findViewById(R.id.nutrThree);
        partFour = findViewById(R.id.nutrFour);
        partFive = findViewById(R.id.nutrFive);
        partSix = findViewById(R.id.nutrSix);
        partSeven = findViewById(R.id.nutrSeven);
        //endregion

        /*Set all texts out of language class*/
        //region Texts
        title.setText(Languages.get("nutritionTitle"));
        inGeneral.setText(Languages.get("nutrIG"));
        content.setText(Languages.get("nutrIGContent"));
        tips.setText(Languages.get("nutrTipps"));
        partOne.setText(Languages.get("nutrOne"));
        partTwo.setText(Languages.get("nutrTwo"));
        partThree.setText(Languages.get("nutrThree"));
        partFour.setText(Languages.get("nutrFour"));
        partFive.setText(Languages.get("nutrFive"));
        partSix.setText(Languages.get("nutrSix"));
        partSeven.setText(Languages.get("nutrSeven"));
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
                Intent habits = new Intent(nutritionActivity, HabitsActivity.class);
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
                JoinHabitFromHabit joining = new JoinHabitFromHabit("Nutrition", "Ernährung","nutrition");
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
            Intent langs = new Intent(nutritionActivity, LanguageActivity.class);
            startActivity(langs);
            finish();
        }
        else if(clicked.equals(Languages.get("imprint")))
        {
            Intent imprint = new Intent(nutritionActivity, ImprintActivity.class);
            startActivity(imprint);
            finish();
        }
        else if(clicked.equals(Languages.get("website")))
        {
            AlertDialog.Builder notification = new AlertDialog.Builder(nutritionActivity);
            notification.setMessage(Languages.get("note"));
            notification.setPositiveButton("Ok", null);
            notification.setCancelable(true);
            notification.create().show();
        }
        else if(clicked.equals(Languages.get("home")))
        {
            Intent home = new Intent(nutritionActivity, HomeActivity.class);
            startActivity(home);
            finish();
        }
        else if(clicked.equals(Languages.get("calendar")))
        {
            Intent cal = new Intent(nutritionActivity, CalendarActivity.class);
            startActivity(cal);
            finish();
        }
        else if(clicked.equals(Languages.get("habits")))
        {
            Intent habits = new Intent(nutritionActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
        }
        else if(clicked.equals(Languages.get("myHabits")))
        {
            Intent myHabits = new Intent(nutritionActivity, MyHabitsActivity.class);
            startActivity(myHabits);
            finish();
        }
    }

    /**if physical back button from phone is pressed, intent switches
     * back to all habits*/
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode ==KeyEvent.KEYCODE_BACK)
        {
            Intent habits = new Intent(nutritionActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
