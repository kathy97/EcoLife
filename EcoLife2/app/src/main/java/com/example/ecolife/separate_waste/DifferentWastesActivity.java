package com.example.ecolife.separate_waste;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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

public class DifferentWastesActivity extends AppCompatActivity
{
    /**Defines all Buttons, TextViews/Edits and so on*/
    //region Buttons und so
    FloatingActionButton drpdwn;
    TextView title;

    Button plasticW;
    Button residualW;
    Button paperW;
    Button glassW;
    Button ecoW;
    Button otherW;
    ImageButton backB;
    TextView hint;
    Button join;
    Button backtoHabits;
    final DifferentWastesActivity differentWastesActivity = this;
    //endregion

    @Override
    protected void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_different_wastes);

        /*Contains all assignments for used Buttons, TextViews etc.*/
        //region Zuweisungen
        drpdwn = findViewById(R.id.dropdownmenu);
        title = findViewById(R.id.sepWasteTitle);

        plasticW = findViewById(R.id.plasticButton);
        residualW = findViewById(R.id.residualButton);
        paperW = findViewById(R.id.paperButton);
        glassW = findViewById(R.id.glassButton);
        ecoW = findViewById(R.id.ecoButton);
        otherW = findViewById(R.id.otherButton);
        backB = findViewById(R.id.backButton);
        hint = findViewById(R.id.hint);
        join = findViewById(R.id.Join);
        backtoHabits = findViewById(R.id.backToHabits);
        //endregion

        /*Sets all texts out of language class*/
        //region Texts
        title.setText(Languages.get("sepWasteTitle"));
        plasticW.setText(Languages.get("plastic"));
        paperW.setText(Languages.get("paper"));
        residualW.setText(Languages.get("residual"));
        glassW.setText(Languages.get("glass"));
        ecoW.setText(Languages.get("eco"));
        otherW.setText(Languages.get("other"));
        hint.setText(Languages.get("sepWasteHint"));
        join.setText(Languages.get("JoinHabit"));
        backtoHabits.setText(Languages.get("BackToHabits"));
        //endregion

        /*Uses a function to show dropdown Menu*/
        //region Dropdown Menu
        drpdwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                showMenu(v);
            }
        });
        //endregion

        /*Is a button click event to switch intents back to all habits*/
        //region Back to habits
        backtoHabits.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent habits = new Intent(differentWastesActivity, HabitsActivity.class);
                startActivity(habits);
                finish();
            }
        });
        //endregion

        /*Is a button click event to switch one intent back to separate Waste activity*/
        //region One step back
        backB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               Intent sepWaste = new Intent(differentWastesActivity, SeparateWasteActivity.class);
               startActivity(sepWaste);
               finish();
            }
        });
        //endregion

        /*Transfers UserID, german and english habit name, such as bar name to another class to add habit in database*/
        //region Join
        join.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                JoinHabitFromHabit joining = new JoinHabitFromHabit("Separate waste", "Müll trennen", "separateWaste");
                joining.execute();
            }
        });
        //endregion

        /*Switches intents to plastic waste*/
        //region Plastic
        plasticW.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent plastic = new Intent(differentWastesActivity, PlasticActivity.class);
                startActivity(plastic);
                finish();
            }
        });
        //endregion

        /*Switches intents to residual waste*/
        //region Residual
        residualW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent residual = new Intent(differentWastesActivity, ResidualActivity.class);
                startActivity(residual);
                finish();
            }
        });

        //endregion


        /*Switches intents to paper waste*/
        //region Paper
        paperW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paper = new Intent(differentWastesActivity, PaperActivity.class);
                startActivity(paper);
                finish();
            }
        });
        //endregion

        /*Switches intents to glass waste*/
        //region Glass
        glassW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent glass = new Intent(differentWastesActivity, GlassActivity.class);
                startActivity(glass);
                finish();
            }
        });
        //endregion

        /*Switches intents to eco waste*/
        //region Eco
        ecoW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent eco = new Intent(differentWastesActivity, EcoActivity.class);
                startActivity(eco);
                finish();
            }
        });
        //endregion

        /*Switches intents to other waste*/
        //region Other
        otherW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent other = new Intent(differentWastesActivity, OtherActivity.class);
                startActivity(other);
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
            Intent langs = new Intent(differentWastesActivity, LanguageActivity.class);
            startActivity(langs);
            finish();
        }
        else if(clicked.equals(Languages.get("imprint")))
        {
            Intent imprint = new Intent(differentWastesActivity, ImprintActivity.class);
            startActivity(imprint);
            finish();
        }
        else if(clicked.equals(Languages.get("website")))
        {
            AlertDialog.Builder notification = new AlertDialog.Builder(differentWastesActivity);
            notification.setMessage(Languages.get("note"));
            notification.setPositiveButton("Ok", null);
            notification.setCancelable(true);
            notification.create().show();
        }
        else if(clicked.equals(Languages.get("home")))
        {
            Intent home = new Intent(differentWastesActivity, HomeActivity.class);
            startActivity(home);
            finish();
        }
        else if(clicked.equals(Languages.get("calendar")))
        {
            Intent cal = new Intent(differentWastesActivity, CalendarActivity.class);
            startActivity(cal);
            finish();
        }
        else if(clicked.equals(Languages.get("habits")))
        {
            Intent habits = new Intent(differentWastesActivity, HabitsActivity.class);
            startActivity(habits);
            finish();
        }
        else if(clicked.equals(Languages.get("myHabits")))
        {
            Intent myHabits = new Intent(differentWastesActivity, MyHabitsActivity.class);
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
            Intent sepWaste = new Intent(differentWastesActivity, SeparateWasteActivity.class);
            startActivity(sepWaste);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**Opens plastic waste intent on click of the image*/
    public void openPlastic(View v)
    {
        Intent plastic = new Intent(differentWastesActivity,PlasticActivity.class);
        startActivity(plastic);
        finish();
    }

    /**Opens glass waste intent on click of the image*/
    public void openGlass(View v)
    {
        Intent glass = new Intent(differentWastesActivity,GlassActivity.class);
        startActivity(glass);
        finish();
    }

    /**Opens residual waste intent on click of the image*/
    public void openResidual(View v)
    {
        Intent residual = new Intent(differentWastesActivity,ResidualActivity.class);
        startActivity(residual);
        finish();
    }

    /**Opens paper waste intent on click of the image*/
    public void openPaper(View v)
    {
        Intent paper = new Intent(differentWastesActivity, PaperActivity.class);
        startActivity(paper);
        finish();
    }

    /**Opens eco waste intent on click of the image*/
    public void openEco(View v)
    {
        Intent eco = new Intent(differentWastesActivity, EcoActivity.class);
        startActivity(eco);
        finish();
    }

    /**Opens other waste intent on click of the image*/
    public void openOther(View v)
    {
        Intent other = new Intent(differentWastesActivity, OtherActivity.class);
        startActivity(other);
        finish();
    }
}
