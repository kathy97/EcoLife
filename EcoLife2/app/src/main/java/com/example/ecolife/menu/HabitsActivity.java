package com.example.ecolife.menu;

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
import com.example.ecolife.database.DBManager;
import com.example.ecolife.habits.habits.CarFreeActivity;
import com.example.ecolife.habits.habits.ConsumerActivity;
import com.example.ecolife.R;
import com.example.ecolife.habits.habits.LocalSeasonalActivity;
import com.example.ecolife.habits.habits.NoStrawsActivity;
import com.example.ecolife.habits.habits.SavePowerActivity;
import com.example.ecolife.habits.habits.SaveWaterActivity;
import com.example.ecolife.habits.habits.SpareResourcesActivity;
import com.example.ecolife.habits.habits.ZeroWasteActivity;
import com.example.ecolife.habits.habits.ReducePlasticActivity;
import com.example.ecolife.habits.habits.UpcycleActivity;
import com.example.ecolife.habits.habits.RecycleActivity;
import com.example.ecolife.database.JoinHabit;
import com.example.ecolife.separate_waste.SeparateWasteActivity;
import com.example.ecolife.home.HomeActivity;
import com.example.ecolife.nutrition.NutritionActivity;
import com.example.ecolife.nutrition.VeganActivity;
import com.example.ecolife.nutrition.VegetarianActivity;
import com.example.ecolife.otherClasses.Languages;
import com.example.ecolife.reuse.ReuseBagActivity;
import com.example.ecolife.reuse.ReuseBottleActivity;
import com.example.ecolife.reuse.ReuseCupActivity;
import com.example.ecolife.reuse.ReuseInfoActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HabitsActivity extends AppCompatActivity {

    /**Defines all needed Buttons, TextViews, Edits etc.*/
    //region Buttons und so weiter
    FloatingActionButton drpdwn;
    final HabitsActivity habitsActivity = this;

    TextView sepWasteTitle;
    TextView sepWasteDesc;
    Button sepWasteDescButton;
    Button sepWasteJoin;

    TextView recycleTitle;
    TextView recycleDesc;
    Button recycleDescButton;
    Button recycleJoin;

    TextView upcycleTitle;
    TextView upcycleDesc;
    Button upcycleDescButton;
    Button upcycleJoin;

    TextView reducePlTitle;
    TextView reducePlDesc;
    Button reducePlDescButton;
    Button reducePlJoin;

    TextView nutrTitle;
    TextView nutrDesc;
    Button nutrDescButton;
    Button nutrJoin;

    TextView vegetarianTitle;
    TextView vegetarianDesc;
    Button vegeatarianDescButton;
    Button vegetarianJoin;

    TextView veganTitle;
    TextView veganDesc;
    Button veganDescButton;
    Button veganJoin;

    TextView reuseInfoTitle;
    TextView reuseInfoDesc;
    Button reuseInfoDescButton;

    TextView reuseBagTitle;
    TextView reuseBagDesc;
    Button reuseBagDescButton;
    Button reuseBagJoin;

    TextView reuseCupTitle;
    TextView reuseCupDesc;
    Button reuseCupDescButton;
    Button reuseCupJoin;

    TextView reuseBottleTitle;
    TextView reuseBottleDesc;
    Button reuseBottleDescButton;
    Button reuseBottleJoin;

    TextView resourceTitle;
    TextView resourceDesc;
    Button resourceDescButton;
    Button resourceJoin;

    TextView saveWaterTitle;
    TextView saveWaterDesc;
    Button saveWaterDescButton;
    Button saveWaterJoin;

    TextView savePowerTitle;
    TextView savePowerDesc;
    Button savePowerDescButton;
    Button savePowerJoin;

    TextView carfreeTitle;
    TextView carfreeDesc;
    Button carfreeDescButton;
    Button carfreeJoin;

    TextView consumerTitle;
    TextView consumerDesc;
    Button consumerDescButton;
    Button consumerJoin;

    TextView zeroWasteTitle;
    TextView zeroWasteDesc;
    Button zeroWasteDescButton;
    Button zeroWasteJoin;

    TextView noStrawsTitle;
    TextView noStrawDesc;
    Button noStrawsDescButton;
    Button noStrawsJoin;

    TextView regSaisTitle;
    TextView regSaisDesc;
    Button regSaisDescButton;
    Button regSaisJoin;

    TextView habits;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habits);

        /*Contains all assignments from needed Buttons, TextViews, Edits, etc.*/
        //region Zuweisungen und so
        drpdwn = findViewById(R.id.dropdownmenu);

        sepWasteTitle = findViewById(R.id.seperateWaste);
        sepWasteDesc = findViewById(R.id.sepWasteShortDesc);
        sepWasteDescButton = findViewById(R.id.sepWasteDescButton);
        sepWasteJoin = findViewById(R.id.sepWasteJoinButton);

        recycleTitle = findViewById(R.id.recycle);
        recycleDesc =findViewById(R.id.recycleShortDesc);
        recycleDescButton = findViewById(R.id.recycleDescButton);
        recycleJoin = findViewById(R.id.recycleJoin);

        upcycleTitle = findViewById(R.id.upcyclingTitle);
        upcycleDesc = findViewById(R.id.upcycleShortDesc);
        upcycleDescButton = findViewById(R.id.upcycleDescButton);
        upcycleJoin = findViewById(R.id.upcycleJoin);

        reducePlTitle = findViewById(R.id.reducePlasticTitle);
        reducePlDesc = findViewById(R.id.reducePlasticShortDesc);
        reducePlDescButton = findViewById(R.id.reducePlasticDescButton);
        reducePlJoin = findViewById(R.id.reducePlasticJoin);

        nutrTitle =findViewById(R.id.nutritionTitle);
        nutrDesc = findViewById(R.id.nutritionShortDesc);
        nutrDescButton = findViewById(R.id.nutritionDescButton);
        nutrJoin = findViewById(R.id.nutritionJoin);

        vegetarianTitle = findViewById(R.id.vegetarianTitle);
        vegetarianDesc = findViewById(R.id.vegetarianShortDesc);
        vegeatarianDescButton = findViewById(R.id.vegetarianDescButton);
        vegetarianJoin = findViewById(R.id.vegetarianJoin);

        veganTitle = findViewById(R.id.veganTitle);
        veganDesc = findViewById(R.id.veganShortDesc);
        veganDescButton = findViewById(R.id.veganDescButton);
        veganJoin = findViewById(R.id.veganJoin);

        reuseInfoTitle = findViewById(R.id.reuseInfoTitle);
        reuseInfoDesc = findViewById(R.id.reuseInfoShortDesc);
        reuseInfoDescButton = findViewById(R.id.reuseInfoDescButton);

        reuseBagTitle = findViewById(R.id.reuseBagTitle);
        reuseBagDesc = findViewById(R.id.reuseBagShortDesc);
        reuseBagDescButton = findViewById(R.id.reuseBagDescButton);
        reuseBagJoin = findViewById(R.id.reuseBagJoin);

        reuseCupTitle = findViewById(R.id.reuseCupTitle);
        reuseCupDesc = findViewById(R.id.reuseCupShortDesc);
        reuseCupDescButton= findViewById(R.id.reuseCupDescButton);
        reuseCupJoin = findViewById(R.id.reuseCupJoin);

        reuseBottleTitle = findViewById(R.id.reuseBottleTitle);
        reuseBottleDesc = findViewById(R.id.reuseBottleShortDesc);
        reuseBottleDescButton = findViewById(R.id.reuseBottleDescButton);
        reuseBottleJoin = findViewById(R.id.reuseBottleJoin);

        resourceTitle = findViewById(R.id.resourcesTitle);
        resourceDesc = findViewById(R.id.resourcesShortDesc);
        resourceDescButton= findViewById(R.id.resourcesDescButton);
        resourceJoin = findViewById(R.id.resourcesJoin);

        saveWaterTitle = findViewById(R.id.saveWaterTitle);
        saveWaterDesc = findViewById(R.id.saveWaterShortDesc);
        saveWaterDescButton = findViewById(R.id.saveWaterDescButton);
        saveWaterJoin = findViewById(R.id.saveWaterJoin);

        savePowerTitle = findViewById(R.id.savePowerTitle);
        savePowerDesc = findViewById(R.id.savePowerShortDesc);
        savePowerDescButton = findViewById(R.id.savePowerDescButton);
        savePowerJoin = findViewById(R.id.savePowerJoin);

        carfreeTitle = findViewById(R.id.carFreeTitle);
        carfreeDesc = findViewById(R.id.carFreeShortDesc);
        carfreeDescButton = findViewById(R.id.carFreeDescButton);
        carfreeJoin = findViewById(R.id.carFreeJoin);

        consumerTitle = findViewById(R.id.consumerTitle);
        consumerDesc = findViewById(R.id.consumerShortDesc);
        consumerDescButton = findViewById(R.id.consumerDescButton);
        consumerJoin = findViewById(R.id.consumerJoin);

        zeroWasteTitle = findViewById(R.id.zeroWasteTitle);
        zeroWasteDesc = findViewById(R.id.zeroWasteShortDesc);
        zeroWasteDescButton = findViewById(R.id.zeroWasteDescButton);
        zeroWasteJoin = findViewById(R.id.zeroWasteJoin);

        noStrawsTitle = findViewById(R.id.noStrawsTitle);
        noStrawDesc = findViewById(R.id.noStrawsShortDesc);
        noStrawsDescButton = findViewById(R.id.noStrawsDescButton);
        noStrawsJoin = findViewById(R.id.noStrawsJoin);

        regSaisTitle = findViewById(R.id.regsaisTitle);
        regSaisDesc = findViewById(R.id.regsaisShortDesc);
        regSaisDescButton = findViewById(R.id.regsaisDescButton);
        regSaisJoin =findViewById(R.id.regsaisJoin);

        habits = findViewById(R.id.titleHabits);
        //endregion

        /*Sets all texts out of language class*/
        //region Texts
        sepWasteTitle.setText(Languages.get("sepWTitle"));
        sepWasteDesc.setText(Languages.get("sepWDesc"));
        sepWasteDescButton.setText(Languages.get("DescButton"));
        sepWasteJoin.setText(Languages.get("JoinButton"));

        recycleTitle.setText(Languages.get("recTitle"));
        recycleDesc.setText(Languages.get("recDesc"));
        recycleDescButton.setText(Languages.get("DescButton"));
        recycleJoin.setText(Languages.get("JoinButton"));

        upcycleTitle.setText(Languages.get("upcTitle"));
        upcycleDesc.setText(Languages.get("upcDesc"));
        upcycleDescButton.setText(Languages.get("DescButton"));
        upcycleJoin.setText(Languages.get("JoinButton"));

        reducePlTitle.setText(Languages.get("redPlTitle"));
        reducePlDesc.setText(Languages.get("redPlDesc"));
        reducePlDescButton.setText(Languages.get("DescButton"));
        reducePlJoin.setText(Languages.get("JoinButton"));

        nutrTitle.setText(Languages.get("nutrTitle"));
        nutrDesc.setText(Languages.get("nutrDesc"));
        nutrDescButton.setText(Languages.get("DescButton"));
        nutrJoin.setText(Languages.get("JoinButton"));

        vegetarianTitle.setText(Languages.get("veggieTitle"));
        vegetarianDesc.setText(Languages.get("veggieDesc"));
        vegeatarianDescButton.setText(Languages.get("DescButton"));
        vegetarianJoin.setText(Languages.get("JoinButton"));

        veganTitle.setText(Languages.get("veganTitle"));
        veganDesc.setText(Languages.get("veganDesc"));
        veganDescButton.setText(Languages.get("DescButton"));
        veganJoin.setText(Languages.get("JoinButton"));

        reuseInfoTitle.setText(Languages.get("reuseInfoTitle"));
        reuseInfoDesc.setText(Languages.get("reuseInfoDesc"));
        reuseInfoDescButton.setText(Languages.get("DescButton"));

        reuseBagTitle.setText(Languages.get("reuseBagTitle"));
        reuseBagDesc.setText(Languages.get("reuseBagDesc"));
        reuseBagDescButton.setText(Languages.get("DescButton"));
        reuseBagJoin.setText(Languages.get("JoinButton"));

        reuseCupTitle.setText(Languages.get("reuseCupTitle"));
        reuseCupDesc.setText(Languages.get("reuseCupDesc"));
        reuseCupDescButton.setText(Languages.get("DescButton"));
        reuseCupJoin.setText(Languages.get("JoinButton"));

        reuseBottleTitle.setText(Languages.get("reuseBottleTitle"));
        reuseBottleDesc.setText(Languages.get("reuseBottleDesc"));
        reuseBottleDescButton.setText(Languages.get("DescButton"));
        reuseBottleJoin.setText(Languages.get("JoinButton"));

        resourceTitle.setText(Languages.get("resTitle"));
        resourceDesc.setText(Languages.get("resDesc"));
        resourceDescButton.setText(Languages.get("DescButton"));
        resourceJoin.setText(Languages.get("JoinButton"));

        saveWaterTitle.setText(Languages.get("swTitle"));
        saveWaterDesc.setText(Languages.get("swDesc"));
        saveWaterDescButton.setText(Languages.get("DescButton"));
        saveWaterJoin.setText(Languages.get("JoinButton"));

        savePowerTitle.setText(Languages.get("spTitle"));
        savePowerDesc.setText(Languages.get("spDesc"));
        savePowerDescButton.setText(Languages.get("DescButton"));
        savePowerJoin.setText(Languages.get("JoinButton"));

        carfreeTitle.setText(Languages.get("cfTitle"));
        carfreeDesc.setText(Languages.get("cfDesc"));
        carfreeDescButton.setText(Languages.get("DescButton"));
        carfreeJoin.setText(Languages.get("JoinButton"));

        consumerTitle.setText(Languages.get("conTitle"));
        consumerDesc.setText(Languages.get("conDesc"));
        consumerDescButton.setText(Languages.get("DescButton"));
        consumerJoin.setText(Languages.get("JoinButton"));

        zeroWasteTitle.setText(Languages.get("zwTitle"));
        zeroWasteDesc.setText(Languages.get("zwDesc"));
        zeroWasteDescButton.setText(Languages.get("DescButton"));
        zeroWasteJoin.setText(Languages.get("JoinButton"));

        noStrawsTitle.setText(Languages.get("noStrTitle"));
        noStrawDesc.setText(Languages.get("noStrDesc"));
        noStrawsDescButton.setText(Languages.get("DescButton"));
        noStrawsJoin.setText(Languages.get("JoinButton"));

        regSaisTitle.setText(Languages.get("rsTitle"));
        regSaisDesc.setText(Languages.get("rsDesc"));
        regSaisDescButton.setText(Languages.get("DescButton"));
        regSaisJoin.setText(Languages.get("JoinButton"));

        habits.setText(Languages.get("habitsTitle"));
        //endregion

        /*Uses function to show dropdown menu*/
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


        /*All of the next 19 regions except REUSE INFO contains a button click event to join a habit
        *
        *Transfers UserID, german and english habit name, such as bar name to another class to add habit in database*/

        /*Switches Intent to separate Waste habit*/
        //region Separate waste
        //region Description
        sepWasteDescButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent sepWaste = new Intent(habitsActivity, SeparateWasteActivity.class);
                startActivity(sepWaste);
                finish();
            }
        });
        //endregion

        //region Join
        sepWasteJoin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                JoinHabit joining = new JoinHabit("Separate waste", "Müll trennen", "separateWaste", habitsActivity);
                joining.execute();
            }
        });
        //endregion
        //endregion

        /*Switches Intent to recycle habit*/
        //region Recycle
        //region Description
        recycleDescButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent recycle = new Intent(habitsActivity, RecycleActivity.class);
                startActivity(recycle);
                finish();
            }
        });
        //endregion

        //region Join
        recycleJoin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                JoinHabit joining = new JoinHabit("Recycle", "Recycle","recycle",habitsActivity);
                joining.execute();
            }
        });
        //endregion
        //endregion

        /*Switches Intent to upcycle habit*/
        //region Upcycle
            //region Description
            upcycleDescButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent upcycle = new Intent(habitsActivity, UpcycleActivity.class);
                    startActivity(upcycle);
                    finish();

                }
            });
            //endregion

            //region Join
            upcycleJoin.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    JoinHabit joining = new JoinHabit("Upcycle", "Upcycle", "upcycle",habitsActivity);
                    joining.execute();
                }
            });
            //endregion
        //endregion

        /*Switches Intent to reduce plastic habit*/
        //region Reduce plastic
            //region Description
            reducePlDescButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent redPlastic = new Intent(habitsActivity, ReducePlasticActivity.class);
                    startActivity(redPlastic);
                    finish();
                }
            });
            //endregion

            //region Join
            reducePlJoin.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    JoinHabit joining = new JoinHabit("Reduce plastic", "Plastik reduzieren","reducePlastic",habitsActivity);
                    joining.execute();
                }
            });
            //endregion
        //endregion

        /*Switches Intent to nutrition habit*/
        //region Nutrition
            //region Description
            nutrDescButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent nutri = new Intent(habitsActivity, NutritionActivity.class);
                    startActivity(nutri);
                    finish();
                }
            });
            //endregion

            //region Join
            nutrJoin.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    JoinHabit joining = new JoinHabit("Nutrition", "Ernährung","nutrition",habitsActivity);
                    joining.execute();
                }
            });
            //endregion
        //endregion

        /*Switches Intent to vegetarian habit*/
        //region Vegetarian
            //region Description
            vegeatarianDescButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent veg = new Intent(habitsActivity, VegetarianActivity.class);
                    startActivity(veg);
                    finish();
                }
            });
            //endregion

            //region Join
            vegetarianJoin.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    JoinHabit joining = new JoinHabit("Vegetarian", "Vegetarisch","vegetarian",habitsActivity);
                    joining.execute();
                }
            });
            //endregion
        //endregion

        /*Switches Intent to vegan habit*/
        //region Vegan
            //region Description
            veganDescButton.setOnClickListener(new View.OnClickListener()
            {
            @Override
            public void onClick(View v)
            {
                Intent vegan = new Intent(habitsActivity, VeganActivity.class);
                startActivity(vegan);
                finish();
            }
             });
            //endregion

            //region Join
            veganJoin.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    JoinHabit joining = new JoinHabit("Vegan", "Vegan","vegan",habitsActivity);
                    joining.execute();
                }
            });
            //endregion
        //endregion

        /*Switches Intent to reuse info activity*/
        //region Reuse Info
        reuseInfoDescButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent reuseInfo = new Intent(habitsActivity, ReuseInfoActivity.class);
                startActivity(reuseInfo);
                finish();
            }
        });
        //endregion

        /*Switches Intent to reuse bag habit*/
        //region Reusable bags
            //region Desc
            reuseBagDescButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent reuseBag = new Intent(habitsActivity, ReuseBagActivity.class);
                    startActivity(reuseBag);
                    finish();

                }
            });
            //endregion

            //region Join
            reuseBagJoin.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    JoinHabit joining = new JoinHabit("Reusable bags", "Wiederverwendbare Taschen","reuseBag",habitsActivity);
                    joining.execute();
                }
            });
            //endregion
        //endregion

        /*Switches Intent to reuse cup habit*/
        //region Reusable cups
            //region Desc
            reuseCupDescButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent reuseCup = new Intent(habitsActivity, ReuseCupActivity.class);
                    startActivity(reuseCup);
                    finish();
                }
            });
            //endregion

            //region Join
            reuseCupJoin.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    JoinHabit joining = new JoinHabit("Reusable cups", "Wiederverwendbare Becher","reuseCup",habitsActivity);
                    joining.execute();
                }
            });
            //endregion
        //endregion

        /*Switches Intent to reuse bottles habit*/
        //region Reusable bottles
            //region Desc
            reuseBottleDescButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent rBottle = new Intent(habitsActivity, ReuseBottleActivity.class);
                    startActivity(rBottle);
                    finish();
                }
            });
            //endregion

            //region Join
            reuseBottleJoin.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    JoinHabit joining = new JoinHabit("Reusable bottles", "Wiederverwendbare Flaschen","reuseBottle",habitsActivity);
                    joining.execute();
                }
            });
            //endregion
        //endregion

        /*Switches Intent to spare resources habit*/
        //region Spare resources
            //region Desc
            resourceDescButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent res = new Intent(habitsActivity, SpareResourcesActivity.class);
                    startActivity(res);
                    finish();
                }
            });
            //endregion

            //region Join
            resourceJoin.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    JoinHabit joining = new JoinHabit( "Spare resources", "Ressourcen schonen","spareResources",habitsActivity);
                    joining.execute();
                }
            });
            //endregion
        //endregion

        /*Switches Intent to save water habit*/
        //region Save water
            //region Desc
            saveWaterDescButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent saveWater = new Intent(habitsActivity, SaveWaterActivity.class);
                    startActivity(saveWater);
                    finish();
                }
            });
            //endregion

            //region Join
            saveWaterJoin.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    JoinHabit joining = new JoinHabit("Save water", "Wasser sparen","saveWater",habitsActivity);
                    joining.execute();
                }
            });
            //endregion
        //endregion

        /*Switches Intent to save power habit*/
        //region Save power
            //region Desc
            savePowerDescButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent savePower = new Intent(habitsActivity, SavePowerActivity.class);
                    startActivity(savePower);
                    finish();
                }
            });
            //endregion

            //region Join
        savePowerJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JoinHabit joining = new JoinHabit("Save power", "Strom sparen","savePower",habitsActivity);
                joining.execute();
            }
        });

            //endregion
        //endregion

        /*Switches Intent to car free habit*/
        //region Car free
            //region Desc
            carfreeDescButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent carFree = new Intent(habitsActivity, CarFreeActivity.class);
                    startActivity(carFree);
                    finish();
                }
            });
            //endregion

            //region Join
            carfreeJoin.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    JoinHabit joining = new JoinHabit("Car-Free", "Auto-Frei","carFree",habitsActivity);
                    joining.execute();
                }
            });
            //endregion
        //endregion

        /*Switches Intent to consumption behavior habit*/
        //region Consumption behavior
            //region Desc
            consumerDescButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent consumer = new Intent(habitsActivity, ConsumerActivity.class);
                    startActivity(consumer);
                    finish();
                }
            });
            //endregion

            //region Join
            consumerJoin.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    JoinHabit joining = new JoinHabit("Consumption behavior", "Konsumverhalten","consumer",habitsActivity);
                    joining.execute();
                }
            });
            //endregion
        //endregion

        /*Switches Intent to zero waste habit*/
        //region Zero-Waste
            //region Desc
            zeroWasteDescButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent zw = new Intent(habitsActivity, ZeroWasteActivity.class);
                    startActivity(zw);
                    finish();
                }
            });
            //endregion

            //region Join
            zeroWasteJoin.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    JoinHabit joining = new JoinHabit("Zero-Waste", "Zero-Waste","zeroWaste",habitsActivity);
                    joining.execute();

                }
            });
            //endregion
        //endregion

        /*Switches Intent to No straws habit*/
        //region No straws
            //region Desc
            noStrawsDescButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent noStraws = new Intent(habitsActivity, NoStrawsActivity.class);
                    startActivity(noStraws);
                    finish();
                }
            });
            //endregion

            //region Join
            noStrawsJoin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   JoinHabit joining = new JoinHabit("No straws", "Keine Strohhalme","noStraws", habitsActivity);
                    joining.execute();
                }
            });

            //endregion
        //endregion

        /*Switches Intent to local seasonal habit*/
        //region Local and Seasonal
            //region Desc
            regSaisDescButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent local = new Intent(habitsActivity, LocalSeasonalActivity.class);
                    startActivity(local);
                    finish();
                }
            });
            //endregion

            //region Join
            regSaisJoin.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    JoinHabit joining = new JoinHabit("Local and Seasonal", "Lokal und Saisonal","localSeasonal",habitsActivity);
                    joining.execute();
                }
            });
            //endregion
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
            Intent langs = new Intent(habitsActivity, LanguageActivity.class);
            startActivity(langs);
            finish();
        }
        else if(clicked.equals(Languages.get("imprint")))
        {
            Intent imprint = new Intent(habitsActivity, ImprintActivity.class);
            startActivity(imprint);
            finish();
        }
        else if(clicked.equals(Languages.get("website")))
        {
            AlertDialog.Builder notification = new AlertDialog.Builder(habitsActivity);
            notification.setMessage(Languages.get("note"));
            notification.setPositiveButton("Ok", null);
            notification.setCancelable(true);
            notification.create().show();
        }
        else if(clicked.equals(Languages.get("home")))
        {
            Intent home = new Intent(habitsActivity, HomeActivity.class);
            startActivity(home);
            finish();
        }
        else if(clicked.equals(Languages.get("calendar")))
        {
            Intent cal = new Intent(habitsActivity, CalendarActivity.class);
            startActivity(cal);
            finish();
        }
        else if(clicked.equals(Languages.get("habits")))
        {
            //aktuelle seite
        }
        else if(clicked.equals(Languages.get("myHabits")))
        {
            Intent myHabits = new Intent(habitsActivity, MyHabitsActivity.class);
            startActivity(myHabits);
            finish();
        }
    }

    /**If joining the habit was possible, user get alert that he/she successfully joined the habit*/
    public void AddingHabitSucceed()
    {
        AlertDialog.Builder succeed = new AlertDialog.Builder(habitsActivity);
        succeed.setMessage(Languages.get("addHabitSucceed"));
        succeed.setPositiveButton("Ok", null);
        succeed.setCancelable(true);
        succeed.create().show();

    }


    /**If user already joined the habit, he/she get an alert - joining again is not possible*/
    public void AlreadyJoined()
    {
        AlertDialog.Builder exists = new AlertDialog.Builder(habitsActivity);
        exists.setMessage(Languages.get("habitExists"));
        exists.setPositiveButton("Ok", null);
        exists.setCancelable(true);
        exists.create().show();
    }

    /**Switches intent if physical back button from phone is pressed*/
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            Intent home = new Intent(habitsActivity, HomeActivity.class);
            startActivity(home);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
