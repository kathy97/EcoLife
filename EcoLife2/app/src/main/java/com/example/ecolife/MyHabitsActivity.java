package com.example.ecolife;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.ecolife.Calendar.CalendarActivity;

import com.example.ecolife.database.AddLogInDate;
import com.example.ecolife.database.DBManager;
import com.example.ecolife.database.DoneHabits;
import com.example.ecolife.database.GetLogInDate;
import com.example.ecolife.database.getChoosenHabits;
import com.example.ecolife.home.HomeActivity;
import com.example.ecolife.menu.HabitsActivity;
import com.example.ecolife.menu.ImprintActivity;
import com.example.ecolife.menu.LanguageActivity;
import com.example.ecolife.otherClasses.Languages;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MyHabitsActivity extends AppCompatActivity
{
    /**Defines all needed Buttons, TextViews/Edits etc.*/
    //region Buttons und so weiter
    FloatingActionButton drpdwn;
    TextView sepWasteName;
    CheckBox sepWasteDone;
    TextView recyclingName;
    CheckBox recyclingDone;
    TextView upcyclingName;
    CheckBox upcyclingDone;
    TextView reducePlasticName;
    CheckBox reducePlasticDone;
    TextView nutritionName;
    CheckBox nutritionDone;
    TextView vegetarianName;
    CheckBox vegetarianDone;
    TextView veganName;
    CheckBox veganDone;
    TextView reuseBagName;
    CheckBox reuseBagDone;
    TextView reuseCupName;
    CheckBox reuseCupDone;
    TextView reuseBottleName;
    CheckBox reuseBottleDone;
    TextView spareResourcesName;
    CheckBox spareResourcesDone;
    TextView saveWaterName;
    CheckBox saveWaterDone;
    TextView savePowerName;
    CheckBox savePowerDone;
    TextView carFreeName;
    CheckBox carFreeDone;
    TextView consumerName;
    CheckBox consumerDone;
    TextView zeroWasteName;
    CheckBox zeroWasteDone;
    TextView noStrawsName;
    CheckBox noStrawsDone;
    TextView localSeasonalName;
    CheckBox localSeasonalDone;
    LinearLayout separateWaste;
    LinearLayout recycle;
    LinearLayout upcycle;
    LinearLayout reducePlastic;
    LinearLayout nutrition;
    LinearLayout vegetarian;
    LinearLayout vegan;
    LinearLayout reuseBag;
    LinearLayout reuseCup;
    LinearLayout reuseBottle;
    LinearLayout spareResources;
    LinearLayout saveWater;
    LinearLayout savePower;
    LinearLayout carFree;
    LinearLayout consumer;
    LinearLayout zeroWaste;
    LinearLayout noStraws;
    LinearLayout localSeasonal;
    final MyHabitsActivity myHabitsActivity = this;
    List<String>habits = new ArrayList<>();
    TextView title;
    ImageButton backHome;

    String _date_;

    //endregion

    /**Defines all final string keys used for the checkboxes to let them stay
     * checked*/
    //region Need to save Checkbox checked
    boolean boolVariable = false;
    private static final String sepWasteKey = "sepWaste_Key";
    private static final String recycleKey = "recycle_Key";
    private static final String upcycleKey = "upcycle_Key";
    private static final String redPlasticKey = "redPlastic_Key";
    private static final String nutritionKey = "nutrition_Key";
    private static final String vegetarianKey = "vegetarian_Key";
    private static final String veganKey = "vegan_Key";
    private static final String reuseBagKey = "reuseBag_Key";
    private static final String reuseBottleKey = "reuseBottleKey";
    private static final String reuseCupKey = "reuseCup_Key";
    private static final String spareResKey = "spareRes_Key";
    private static final String saveWaterKey = "saveWater_Key";
    private static final String savePowerKey ="savePower_Key";
    private static final String carFreeKey = "carFree_Key";
    private static final String consumerKey = "consumer_Key";
    private static final String zeroWasteKey = "zeroWaste_Key";
    private static final String noStrawsKey = "noStraws_Key";
    private static final String localSeasonalKey ="localSeasonal_Key";

    SharedPreferences sharedPrefs = null;
    Map<String, CheckBox>habitsMap;
    String date_format;
    //endregion

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_habits);


        /*Contains all the assignments from needed Buttons, TextViews/Edits*/
        //region Zuweisungen
        title = findViewById(R.id.myHabitsTitle);
        drpdwn = findViewById(R.id.dropdownmenu);
        separateWaste = findViewById(R.id.separateWaste);
        recycle = findViewById(R.id.recycling);
        upcycle = findViewById(R.id.upcylcing);
        reducePlastic = findViewById(R.id.reducePlastic);
        nutrition = findViewById(R.id.nutrition);
        vegetarian = findViewById(R.id.vegetarian);
        vegan = findViewById(R.id.vegan);
        reuseBag = findViewById(R.id.reuseBag);
        reuseCup =findViewById(R.id.reuseCup);
        reuseBottle = findViewById(R.id.reuseBottle);
        spareResources = findViewById(R.id.spareResources);
        saveWater = findViewById(R.id.saveWater);
        savePower = findViewById(R.id.savePower);
        carFree = findViewById(R.id.carFree);
        consumer = findViewById(R.id.consumer);
        zeroWaste = findViewById(R.id.zeroWaste);
        noStraws = findViewById(R.id.noStraws);
        localSeasonal = findViewById(R.id.localSeasonal);

        sepWasteName = findViewById(R.id.sepWasteName);
        sepWasteDone = findViewById(R.id.sepWasteDone);
        recyclingName = findViewById(R.id.recycleName);
        recyclingDone = findViewById(R.id.recyclingDone);
        upcyclingName = findViewById(R.id.upcyclingName);
        upcyclingDone = findViewById(R.id.upcyclingDone);
        reducePlasticName = findViewById(R.id.reducePlasticName);
        reducePlasticDone = findViewById(R.id.reducePlasticDone);
        nutritionName = findViewById(R.id.nutritionName);
        nutritionDone = findViewById(R.id.nutritionDone);
        vegetarianName = findViewById(R.id.vegetarianName);
        vegetarianDone = findViewById(R.id.vegetarianDone);
        veganName = findViewById(R.id.veganName);
        veganDone = findViewById(R.id.veganDone);
        reuseBagName = findViewById(R.id.reuseBagName);
        reuseBagDone = findViewById(R.id.reuseBagDone);
        reuseCupName = findViewById(R.id.reuseCupName);
        reuseCupDone = findViewById(R.id.reuseCupDone);
        reuseBottleName = findViewById(R.id.reuseBottleName);
        reuseBottleDone = findViewById(R.id.reuseBottleDone);
        spareResourcesName = findViewById(R.id.spareResourcesName);
        spareResourcesDone = findViewById(R.id.spareResourcesDone);
        saveWaterName = findViewById(R.id.saveWaterName);
        saveWaterDone = findViewById(R.id.saveWaterDone);
        savePowerName = findViewById(R.id.savePowerName);
        savePowerDone = findViewById(R.id.savePowerDone);
        carFreeName = findViewById(R.id.carFreeName);
        carFreeDone = findViewById(R.id.carFreeDone);
        consumerName = findViewById(R.id.consumerName);
        consumerDone = findViewById(R.id.consumerDone);
        zeroWasteName = findViewById(R.id.zeroWasteName);
        zeroWasteDone = findViewById(R.id.zeroWasteDone);
        noStrawsName = findViewById(R.id.noStrawsName);
        noStrawsDone = findViewById(R.id.noStrawsDone);
        localSeasonalName = findViewById(R.id.localSeasonalName);
        localSeasonalDone = findViewById(R.id.localSeasonalDone);
        backHome = findViewById(R.id.goHome);

        sharedPrefs = getSharedPreferences("doneHabits", Context.MODE_PRIVATE);
        //endregion

        /*Sets all texts out of language class*/
        //region Texts
        sepWasteName.setText(Languages.get("sepWTitle"));
        recyclingName.setText(Languages.get("recTitle"));
        upcyclingName.setText(Languages.get("upcTitle"));
        reducePlasticName.setText(Languages.get("redPlTitle"));
        nutritionName.setText(Languages.get("nutrTitle"));
        vegetarianName.setText(Languages.get("veggieTitle"));
        veganName.setText(Languages.get("veganTitle"));
        reuseBagName.setText(Languages.get("reuseBagTitle"));
        reuseCupName.setText(Languages.get("reuseCupTitle"));
        reuseBottleName.setText(Languages.get("reuseBottleTitle"));
        spareResourcesName.setText(Languages.get("resTitle"));
        saveWaterName.setText(Languages.get("swTitle"));
        savePowerName.setText(Languages.get("spTitle"));
        carFreeName.setText(Languages.get("cfTitle"));
        consumerName.setText(Languages.get("conTitle"));
        zeroWasteName.setText(Languages.get("zwTitle"));
        noStrawsName.setText(Languages.get("noStrTitle"));
        localSeasonalName.setText(Languages.get("rsTitle"));

        title.setText(Languages.get("myHabitsTitle"));
        //endregion


        /*Uses a function to show the dropdown menu*/
        //region DropDownMenu
        drpdwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v);
            }
        });
        //endregion

        /*Gets all chosen Habits from the database, where the UserID is ... and saves them in a list.*/
        //region Get habits
        getChoosenHabits getHabits = new getChoosenHabits( this);
        getHabits.execute();
        //endregion


        /*gets the current date from the german area as a string beginning with day, month and year*/
        SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);
        final String dateFormat = date.format(new java.util.Date());
        date_format = dateFormat;

        /*Contains all Checkboxes in a map, so checkboxes later can stay checked*/
        //region Map
        habitsMap = new HashMap<>();
        habitsMap.put(sepWasteKey, sepWasteDone);
        habitsMap.put(recycleKey, recyclingDone);
        habitsMap.put(upcycleKey, upcyclingDone);
        habitsMap.put(redPlasticKey, reducePlasticDone);
        habitsMap.put(nutritionKey, nutritionDone);
        habitsMap.put(vegetarianKey, vegetarianDone);
        habitsMap.put(veganKey, veganDone);
        habitsMap.put(reuseBagKey, reuseBagDone);
        habitsMap.put(reuseBottleKey, reuseBottleDone);
        habitsMap.put(reuseCupKey, reuseCupDone);
        habitsMap.put(spareResKey, spareResourcesDone);
        habitsMap.put(saveWaterKey, saveWaterDone);
        habitsMap.put(savePowerKey, savePowerDone);
        habitsMap.put(carFreeKey, carFreeDone);
        habitsMap.put(consumerKey, consumerDone);
        habitsMap.put(zeroWasteKey, zeroWasteDone);
        habitsMap.put(noStrawsKey, noStrawsDone);
        habitsMap.put(localSeasonalKey, localSeasonalDone);
        //endregion




        /*if CheckBox is checked, habit name is transferred to DoneHabits class and saved in Database
        * along with current date and UserID
        *
        * Works for every habit, starting with  sepWasteDone and ending with region localSeasonalDone*/
        //region sepWasteDone
        sepWasteDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                DoneHabits done = new DoneHabits( dateFormat,"separateWaste");
                done.execute();

            }
        });
        //endregion


        //region recyclingDone
        recyclingDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DoneHabits done = new DoneHabits( dateFormat,"recycle" );
                done.execute();
            }
        });
        //endregion


        //region upcyclingDone
        upcyclingDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DoneHabits done = new DoneHabits( dateFormat,"upcycle" );
                done.execute();
            }
        });
        //endregion


        //region reducePlasticDone
        reducePlasticDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DoneHabits done = new DoneHabits( dateFormat,"reducePlastic" );
                done.execute();
            }
        });
        //endregion


        //region nutritionDone
        nutritionDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DoneHabits done = new DoneHabits( dateFormat,"nutrition");
                done.execute();
            }
        });
        //endregion


        //region vegetarianDone
        vegetarianDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DoneHabits done = new DoneHabits( dateFormat,"vegetarian");
                done.execute();
            }
        });
        //endregion


        //region veganDone
        veganDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DoneHabits done = new DoneHabits( dateFormat,"vegan" );
                done.execute();
            }
        });
        //endregion


        //region reuseBagDone
        reuseBagDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DoneHabits done = new DoneHabits( dateFormat,"reuseBag" );
                done.execute();
            }
        });
        //endregion


        //region reuseCupDone
        reuseCupDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DoneHabits done = new DoneHabits( dateFormat,"reuseCup" );
                done.execute();
            }
        });
        //endregion


        //region reuseBottleDone
        reuseBottleDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DoneHabits done = new DoneHabits( dateFormat,"reuseBottle" );
                done.execute();
            }
        });
        //endregion


        //region spareResourcesDone
        spareResourcesDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DoneHabits done = new DoneHabits( dateFormat,"spareResources" );
                done.execute();
            }
        });
        //endregion


        //region saveWaterDone
        saveWaterDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DoneHabits done = new DoneHabits( dateFormat,"saveWater" );
                done.execute();
            }
        });
        //endregion


        //region savePowerDone
        savePowerDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DoneHabits done = new DoneHabits( dateFormat,"savePower" );
                done.execute();
            }
        });
        //endregion


        //region carFreeDone
        carFreeDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DoneHabits done = new DoneHabits( dateFormat,"carFree" );
                done.execute();
            }
        });
        //endregion


        //region consumerDone
        consumerDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DoneHabits done = new DoneHabits( dateFormat,"consumer" );
                done.execute();
            }
        });
        //endregion


        //region zeroWasteDone
        zeroWasteDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DoneHabits done = new DoneHabits( dateFormat,"zeroWaste" );
                done.execute();
            }
        });
        //endregion


        //region noStrawsDone
        noStrawsDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DoneHabits done = new DoneHabits( dateFormat,"noStraws" );
                done.execute();
            }
        });
        //endregion


        //region localSeasonalDone
        localSeasonalDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DoneHabits done = new DoneHabits( dateFormat,"localSeasonal" );
                done.execute();
            }
        });
        //endregion


       /*Switches intents back to home activity*/
        //region Home
        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setupCheckedChangeListener(habitsMap);

                Intent home = new Intent(myHabitsActivity, HomeActivity.class);
                startActivity(home);
                finish();

            }
        });
        //endregion



        SimpleDateFormat date_ = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMANY);
        final String Date = date.format(new Date());
        String[] dateparts = Date.split("\\.");
        String Day = dateparts[0];
        String month_ = dateparts[1];
        String year = dateparts[2];
        _date_ = Day +"."+month_+"."+year;


        if (!HomeActivity.currentDate_.equalsIgnoreCase(dateFormat))
        {
            AddLogInDate addDate = new AddLogInDate(dateFormat);
            addDate.execute();
            loadValues(habitsMap);
            setupCheckedChangeListener(habitsMap);
        }
        else
        {
            loadValues(habitsMap);
            setupCheckedChangeListener(habitsMap);
        }

    }

    /**Creates a boolean variable and sets the elements from the map if checked on checked (permanently)
     * gets the boolean of the shared preferences*/
    public void loadValues(Map<String, CheckBox>habitsMap)
    {
        if (!HomeActivity.currentDate_.equalsIgnoreCase(date_format))
        {
            for(Map.Entry<String, CheckBox> checkboxEntry : habitsMap.entrySet())
            {

                final SharedPreferences.Editor edi = sharedPrefs.edit();
                edi.putBoolean(checkboxEntry.getKey(), false);
                edi.apply();

            }
        }
        else
        {
            for(Map.Entry<String, CheckBox> checkboxEntry : habitsMap.entrySet())
            {
                Boolean checked = sharedPrefs.getBoolean(checkboxEntry.getKey(),false);
                checkboxEntry.getValue().setChecked(checked);
            }
        }

    }

    /**makes checkbox appear checked after switching intents and closing app*/
    public void setupCheckedChangeListener(Map<String, CheckBox>habitsMap)
    {

        for (final Map.Entry<String, CheckBox> checkBoxEntry : habitsMap.entrySet()) {
            checkBoxEntry.getValue().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    final SharedPreferences.Editor ed = sharedPrefs.edit();
                    ed.putBoolean(checkBoxEntry.getKey(), b);
                    ed.apply();
                }

            });

        }

    }

    /**Sets joined habits visible, so user can check them if he/she had done them*/
    public void setVisible(List<String> myHabits)
    {

        Calendar calendar = Calendar.getInstance();
        for(String habit : myHabits) {
            /*
            AlertDialog.Builder day = new AlertDialog.Builder(myHabitsActivity);
            day.setMessage("habit  " + myHabits);
            day.setPositiveButton("Ok", null);
            day.setCancelable(true);
            day.create().show();
             */
            if(habit.equalsIgnoreCase("separateWaste"))
            {
                separateWaste.setVisibility(View.VISIBLE);
            }
            else if (habit.equalsIgnoreCase("recycle"))
            {
                recycle.setVisibility(View.VISIBLE);
            }
            else if(habit.equalsIgnoreCase("upcycle"))
            {
                upcycle.setVisibility(View.VISIBLE);
            }
            else if (habit.equalsIgnoreCase("reducePlastic"))
            {
                reducePlastic.setVisibility(View.VISIBLE);
            }
            else if(habit.equalsIgnoreCase("nutrition"))
            {
                nutrition.setVisibility(View.VISIBLE);
            }
            else if(habit.equalsIgnoreCase("vegetarian"))
            {
                vegetarian.setVisibility(View.VISIBLE);
            }
            else if(habit.equalsIgnoreCase("vegan"))
            {
                vegan.setVisibility(View.VISIBLE);
            }
            else if(habit.equalsIgnoreCase("reuseBag"))
            {
                reuseBag.setVisibility(View.VISIBLE);
            }
            else if(habit.equalsIgnoreCase("reuseCup"))
            {
                reuseCup.setVisibility(View.VISIBLE);
            }
            else if(habit.equalsIgnoreCase("reuseBottle"))
            {
                reuseBottle.setVisibility(View.VISIBLE);
            }
            else if(habit.equalsIgnoreCase("spareResources"))
            {
                spareResources.setVisibility(View.VISIBLE);
            }
            else if(habit.equalsIgnoreCase("saveWater"))
            {
                saveWater.setVisibility(View.VISIBLE);
            }
            else if(habit.equalsIgnoreCase("savePower"))
            {
                savePower.setVisibility(View.VISIBLE);
            }
            else if(habit.equalsIgnoreCase("carFree"))
            {
                carFree.setVisibility(View.VISIBLE);
            }
            else if(habit.equalsIgnoreCase("consumer"))
            {
                consumer.setVisibility(View.VISIBLE);
            }
            else if(habit.equalsIgnoreCase("zeroWaste"))
            {
                zeroWaste.setVisibility(View.VISIBLE);
            }
            else if(habit.equalsIgnoreCase("noStraws"))
            {
                noStraws.setVisibility(View.VISIBLE);
            }
            else if(habit.equalsIgnoreCase("localSeasonal"))
            {
                localSeasonal.setVisibility(View.VISIBLE);
            }

        }

    }

    /**If user do not have added habits jet, he/she will get an alert to add habits and
     * to check them if he/she had lived after them during the day*/
    public void noHabits()
    {

        AlertDialog.Builder noHabits = new AlertDialog.Builder(myHabitsActivity);
        noHabits.setTitle(Languages.get("noHabitsTitle"));
        noHabits.setMessage(Languages.get("noHabitsContent"));
        noHabits.setPositiveButton("Ok", null);
        noHabits.setCancelable(true);
        noHabits.create().show();
    }

    /**Makes dropdown menu appear
     * Gives each menu item the name out of language class*/
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
            setupCheckedChangeListener(habitsMap);
            Intent langs = new Intent(myHabitsActivity, LanguageActivity.class);
            startActivity(langs);
            finish();
        }
        else if(clicked.equals(Languages.get("imprint")))
        {
            setupCheckedChangeListener(habitsMap);
            Intent imprint = new Intent(myHabitsActivity, ImprintActivity.class);
            startActivity(imprint);
            finish();
        }
        else if(clicked.equals(Languages.get("website")))
        {
            AlertDialog.Builder notification = new AlertDialog.Builder(myHabitsActivity);
            notification.setMessage(Languages.get("note"));
            notification.setPositiveButton("Ok", null);
            notification.setCancelable(true);
            notification.create().show();
        }
        else if(clicked.equals(Languages.get("home")))
        {
            setupCheckedChangeListener(habitsMap);
            Intent home = new Intent(myHabitsActivity, HomeActivity.class);
            startActivity(home);
            finish();
        }
        else if(clicked.equals(Languages.get("calendar")))
        {
            setupCheckedChangeListener(habitsMap);
            Intent cal = new Intent(myHabitsActivity, CalendarActivity.class);
            startActivity(cal);
            finish();
        }
        else if(clicked.equals(Languages.get("habits")))
        {
            setupCheckedChangeListener(habitsMap);
            Intent habits = new Intent(myHabitsActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
        }
        else if(clicked.equals(Languages.get("myHabits")))
        {
            setupCheckedChangeListener(habitsMap);
            Intent myHabits = new Intent(myHabitsActivity, MyHabitsActivity.class);
            startActivity(myHabits);
            finish();
        }

    }

    /**if physical back button from phone is pressed, intent switches
     * back to home*/
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            setupCheckedChangeListener(habitsMap);
            Intent home = new Intent(myHabitsActivity, HomeActivity.class);
            startActivity(home);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}
