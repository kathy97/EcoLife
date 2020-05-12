package com.example.ecolife.reuse;

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
import com.example.ecolife.home.HomeActivity;
import com.example.ecolife.menu.HabitsActivity;
import com.example.ecolife.menu.ImprintActivity;
import com.example.ecolife.menu.LanguageActivity;
import com.example.ecolife.otherClasses.Languages;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ReuseInfoActivity extends AppCompatActivity
{

    /**Defines all needed Buttons, TextViews, Edits etc.*/
    //region Buttons und so
    FloatingActionButton drpdwn;
    Button backToHabits;
    TextView title;
    TextView why;
    TextView whyContent;
    TextView whyAlternativesBetter;
    TextView alt1;
    TextView alt2;
    TextView alt3;
    TextView alt4;
    TextView alt5;
    TextView alt6;
    TextView alt7;
    TextView alt8;
    TextView whySwitch;
    TextView res1;
    TextView res1a;
    TextView res2;
    final  ReuseInfoActivity reuseInfoActivity = this;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reuse_info);

        /*Contains all assignments from needed Buttons, TextViews, Edits etc.*/
        //region Zuweisungen
        drpdwn = findViewById(R.id.dropdownmenu);
        backToHabits = findViewById(R.id.backToHabits);
        title = findViewById(R.id.reuseInfoTitle);
        why = findViewById(R.id.reuseInfoWhy);
        whyContent = findViewById(R.id.reuseInfoWhyContent);
        whyAlternativesBetter =  findViewById(R.id.reuseInfoWhyBetter);
        alt1 = findViewById(R.id.why1);
        alt2 = findViewById(R.id.why2);
        alt3 = findViewById(R.id.why3);
        alt4 = findViewById(R.id.why4);
        alt5 = findViewById(R.id.why5);
        alt6 = findViewById(R.id.why6);
        alt7 = findViewById(R.id.why7);
        alt8 = findViewById(R.id.why8);
        whySwitch = findViewById(R.id.reuseInfoWhyDoThat);
        res1 = findViewById(R.id.why01);
        res1a = findViewById(R.id.why02);
        res2 = findViewById(R.id.why03);
        //endregion

        /*Set all texts out of language class*/
        //region Texts
        backToHabits.setText(Languages.get("BackToHabits"));
        title.setText(Languages.get("reuseInfTitle"));
        why.setText(Languages.get("reuseInfWhy"));
        whyContent.setText(Languages.get("reuseInfWhyContent"));
        whyAlternativesBetter.setText(Languages.get("reuseInfAlt"));
        alt1.setText(Languages.get("reuseInf1"));
        alt2.setText(Languages.get("reuseInf2"));
        alt3.setText(Languages.get("reuseInf3"));
        alt4.setText(Languages.get("reuseInf4"));
        alt5.setText(Languages.get("reuseInf5"));
        alt6.setText(Languages.get("reuseInf6"));
        alt7.setText(Languages.get("reuseInf7"));
        alt8.setText(Languages.get("reuseInf8"));
        whySwitch.setText(Languages.get("reuseInfWhySwitch"));
        res1.setText(Languages.get("reuseInfRes1"));
        res1a.setText(Languages.get("reuseInfRes2"));
        res2.setText(Languages.get("reuseInfRes3"));
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
                Intent habits = new Intent(reuseInfoActivity, HabitsActivity.class);
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
            Intent langs = new Intent(reuseInfoActivity, LanguageActivity.class);
            startActivity(langs);
            finish();
        }
        else if(clicked.equals(Languages.get("imprint")))
        {
            Intent imprint = new Intent(reuseInfoActivity, ImprintActivity.class);
            startActivity(imprint);
            finish();
        }
        else if(clicked.equals(Languages.get("website")))
        {
            AlertDialog.Builder notification = new AlertDialog.Builder(reuseInfoActivity);
            notification.setMessage(Languages.get("note"));
            notification.setPositiveButton("Ok", null);
            notification.setCancelable(true);
            notification.create().show();
        }
        else if(clicked.equals(Languages.get("home")))
        {
            Intent home = new Intent(reuseInfoActivity, HomeActivity.class);
            startActivity(home);
            finish();
        }
        else if(clicked.equals(Languages.get("calendar")))
        {
            Intent cal = new Intent(reuseInfoActivity, CalendarActivity.class);
            startActivity(cal);
            finish();
        }
        else if(clicked.equals(Languages.get("habits")))
        {
            Intent habits = new Intent(reuseInfoActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
        }
        else if(clicked.equals(Languages.get("myHabits")))
        {
            Intent myHabits = new Intent(reuseInfoActivity, MyHabitsActivity.class);
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
            Intent habits = new Intent(reuseInfoActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
