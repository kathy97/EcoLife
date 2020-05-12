package com.example.ecolife.Calendar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.ecolife.MyHabitsActivity;
import com.example.ecolife.database.DBManager;
import com.example.ecolife.database.GetDoneHabits;
import com.example.ecolife.home.HomeActivity;
import com.example.ecolife.menu.HabitsActivity;
import com.example.ecolife.menu.ImprintActivity;
import com.example.ecolife.menu.LanguageActivity;
import com.example.ecolife.R;
import com.example.ecolife.otherClasses.Languages;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class SingleDateActivity extends AppCompatActivity {

    /**Defines different buttons, editTexts and variables (static and non static), such as finals*/
    //region Buttons, Variablen und so
    String Month;
    String Day;
    final SingleDateActivity singleDateActivity = this;
    FloatingActionButton dropdown;
    TextView displayDate;
    TextView sepWasteName;
    TextView recyclingName;
    TextView upcyclingName;
    TextView reducePlasticName;
    TextView nutritionName;
    TextView vegetarianName;
    TextView veganName;
    TextView reuseBagName;
    TextView reuseCupName;
    TextView reuseBottleName;
    TextView spareResourcesName;
    TextView saveWaterName;
    TextView savePowerName;
    TextView carFreeName;
    TextView consumerName;
    TextView zeroWasteName;
    TextView noStrawsName;
    TextView localSeasonalName;
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

    ImageButton goToHome;
    ImageButton goToCalendar;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_date);

        /*Contains all the assignments from Buttons, TextEdits etc.
        * such as a few variables*/
        //region Zuweisungen und Variablen

       int date = (int) getIntent().getExtras().get("day");
       int month = (int) getIntent().getExtras().get("month");
       int year = (int) getIntent().getExtras().get("year");



       String choosenDate;
       dropdown =findViewById(R.id.dropdownmenu);
       displayDate = findViewById(R.id.dateShown);

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
        recyclingName = findViewById(R.id.recycleName);
        upcyclingName = findViewById(R.id.upcyclingName);
        reducePlasticName = findViewById(R.id.reducePlasticName);
        nutritionName = findViewById(R.id.nutritionName);
        vegetarianName = findViewById(R.id.vegetarianName);
        veganName = findViewById(R.id.veganName);
        reuseBagName = findViewById(R.id.reuseBagName);
        reuseCupName = findViewById(R.id.reuseCupName);
        reuseBottleName = findViewById(R.id.reuseBottleName);
        spareResourcesName = findViewById(R.id.spareResourcesName);
        saveWaterName = findViewById(R.id.saveWaterName);
        savePowerName = findViewById(R.id.savePowerName);
        carFreeName = findViewById(R.id.carFreeName);
        consumerName = findViewById(R.id.consumerName);
        zeroWasteName = findViewById(R.id.zeroWasteName);
        noStrawsName = findViewById(R.id.noStrawsName);
        localSeasonalName = findViewById(R.id.localSeasonalName);

        goToCalendar = findViewById(R.id.goCalendar);
        goToHome = findViewById(R.id.goHome);
       //endregion

        /*Sets all texts and hint, get content from Languages.class*/
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
        //endregion

        /*sets the month to a two digit number, in this case to a two digit number string */
        //region Month with two Digits
        if(month == 1)
        {
            Month = "01";
        }
        else if(month == 2)
        {
            Month = "02";
        }
        else if(month ==3)
        {
            Month = "03";
        }
        else if(month ==4)
        {
            Month = "04";
        }
        else if (month == 5)
        {
            Month = "05";
        }
        else if(month ==6)
        {
            Month = "06";
        }
        else if(month ==7)
        {
            Month = "07";
        }
        else if(month ==8)
        {
            Month = "08";
        }
        else if(month ==9)
        {
            Month = "09";
        }

        else if (month == 10)
        {
            Month = "10";
        }
        else if(month ==11)
        {
            Month = "11";
        }
        else if(month ==12)
        {
            Month = "12";
        }
        //endregion

        //region Day with two Digits
        if(date == 1)
        {
            Day = "01";
        }
        else if(date ==2)
        {
            Day = "02";
        }
        else if(date==3)
        {
            Day ="03";
        }
        else if(date==4)
        {
            Day="04";
        }
        else if (date ==5)
        {
            Day = "05";
        }
        else if(date==6)
        {
            Day = "06";
        }
        else if(date == 7)
        {
            Day = "07";
        }
        else if(date==8)
        {
            Day = "08";
        }
        else if(date==9)
        {
            Day = "09";
        }
        else
        {
            Day = Integer.toString(date);
        }
        Log.d("datum", Day);
        //endregion

        /*the variable choosenDate is a combined string and contains date, month and year separated with a dot.
        *The date gets displayed
        *In the class to get done Habits, its selected with userID and the choosenDate, such as the activity we are in right now*/
        //region get Habits from Db and selected date
        choosenDate = Day+"."+Month+"."+year;
        displayDate.setText(choosenDate);

        GetDoneHabits getDoneHabits = new GetDoneHabits(singleDateActivity, choosenDate);
        getDoneHabits.execute();
        //endregion

        /*commented alert to check if date is right*/
        //region Test ob Datum richtig
        /*
        AlertDialog.Builder day = new AlertDialog.Builder(singleDateActivity);
        day.setMessage("der ausgewählte tag lautet " + date + "." + motnh + "." + year);
        day.setPositiveButton("Ok", null);
        day.setCancelable(true);
        day.create().show();
         */
        //endregion


        /*Uses function to show the DropDownMenu*/
        //region Dropdown Menu show
        dropdown.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showMenu(v);
            }
        });
        //endregion

        /*image button which switches to home activity*/
        //region go to homepage
        goToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(singleDateActivity, HomeActivity.class);
                startActivity(home);
                finish();
            }
        });
        //endregion

        /*image button which switches to calendar activity*/
        //region back to calendar
        goToCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calendar = new Intent(singleDateActivity, CalendarActivity.class);
                startActivity(calendar);
                finish();
            }
        });
        //endregion
    }

    /**Sets the habit bar visible if it is done that day**/
    public void setVisible(List<String> myHabits)
    {

        for(String habit : myHabits) {

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
            Intent langs = new Intent(singleDateActivity, LanguageActivity.class);
            startActivity(langs);
            finish();
        }
        else if(clicked.equals(Languages.get("imprint")))
        {
            Intent imprint = new Intent(singleDateActivity, ImprintActivity.class);
            startActivity(imprint);
            finish();
        }
        else if(clicked.equals(Languages.get("website")))
        {
            AlertDialog.Builder notification = new AlertDialog.Builder(singleDateActivity);
            notification.setMessage(Languages.get("note"));
            notification.setPositiveButton("Ok", null);
            notification.setCancelable(true);
            notification.create().show();
        }
        else if(clicked.equals(Languages.get("home")))
        {
            Intent home = new Intent(singleDateActivity, HomeActivity.class);
            startActivity(home);
            finish();
        }
        else if(clicked.equals(Languages.get("calendar")))
        {
            Intent cal = new Intent(singleDateActivity, CalendarActivity.class);
            startActivity(cal);
            finish();
        }

        else if(clicked.equals(Languages.get("habits")))
        {
            Intent habits = new Intent(singleDateActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
        }
        else if(clicked.equals(Languages.get("myHabits")))
        {
            Intent myHabits = new Intent(singleDateActivity, MyHabitsActivity.class);
            startActivity(myHabits);
            finish();
        }


    }

    /**Shows a message if there is no done habit for the choosen day**/
    public void noDoneHabitsThisDay()
    {
        AlertDialog.Builder noHabitsDone = new AlertDialog.Builder(singleDateActivity);
        noHabitsDone.setMessage(Languages.get("noDoneHabits"));
        noHabitsDone.setPositiveButton("Ok", null);
        noHabitsDone.setCancelable(true);
        noHabitsDone.create().show();
    }

}
