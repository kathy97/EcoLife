package com.example.ecolife.menu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.ecolife.Calendar.CalendarActivity;
import com.example.ecolife.MyHabitsActivity;
import com.example.ecolife.R;
import com.example.ecolife.home.HomeActivity;
import com.example.ecolife.otherClasses.Languages;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ImprintActivity extends AppCompatActivity {

    /**Defines all needed Buttons, TextViews, Edits etc.*/
    //region Buttons und so
    FloatingActionButton drpdwn;
    TextView title;
    TextView h1;
    TextView h2;
    TextView c1;
    TextView h3;
    TextView c3;
    ImageButton back;
    final ImprintActivity imprintActivity = this;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imprint);

        /*Contains all assignments from needed Buttons, TextViews, Edits etc.*/
        //region Zuweisungen
        title = findViewById(R.id.Title);
        h1 = findViewById(R.id.headline1);
        c1 = findViewById(R.id.content1);
        h2 = findViewById(R.id.headline2);
        h3 = findViewById(R.id.headline3);
        c3 =findViewById(R.id.content3);
        back = findViewById(R.id.backButton);
        //endregion

        /*Set all texts out of language class*/
        //region Texts
        title.setText(Languages.get("imprintTitle"));
        h1.setText(Languages.get("personalData"));
        c1.setText(Languages.get("myData"));
        h2.setText(Languages.get("aboutApp"));
        h3.setText(Languages.get("copyRight"));
        c3.setText(Languages.get("crContent"));
        //endregion

        /*Uses one of two functions to show the dropdown menu, depending on the userID*/
        //region Dropdown Menu  & vor LOG In
        drpdwn = findViewById(R.id.dropdownmenu);

        drpdwn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showMenu(v);
            }
        });
        //endregion

        /*Switches intents on button click depending on userID either to LoginActivity
         * or HomeActivity*/
        //region back
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(imprintActivity, HomeActivity.class);
                startActivity(home);
                finish();
            }
        });
        //endregion
    }

    /**used for dropdown menu contain a class to show the dropdown menu and give each menu item a name
     * and a class to make menu items clickable and open the wanted intent.
     */

    //region Dropdown Menu
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
            Intent langs = new Intent(imprintActivity, LanguageActivity.class);
            startActivity(langs);
            finish();
        }
        else if(clicked.equals(Languages.get("imprint")))
        {
            Intent imprint = new Intent(imprintActivity, ImprintActivity.class);
            startActivity(imprint);
            finish();
        }
        else if(clicked.equals(Languages.get("website")))
        {
            AlertDialog.Builder notification = new AlertDialog.Builder(imprintActivity);
            notification.setMessage(Languages.get("note"));
            notification.setPositiveButton("Ok", null);
            notification.setCancelable(true);
            notification.create().show();
        }
        else if(clicked.equals(Languages.get("home")))
        {
            Intent home = new Intent(imprintActivity, HomeActivity.class);
            startActivity(home);
            finish();
        }
        else if(clicked.equals(Languages.get("calendar")))
        {
            Intent cal = new Intent(imprintActivity, CalendarActivity.class);
            startActivity(cal);
            finish();
        }
        else if(clicked.equals(Languages.get("habits")))
        {
            Intent habits = new Intent(imprintActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
        }
        else if(clicked.equals(Languages.get("myHabits")))
        {
            Intent myHabits = new Intent(imprintActivity, MyHabitsActivity.class);
            startActivity(myHabits);
            finish();
        }

    }
    //endregion


    /**Switches intents on pressed physical back button of phone depending on userID either to LoginActivity
     * or HomeActivity*/
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            Intent home = new Intent(imprintActivity, HomeActivity.class);
            startActivity(home);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
