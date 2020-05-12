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
import com.example.ecolife.database.DBManager;
import com.example.ecolife.database.JoinHabitFromHabit;
import com.example.ecolife.home.HomeActivity;
import com.example.ecolife.menu.HabitsActivity;
import com.example.ecolife.menu.ImprintActivity;
import com.example.ecolife.menu.LanguageActivity;
import com.example.ecolife.otherClasses.Languages;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ZeroWasteActivity extends AppCompatActivity
{
    /**Defines all used buttons and textViews...*/
    //region Buttons und so
    FloatingActionButton drpdwn;
    Button backToHabits;
    Button join;
    Button link;
    TextView title;
    TextView content;
    TextView how;
    TextView how1;
    TextView how1a;
    TextView alternatives;
    TextView original;
    TextView alt1;
    TextView org1;
    TextView alt2;
    TextView org2;
    TextView alt3;
    TextView org3;
    TextView alt4;
    TextView org4;
    TextView alt5;
    TextView org5;
    TextView alt6;
    TextView org6;
    TextView alt7;
    TextView org7;
    TextView alt8;
    TextView org8;
    TextView alt9;
    TextView org9;
    TextView alt10;
    TextView org10;
    TextView alt11;
    TextView org11;
    TextView alt12;
    TextView org12;
    TextView alt13;
    TextView org13;
    TextView alt14;
    TextView org14;
    TextView alt15;
    TextView org15;
    TextView alt16;
    TextView org16;
    TextView alt17;
    TextView org17;
    TextView alt18;
    TextView org18;
    TextView alt19;
    TextView org19;
    TextView alt20;
    TextView org20;
    TextView alt21;
    TextView org21;
    TextView alt22;
    TextView org22;
    TextView alt23;
    TextView org23;
    TextView alt24;
    TextView org24;
    TextView alt25;
    TextView org25;
    TextView alt26;
    TextView org26;
    final ZeroWasteActivity zeroWasteActivity = this;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zero_waste);

        /*Contains all assignments of buttons and TextViews*/
        //region Zuweisungen
        drpdwn = findViewById(R.id.dropdownmenu);
        backToHabits = findViewById(R.id.backToHabits);
        join = findViewById(R.id.join);
        link = findViewById(R.id.zeroWasteLink);
        title = findViewById(R.id.zwTitle);
        content = findViewById(R.id.zwContent);
        how = findViewById(R.id.zwHow);
        how1 = findViewById(R.id.zw1);
        how1a = findViewById(R.id.zw1a);
        alternatives = findViewById(R.id.Alternatives);
        original = findViewById(R.id.wfProduct);
        alt1 = findViewById(R.id.alt1);
        org1 = findViewById(R.id.org1);
        alt2 = findViewById(R.id.alt2);
        org2 = findViewById(R.id.org2);
        alt3 = findViewById(R.id.alt3);
        org3 = findViewById(R.id.org3);
        alt4 = findViewById(R.id.alt4);
        org4 = findViewById(R.id.org4);
        alt5 = findViewById(R.id.alt5);
        org5 = findViewById(R.id.org5);
        alt6 = findViewById(R.id.alt6);
        org6 = findViewById(R.id.org6);
        alt7 = findViewById(R.id.alt7);
        org7 = findViewById(R.id.org7);
        alt8 = findViewById(R.id.alt8);
        org8 = findViewById(R.id.org9);
        alt9 = findViewById(R.id.alt9);
        org9 = findViewById(R.id.org10);
        alt10 = findViewById(R.id.alt10);
        org10 = findViewById(R.id.org11);
        alt11 = findViewById(R.id.alt11);
        org11 = findViewById(R.id.org12);
        alt12 = findViewById(R.id.alt12);
        org12 = findViewById(R.id.org13);
        alt13 = findViewById(R.id.alt13);
        org13 = findViewById(R.id.org14);
        alt14 = findViewById(R.id.alt14);
        org14 = findViewById(R.id.org15);
        alt15 = findViewById(R.id.alt15);
        org15 = findViewById(R.id.org16);
        alt16 = findViewById(R.id.alt16);
        org16 = findViewById(R.id.org17);
        alt17 = findViewById(R.id.alt17);
        org17 = findViewById(R.id.org18);
        alt18 = findViewById(R.id.alt18);
        org18 = findViewById(R.id.org19);
        alt19 = findViewById(R.id.alt19);
        org19 = findViewById(R.id.org20);
        alt20 = findViewById(R.id.alt20);
        org20 = findViewById(R.id.org21);
        alt21 = findViewById(R.id.alt21);
        org21 = findViewById(R.id.org22);
        alt22 = findViewById(R.id.alt22);
        org22 = findViewById(R.id.org23);
        alt23 = findViewById(R.id.alt23);
        org23 = findViewById(R.id.org24);
        alt24 = findViewById(R.id.alt24);
        org24 = findViewById(R.id.org25);
        alt25 = findViewById(R.id.alt25);
        org25 = findViewById(R.id.org26);
        alt26 = findViewById(R.id.alt26);
        org26 = findViewById(R.id.org27);
        //endregion

        /*Sets all texts out of language class*/
        //region Texts
        backToHabits.setText(Languages.get("BackToHabits"));
        join.setText(Languages.get("JoinHabit"));
        title.setText(Languages.get("zeroWasteTitle"));
        content.setText(Languages.get("zwContent"));
        how.setText(Languages.get("zwHow"));
        how1.setText(Languages.get("zwHow1"));
        how1a.setText(Languages.get("zwHow1a"));
        alternatives.setText(Languages.get("zwAlternatives"));
        original.setText(Languages.get("zwOriginals"));
        alt1.setText(Languages.get("zwAlt1"));
        org1.setText(Languages.get("zwOrg1"));
        alt2.setText(Languages.get("zwAlt2"));
        org2.setText(Languages.get("zwOrg2"));
        alt3.setText(Languages.get("zwAlt3"));
        org3.setText(Languages.get("zwOrg3"));
        alt4.setText(Languages.get("zwAlt4"));
        org4.setText(Languages.get("zwOrg4"));
        alt5.setText(Languages.get("zwAlt5"));
        org5.setText(Languages.get("zwOrg5"));
        alt6.setText(Languages.get("zwAlt6"));
        org6.setText(Languages.get("zwOrg6"));
        alt7.setText(Languages.get("zwAlt7"));
        org7.setText(Languages.get("zwOrg7"));
        alt8.setText(Languages.get("zwAlt8"));
        org8.setText(Languages.get("zwOrg8"));
        alt9.setText(Languages.get("zwAlt9"));
        org9.setText(Languages.get("zwOrg9"));
        alt10.setText(Languages.get("zwAlt10"));
        org10.setText(Languages.get("zwOrg10"));
        alt11.setText(Languages.get("zwAlt11"));
        org11.setText(Languages.get("zwOrg11"));
        alt12.setText(Languages.get("zwAlt12"));
        org12.setText(Languages.get("zwOrg12"));
        alt13.setText(Languages.get("zwAlt13"));
        org13.setText(Languages.get("zwOrg13"));
        alt14.setText(Languages.get("zwAlt14"));
        org14.setText(Languages.get("zwOrg14"));
        alt15.setText(Languages.get("zwAlt15"));
        org15.setText(Languages.get("zwOrg15"));
        alt16.setText(Languages.get("zwAlt16"));
        org16.setText(Languages.get("zwOrg16"));
        alt17.setText(Languages.get("zwAlt17"));
        org17.setText(Languages.get("zwOrg17"));
        alt18.setText(Languages.get("zwAlt18"));
        org18.setText(Languages.get("zwOrg18"));
        alt19.setText(Languages.get("zwAlt19"));
        org19.setText(Languages.get("zwOrg19"));
        alt20.setText(Languages.get("zwAlt20"));
        org20.setText(Languages.get("zwOrg20"));
        alt21.setText(Languages.get("zwAlt21"));
        org21.setText(Languages.get("zwOrg21"));
        alt22.setText(Languages.get("zwAlt22"));
        org22.setText(Languages.get("zwOrg22"));
        alt23.setText(Languages.get("zwAlt23"));
        org23.setText(Languages.get("zwOrg23"));
        alt24.setText(Languages.get("zwAlt24"));
        org24.setText(Languages.get("zwOrg24"));
        alt25.setText(Languages.get("zwAlt25"));
        org25.setText(Languages.get("zwOrg25"));
        alt26.setText(Languages.get("zwAlt26"));
        org26.setText(Languages.get("zwOrg26"));
        link.setText(Languages.get("zwHacks"));
        //endregion

        /*uses a function to show dropdown menu*/
        //region DropdownMenu
        drpdwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v);
            }
        });
        //endregion

        /*Switches intent back to habits*/
        //region Back to Habits
        backToHabits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent habits = new Intent(zeroWasteActivity, HabitsActivity.class);
                startActivity(habits);
                finish();
            }
        });
        //endregion

        /*transfers userID and Habit name to join habit from habit class
        * and add it into database*/
        //region Join
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JoinHabitFromHabit joining = new JoinHabitFromHabit( "Zero-Waste", "Zero-Waste","zeroWaste");
                joining.execute();
            }
        });

        //endregion
    }

    /**Opens a german or an english link - depends on selected language
     * Both links are about zero waste */
    public void openLink(View v)
    {
        if(Languages.getCurrentLanguage().equals(Languages.Lang.GERMAN)) {
            Intent link3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.smarticular.net/zero-waste-tipps-im-alltag-muellvermeidung/"));
            startActivity(link3);
        }
        else if (Languages.getCurrentLanguage().equals(Languages.Lang.ENGLISH))
        {
            Intent link4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://treadingmyownpath.com/2018/12/06/instagram-zero-waste-hacks/"));
            startActivity(link4);
        }
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
            Intent langs = new Intent(zeroWasteActivity, LanguageActivity.class);
            startActivity(langs);
            finish();
        }
        else if(clicked.equals(Languages.get("imprint")))
        {
            Intent imprint = new Intent(zeroWasteActivity, ImprintActivity.class);
            startActivity(imprint);
            finish();
        }
        else if(clicked.equals(Languages.get("website")))
        {
            AlertDialog.Builder notification = new AlertDialog.Builder(zeroWasteActivity);
            notification.setMessage(Languages.get("note"));
            notification.setPositiveButton("Ok", null);
            notification.setCancelable(true);
            notification.create().show();
        }
        else if(clicked.equals(Languages.get("home")))
        {
            Intent home = new Intent(zeroWasteActivity, HomeActivity.class);
            startActivity(home);
            finish();
        }
        else if(clicked.equals(Languages.get("calendar")))
        {
            Intent cal = new Intent(zeroWasteActivity, CalendarActivity.class);
            startActivity(cal);
            finish();
        }
        else if(clicked.equals(Languages.get("habits")))
        {
            Intent habits = new Intent(zeroWasteActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
        }
        else if(clicked.equals(Languages.get("myHabits")))
        {
            Intent myHabits = new Intent(zeroWasteActivity, MyHabitsActivity.class);
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
            Intent habits = new Intent(zeroWasteActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
