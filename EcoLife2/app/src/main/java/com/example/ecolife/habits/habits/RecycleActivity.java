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
import com.example.ecolife.database.JoinHabitFromHabit;
import com.example.ecolife.home.HomeActivity;
import com.example.ecolife.menu.HabitsActivity;
import com.example.ecolife.menu.ImprintActivity;
import com.example.ecolife.menu.LanguageActivity;
import com.example.ecolife.otherClasses.Languages;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RecycleActivity extends AppCompatActivity
{

    /**Defines different buttons, text views and edits*/
    //region Buttons und so
    FloatingActionButton drpdwn;
    Button backToHabits;
    Button Join;
    TextView title;
    TextView headlinerText;
    TextView firstPoint;
    TextView firstUnderpoint;
    TextView secondPoint;
    TextView thirdPoint;
    TextView thirdUnderpoint;
    TextView fourthPoint;
    TextView fourthUnderpoint;
    TextView fifthPoint;
    TextView fifthUnderpoint;
    TextView lastPoints;
    final RecycleActivity recycleActivity = this;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        /*Contains all assignments from buttons, TextViews and edits*/
        //region Zuweisungen
        drpdwn = findViewById(R.id.dropdownmenu);
        backToHabits = findViewById(R.id.backToHabits);
        Join = findViewById(R.id.Join);
        title= findViewById(R.id.recycleTitle);
        headlinerText = findViewById(R.id.headtext);
        firstPoint = findViewById(R.id.repair);
        firstUnderpoint = findViewById(R.id.savemoney);
        secondPoint = findViewById(R.id.langlebig);
        thirdPoint = findViewById(R.id.leihen);
        thirdUnderpoint = findViewById(R.id.wasleihen);
        fourthPoint = findViewById(R.id.flewmarket);
        fourthUnderpoint = findViewById(R.id.whatonflewmarket);
        fifthPoint = findViewById(R.id.batterie);
        fifthUnderpoint = findViewById(R.id.langlebiger);
        lastPoints = findViewById(R.id.boxes);
        //endregion

        /*Sets all texts out of the language class*/
        //region Texts
        title.setText(Languages.get("recycleTitle"));
        headlinerText.setText(Languages.get("recHeadlineText"));
        firstPoint.setText(Languages.get("recFirstPoint"));
        firstUnderpoint.setText(Languages.get("recFirstUnderpoint"));
        secondPoint.setText(Languages.get("recSecondPoint"));
        thirdPoint.setText(Languages.get("recThirdPoint"));
        thirdUnderpoint.setText(Languages.get("recThirdUnderpoint"));
        fourthPoint.setText(Languages.get("recFourthPoint"));
        fourthUnderpoint.setText(Languages.get("recFourthUnderpoint"));
        fifthPoint.setText(Languages.get("recFifthPoint"));
        firstUnderpoint.setText(Languages.get("recFifthUnderpoint"));
        lastPoints.setText(Languages.get("lastPoints"));

        backToHabits.setText(Languages.get("BackToHabits"));
        Join.setText(Languages.get("JoinHabit"));
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
                Intent habits = new Intent (recycleActivity, HabitsActivity.class);
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
                JoinHabitFromHabit joining = new JoinHabitFromHabit("Recycle", "Recycle","recycle");
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
            Intent langs = new Intent(recycleActivity, LanguageActivity.class);
            startActivity(langs);
            finish();
        }
        else if(clicked.equals(Languages.get("imprint")))
        {
            Intent imprint = new Intent(recycleActivity, ImprintActivity.class);
            startActivity(imprint);
            finish();
        }
        else if(clicked.equals(Languages.get("website")))
        {
            AlertDialog.Builder notification = new AlertDialog.Builder(recycleActivity);
            notification.setMessage(Languages.get("note"));
            notification.setPositiveButton("Ok", null);
            notification.setCancelable(true);
            notification.create().show();
        }
        else if(clicked.equals(Languages.get("home")))
        {
            Intent home = new Intent(recycleActivity, HomeActivity.class);
            startActivity(home);
            finish();
        }
        else if(clicked.equals(Languages.get("calendar")))
        {
            Intent cal = new Intent(recycleActivity, CalendarActivity.class);
            startActivity(cal);
            finish();
        }
        else if(clicked.equals(Languages.get("habits")))
        {
            Intent habits = new Intent(recycleActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
        }
        else if(clicked.equals(Languages.get("myHabits")))
        {
            Intent myHabits = new Intent(recycleActivity, MyHabitsActivity.class);
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
            Intent habits = new Intent(recycleActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
