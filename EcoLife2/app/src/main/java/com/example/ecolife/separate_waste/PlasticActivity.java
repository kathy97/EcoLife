package com.example.ecolife.separate_waste;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ecolife.Calendar.CalendarActivity;
import com.example.ecolife.MyHabitsActivity;
import com.example.ecolife.R;
import com.example.ecolife.home.HomeActivity;
import com.example.ecolife.menu.HabitsActivity;
import com.example.ecolife.menu.ImprintActivity;
import com.example.ecolife.menu.LanguageActivity;
import com.example.ecolife.otherClasses.Languages;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PlasticActivity extends AppCompatActivity
{

    /**Defines all needed Buttons, TextViews, Edits etc.*/
    //region Buttons und so
    TextView sepWasteTitle;
    TextView plasticTitle;
    TextView headlineBottles;
    TextView headlinesTins;
    TextView headlinePacks;
    TextView contentBottles;
    TextView contentTins;
    TextView contentPacks;

    ImageButton back;
    FloatingActionButton drpdwn;
    final PlasticActivity plasticActivity = this;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plastic);

        /*Contains all assignments from needed Buttons, TextViews, Edits etc.*/
        //region Zuweisungen
        sepWasteTitle = findViewById(R.id.sepWasteTitle);
        plasticTitle = findViewById(R.id.TitlePlastic);
        headlineBottles = findViewById(R.id.plasticBottlesFor);
        contentBottles = findViewById(R.id.hint);
        headlinesTins = findViewById(R.id.TinsandSo);
        contentTins = findViewById(R.id.ThoseTins);
        headlinePacks = findViewById(R.id.Packs);
        contentPacks = findViewById(R.id.ThosePacks);
        back = findViewById(R.id.backButton);
        drpdwn = findViewById(R.id.dropdownmenu);
        //endregion

        /*Set all texts out of language class*/
        //region Texts
        sepWasteTitle.setText(Languages.get("sepWasteTitle"));
        plasticTitle.setText(Languages.get("plasticTitle"));
        headlineBottles.setText(Languages.get("headlineBottles"));
        contentBottles.setText(Languages.get("contentBottles"));
        headlinesTins.setText(Languages.get("headlineTins"));
        contentTins.setText(Languages.get("contentTins"));
        headlinePacks.setText(Languages.get("headlinePacks"));
        contentPacks.setText(Languages.get("contentPacks"));
        //endregion

        /*Uses a function to show dropdown menu*/
        //region Dropdown Menu
        drpdwn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showMenu(v);
            }
        });
        //endregion

        /*Switches intents one step back to different wastes*/
        //region Back
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent different = new Intent(plasticActivity, DifferentWastesActivity.class);
                startActivity(different);
                finish();
            }
        });
        //endregion
    }

    /**Makes menu appear
     * Gives MenuItems their names*/
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
            Intent langs = new Intent(plasticActivity, LanguageActivity.class);
            startActivity(langs);
            finish();
        }
        else if(clicked.equals(Languages.get("imprint")))
        {
            Intent imprint = new Intent(plasticActivity, ImprintActivity.class);
            startActivity(imprint);
            finish();
        }
        else if(clicked.equals(Languages.get("website")))
        {
            AlertDialog.Builder notification = new AlertDialog.Builder(plasticActivity);
            notification.setMessage(Languages.get("note"));
            notification.setPositiveButton("Ok", null);
            notification.setCancelable(true);
            notification.create().show();
        }
        else if(clicked.equals(Languages.get("home")))
        {
            Intent home = new Intent(plasticActivity, HomeActivity.class);
            startActivity(home);
            finish();
        }
        else if(clicked.equals(Languages.get("calendar")))
        {
            Intent cal = new Intent(plasticActivity, CalendarActivity.class);
            startActivity(cal);
            finish();
        }

        else if(clicked.equals(Languages.get("habits")))
        {
            Intent habits = new Intent(plasticActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
        }
        else if(clicked.equals(Languages.get("myHabits")))
        {

            Intent myHabits = new Intent(plasticActivity, MyHabitsActivity.class);
            startActivity(myHabits);
            finish();
        }
    }

    /**Switches intent if physical back button from phone is pressed*/
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            Intent difWaste = new Intent(plasticActivity, DifferentWastesActivity.class);
            startActivity(difWaste);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
