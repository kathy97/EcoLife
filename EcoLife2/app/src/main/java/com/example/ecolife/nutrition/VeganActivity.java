package com.example.ecolife.nutrition;

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

public class VeganActivity extends AppCompatActivity {

    /**Defines all needed Buttons, TextViews, Edits etc.*/
    //region Buttons und so
    FloatingActionButton drpdwn;
    Button link1;
    Button link2;
    Button link3;
    Button link4;
    Button link5;
    Button backToHabits;
    Button join;

    TextView title;
    TextView inGeneral;
    TextView igContent;
    TextView why;
    TextView veganOne;
    TextView veganTwo;
    TextView veganThree;
    TextView veganFour;
    TextView veganFive;
    TextView veganSix;
    TextView veryImportant;
    TextView veryImpContent;
    TextView linksTitle;
    TextView linksContent;

    final VeganActivity veganActivity = this;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegan);

        /*Contains all assignments from needed Buttons, TextViews, Edits etc.*/
        //region Zuweisungen
        drpdwn = findViewById(R.id.dropdownmenu);
        backToHabits = findViewById(R.id.backToHabits);
        join = findViewById(R.id.Join);
        link1 = findViewById(R.id.link1);
        link2 = findViewById(R.id.link2);
        link3 = findViewById(R.id.link3);
        link4 = findViewById(R.id.link4);
        link5 = findViewById(R.id.link5);

        title = findViewById(R.id.veganTitle);
        inGeneral = findViewById(R.id.veganIg);
        igContent = findViewById(R.id.veganContent);
        why =findViewById(R.id.veganWhy);
        veganOne = findViewById(R.id.veganOne);
        veganTwo =findViewById(R.id.veganTwo);
        veganThree = findViewById(R.id.veganThree);
        veganFour = findViewById(R.id.veganFour);
        veganFive  = findViewById(R.id.veganFive);
        veganSix = findViewById(R.id.veganSix);
        veryImportant = findViewById(R.id.veryImportant);
        veryImpContent = findViewById(R.id.importantDisclaimer);
        linksTitle = findViewById(R.id.interestingLinks);
        linksContent = findViewById(R.id.websiteDisclaimer);
        //endregion

        /*Set all texts out of language class*/
        //region Texts
        title.setText(Languages.get("vegan_Title"));
        inGeneral.setText(Languages.get("veganIg"));
        igContent.setText(Languages.get("veganIgContent"));
        why.setText(Languages.get("veganWhy"));
        veganOne.setText(Languages.get("veganOne"));
        veganTwo.setText(Languages.get("veganTwo"));
        veganThree.setText(Languages.get("veganThree"));
        veganFour.setText(Languages.get("veganFour"));
        veganFive.setText(Languages.get("veganFive"));
        veganSix.setText(Languages.get("veganSix"));
        veryImportant.setText(Languages.get("veganVeryImp"));
        veryImpContent.setText(Languages.get("veganVeryImpContent"));
        linksTitle.setText(Languages.get("veganLinks"));
        linksContent.setText(Languages.get("veganLinksContent"));

        backToHabits.setText(Languages.get("BackToHabits"));
        join.setText(Languages.get("JoinHabit"));
        link1.setText(Languages.get("veganLink1"));
        link2.setText(Languages.get("veganLink2"));
        link3.setText(Languages.get("veganLink3"));
        link4.setText(Languages.get("veganLink4"));
        link5.setText(Languages.get("veganLink5"));
        //endregion

        /*uses a function to show the dropown menu*/
        //region DropdownMenu
        drpdwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v);
            }
        });
        //endregion

        /*Switches Intents back to all habits*/
        //region back to habits
        backToHabits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent habits = new Intent(veganActivity, HabitsActivity.class);
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
                JoinHabitFromHabit joining = new JoinHabitFromHabit("Vegan", "Vegan","vegan");
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
            Intent langs = new Intent(veganActivity, LanguageActivity.class);
            startActivity(langs);
            finish();
        }
        else if(clicked.equals(Languages.get("imprint")))
        {
            Intent imprint = new Intent(veganActivity, ImprintActivity.class);
            startActivity(imprint);
            finish();
        }
        else if(clicked.equals(Languages.get("website")))
        {
            AlertDialog.Builder notification = new AlertDialog.Builder(veganActivity);
            notification.setMessage(Languages.get("note"));
            notification.setPositiveButton("Ok", null);
            notification.setCancelable(true);
            notification.create().show();
        }
        else if(clicked.equals(Languages.get("home")))
        {
            Intent home = new Intent(veganActivity, HomeActivity.class);
            startActivity(home);
            finish();
        }
        else if(clicked.equals(Languages.get("calendar")))
        {
            Intent cal = new Intent(veganActivity, CalendarActivity.class);
            startActivity(cal);
            finish();
        }
        else if(clicked.equals(Languages.get("habits")))
        {
            Intent habits = new Intent(veganActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
        }
        else if(clicked.equals(Languages.get("myHabits")))
        {
            Intent myHabits = new Intent(veganActivity, MyHabitsActivity.class);
            startActivity(myHabits);
            finish();
        }

    }

    /**Opens two links about veganism
     * German: is about vegan nutrition being healthy or risky
     * English: is also about health*/
    public void openInfolink(View v)
    {
        if(Languages.getCurrentLanguage().equals(Languages.Lang.GERMAN)) {
            Intent link1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.medizin-transparent.at/veganismus-gesund-oder-riskant"));
            startActivity(link1);
        }
        else if (Languages.getCurrentLanguage().equals(Languages.Lang.ENGLISH))
        {
            Intent link2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bbc.com/news/health-49579820"));
            startActivity(link2);
        }
    }

    /**Opens two links about veganism
     * German: is about how healthy living vegan is
     * English: is about what happens to body and brain when living vegan*/
    public void openAnotherInfolink(View v)
    {
        if(Languages.getCurrentLanguage().equals(Languages.Lang.GERMAN)) {
            Intent link3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.geo.de/natur/nachhaltigkeit/14710-rtkl-ernaehrung-wie-gesund-ist-vegan"));
            startActivity(link3);
        }
        else if (Languages.getCurrentLanguage().equals(Languages.Lang.ENGLISH))
        {
            Intent link4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.insider.com/what-happens-to-your-body-brain-when-you-go-vegan-10-2019"));
            startActivity(link4);
        }
    }

    /**Opens two links about veganism
     * German: is about influencer who had a hormonal disturbance
     * English: is about how to live vegan without hurting your health*/
    public void openMoreInfolinks(View v)
    {
        if(Languages.getCurrentLanguage().equals(Languages.Lang.GERMAN)) {
            Intent link5 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://kurier.at/gesund/hormonstoerung-bei-influencerin-wie-gesund-ist-vegane-ernaehrung/400456063"));
            startActivity(link5);
        }
        else if (Languages.getCurrentLanguage().equals(Languages.Lang.ENGLISH))
        {
            Intent link6 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bustle.com/p/how-to-go-vegan-without-hurting-your-health-according-to-doctors-19194632"));
            startActivity(link6);
        }
    }

    /**Opens two links about veganism
     * German: is about why vegan is good
     * English: is about top 10 reasons to go vegan*/
    public void openEvenMoreInfolinks(View v)
    {
        if(Languages.getCurrentLanguage().equals(Languages.Lang.GERMAN)) {
            Intent link7 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://albert-schweitzer-stiftung.de/aktuell/warum-vegan"));
            startActivity(link7);
        }
        else if (Languages.getCurrentLanguage().equals(Languages.Lang.ENGLISH))
        {
            Intent link8 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.peta.org/living/food/top-10-reasons-go-vegan-new-year/"));
            startActivity(link8);
        }
    }

    /**Opens two links about veganism
     * German: is about why vegan is good
     * English: is about why vegan is good too*/
    public void openLastInfolink(View v)
    {
        if(Languages.getCurrentLanguage().equals(Languages.Lang.GERMAN)) {
            Intent link9 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.veganblatt.com/t/warum-vegan"));
            startActivity(link9);
        }
        else if (Languages.getCurrentLanguage().equals(Languages.Lang.ENGLISH))
        {
            Intent link10 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://veganoutreach.org/why-vegan/"));
            startActivity(link10);
        }
    }

    /**if physical back button from phone is pressed, intent switches
     * back to all habits*/
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
           Intent habits = new Intent(veganActivity, HabitsActivity.class);
           startActivity(habits);
           finish();
           return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
