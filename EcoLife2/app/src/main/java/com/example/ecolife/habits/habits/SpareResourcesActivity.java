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

public class SpareResourcesActivity extends AppCompatActivity
{
    /**Defines all buttons, Textviews and Edits needed*/
    //region Buttons und so
    FloatingActionButton drpdwn;
    Button backToHabits;
    Button join;
    TextView title;
    TextView what;
    TextView whatContent;
    TextView tipps;
    TextView tipp1;
    TextView tipp1a;
    TextView tipp2;
    TextView tipp2a;
    TextView tipp3;
    TextView tipp3a;
    TextView tipp4;
    TextView tipp4a;
    TextView tipp5;
    TextView tipp5a;
    TextView tipp6;
    final SpareResourcesActivity spareResourcesActivity = this;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spare_resources);

        /*Contains all assignments from buttons and TextViews and Edits*/
        //region Zuweisungen
        drpdwn = findViewById(R.id.dropdownmenu);
        backToHabits = findViewById(R.id.backToHabits);
        join = findViewById(R.id.join);
        title = findViewById(R.id.spareRes);
        what = findViewById(R.id.whatAreRes);
        whatContent = findViewById(R.id.whatContent);
        tipps = findViewById(R.id.spareResTipps);
        tipp1 = findViewById(R.id.tipp1);
        tipp1a = findViewById(R.id.tipp1a);
        tipp2 = findViewById(R.id.tipp2);
        tipp2a = findViewById(R.id.tipp2a);
        tipp3 = findViewById(R.id.tipp3);
        tipp3a = findViewById(R.id.tipp3a);
        tipp4 = findViewById(R.id.tipp4);
        tipp4a = findViewById(R.id.tipp4a);
        tipp5 = findViewById(R.id.tipp5);
        tipp5a = findViewById(R.id.tipp5a);
        tipp6 = findViewById(R.id.tipp6);
        //endregion

        /*Sets all texts out of language class*/
        //region Texts
        backToHabits.setText(Languages.get("BackToHabits"));
        join.setText(Languages.get("JoinHabit"));
        title.setText(Languages.get("srTitle"));
        what.setText(Languages.get("srWhat"));
        whatContent.setText(Languages.get("srWhatContent"));
        tipps.setText(Languages.get("srTipps"));
        tipp1.setText(Languages.get("srTipp1"));
        tipp1a.setText(Languages.get("srTipp1a"));
        tipp2.setText(Languages.get("srTipp2"));
        tipp2a.setText(Languages.get("srTipp2a"));
        tipp3.setText(Languages.get("srTipp3"));
        tipp3a.setText(Languages.get("srTipp3a"));
        tipp4.setText(Languages.get("srTipp4"));
        tipp4a.setText(Languages.get("srTipp4a"));
        tipp5.setText(Languages.get("srTipp5"));
        tipp5a.setText(Languages.get("srTipp5a"));
        tipp6.setText(Languages.get("srTipp6"));
        //endregion

        /*Uses a function to show the dropdown menu*/
        //region Dropdown Menu
        drpdwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v);
            }
        });
        //endregion

        /*Switches intents back to all habits*/
        //region Back to habits
        backToHabits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent habits = new Intent(spareResourcesActivity, HabitsActivity.class);
                startActivity(habits);
                finish();
            }
        });
        //endregion

        /*on clicking the join button, the userID is getting transferred to the join habit from Habit class
         *along with the german, english and bar name of the habit*/
        //region Join
        JoinHabitFromHabit joining = new JoinHabitFromHabit("Spare resources", "Ressourcen schonen","spareResources");
        joining.execute();
        //endregion
    }

    /**Makes dropdown Menu appear*/
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
            Intent langs = new Intent(spareResourcesActivity, LanguageActivity.class);
            startActivity(langs);
            finish();
        }
        else if(clicked.equals(Languages.get("imprint")))
        {
            Intent imprint = new Intent(spareResourcesActivity, ImprintActivity.class);
            startActivity(imprint);
            finish();
        }
        else if(clicked.equals(Languages.get("website")))
        {
            AlertDialog.Builder notification = new AlertDialog.Builder(spareResourcesActivity);
            notification.setMessage(Languages.get("note"));
            notification.setPositiveButton("Ok", null);
            notification.setCancelable(true);
            notification.create().show();
        }
        else if(clicked.equals(Languages.get("home")))
        {
            Intent home = new Intent(spareResourcesActivity, HomeActivity.class);
            startActivity(home);
            finish();
        }
        else if(clicked.equals(Languages.get("calendar")))
        {
            Intent cal = new Intent(spareResourcesActivity, CalendarActivity.class);
            startActivity(cal);
            finish();
        }
        else if(clicked.equals(Languages.get("habits")))
        {
            Intent habits = new Intent(spareResourcesActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
        }
        else if(clicked.equals(Languages.get("myHabits")))
        {
            Intent myHabits = new Intent(spareResourcesActivity, MyHabitsActivity.class);
            startActivity(myHabits);
            finish();
        }

    }

    /**Switches intent as soon as physical back button from
     * phone is pressed*/
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            Intent habits = new Intent(spareResourcesActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
