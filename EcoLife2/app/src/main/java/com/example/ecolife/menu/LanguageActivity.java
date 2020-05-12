package com.example.ecolife.menu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.ecolife.Calendar.CalendarActivity;
import com.example.ecolife.MyHabitsActivity;
import com.example.ecolife.R;
import com.example.ecolife.home.HomeActivity;
import com.example.ecolife.otherClasses.Languages;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LanguageActivity extends AppCompatActivity {

    /**Defines all needed Buttons, TextViews, Edits etc.*/
    //region Buttons und so
    Button german;
    Button english;
    FloatingActionButton dropdownMenu;
    TextView title;
    final LanguageActivity languageActivity = this;
    ImageButton back;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        /*Contains all assignments from needed Buttons, TextViews, Edits etc.*/
        //region Assignments
        german = findViewById(R.id.lang_German);
        english = findViewById(R.id.lang_English);
        dropdownMenu = findViewById(R.id.dropdownmenu);
        title = findViewById(R.id.TitleLang);
        back = findViewById(R.id.backButton);
        //endregion

        /*Set all texts out of language class*/
        //region texts
        title.setText(Languages.get("languageTitle"));
        //endregion

        /*Uses one of two functions to show the dropdown menu, depending on the userID*/
        //region Dropdown menu
        dropdownMenu.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showMenu(v);

            }
        });
        //endregion

        /*Switches languages to german*/
        //region German
        german.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Languages.setCurrentLanguage(Languages.Lang.GERMAN);
                title.setText(Languages.get("languageTitle"));
            }
        });
        //endregion

        /*Switches languages to english*/
        //region English
        english.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Languages.setCurrentLanguage(Languages.Lang.ENGLISH);
                title.setText(Languages.get("languageTitle"));
            }
        });
        //endregion

        /*Switches intents on button click depending on userID either to LoginActivity
         * or HomeActivity*/
        //region back
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(languageActivity, HomeActivity.class);
                startActivity(home);
                finish();
            }
        });
        //endregion
    }


    /** used for dropdown menu contain a class to show the dropdown menu and give each menu item a name
     * and a class to make menu items clickable and open the wanted intent.
     */
    //region Dropdown Menu post LogIn
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

    public void onMenuClick(MenuItem item)
    {
        String clicked = item.getTitle().toString();

        if(clicked.equals(Languages.get("languages")))
        {
            Intent langs = new Intent(languageActivity, LanguageActivity.class);
            startActivity(langs);
            finish();
        }
        else if(clicked.equals(Languages.get("imprint")))
        {
            Intent imprint = new Intent(languageActivity, ImprintActivity.class);
            startActivity(imprint);
            finish();
        }
        else if(clicked.equals(Languages.get("website")))
        {
            AlertDialog.Builder notification = new AlertDialog.Builder(languageActivity);
            notification.setMessage(Languages.get("note"));
            notification.setPositiveButton("Ok", null);
            notification.setCancelable(true);
            notification.create().show();
        }
        else if(clicked.equals(Languages.get("home")))
        {
            Intent home = new Intent(languageActivity, HomeActivity.class);
            startActivity(home);
            finish();
        }
        else if(clicked.equals(Languages.get("calendar")))
        {
            Intent cal = new Intent(languageActivity, CalendarActivity.class);
            startActivity(cal);
            finish();
        }
        else if(clicked.equals(Languages.get("habits")))
        {
            Intent habits = new Intent(languageActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
        }
        else if(clicked.equals(Languages.get("myHabits")))
        {
            Intent myHabits = new Intent(languageActivity, MyHabitsActivity.class);
            startActivity(myHabits);
            finish();
        }

    }
    //endregion


}
