package com.example.user.drawer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, AdapterView.OnItemSelectedListener {

    EditText input;
    TextView output;
    Button convert;
    Spinner spinner_from, spinner_to;
    String [] countries = {"Dollar", "Pound"};
    int[] images = {R.drawable.usa, R.drawable.britain};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent =new Intent(Intent.ACTION_SEND);
                intent.setType("text/plane");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                if(intent.resolveActivity(getPackageManager())!= null){
                    startActivity(intent);
                }
            }
        });
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        input = (EditText)findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);

        spinner_from = (Spinner)findViewById(R.id.spinner_from);
        spinner_from.setOnItemSelectedListener(this);

        spinner_to = (Spinner)findViewById(R.id.spinner_to);
        spinner_to.setOnItemSelectedListener(this);

        convert = (Button)this.findViewById(R.id.convert);
        convert.setOnClickListener(this);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, countries);

        Adapter adapter = new Adapter(this, countries, images);
        spinner_from.setAdapter(dataAdapter);
        spinner_to.setAdapter(dataAdapter);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        /*
        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } */
        if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

                    Intent intent =new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plane");
                    intent.putExtra(Intent.EXTRA_TEXT, "");
                    if(intent.resolveActivity(getPackageManager())!= null){
                        startActivity(intent);
                    }



        } else if (id == R.id.nav_about) {
            Intent intent = new Intent(this, About.class);
            startActivity(intent);
 }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        convertToSelected(spinner_from.getSelectedItem().toString(), spinner_to.getSelectedItem().toString());

    }
    public void convertToSelected(String from, String to){
        double inputValue;
        double convertedValue;
        String outputValue;
        try{
            inputValue = new Double(input.getText().toString());

            if(from.equals("Birr")) {
                if (to.equals("Birr")) {
                    convertedValue = inputValue;
                    outputValue = String.format("%.1f", convertedValue);
                    output.setText(inputValue + " Birr is " + outputValue + " Birr");
                }else  if (to.equals("Dollar")){
                    convertedValue = inputValue / 27;
                    outputValue = String.format("%.3f", convertedValue);
                    output.setText(inputValue + " Birr is " + outputValue + " Dollar");
                }else if(to.equals("Euro")){
                    convertedValue = inputValue / 29;
                    outputValue = String.format("%.3f", convertedValue);
                    output.setText(inputValue + " Birr is " + outputValue + " Euro");
                }else if(to.equals("Pound")){
                    convertedValue = inputValue / 30;
                    outputValue = String.format("%.3f", convertedValue);
                    output.setText(inputValue + " Birr is " + outputValue + " Pound");
                }
            }else  if(from.equals("Dollar")){
                if (to.equals("Birr")) {
                    convertedValue = inputValue * 27;
                    outputValue = String.format("%.3f", convertedValue);
                    output.setText(inputValue + " Dollar is " + outputValue + " Birr");
                }else  if (to.equals("Dollar")){
                    convertedValue = inputValue;
                    outputValue = String.format("%.1f", convertedValue);
                    output.setText(inputValue + " Dollar is " + outputValue + " Dollar");
                }else if(to.equals("Euro")){
                    convertedValue = inputValue / 29;
                    outputValue = String.format("%.3f", convertedValue);
                    output.setText(inputValue + " Dollar is " + outputValue + " Euro");
                }else if(to.equals("Pound")){
                    convertedValue = inputValue / 30;
                    outputValue = String.format("%.3f", convertedValue);
                    output.setText(inputValue + " Dollar is " + outputValue + " Pound");
                }
            }else if(from.equals("Pound")){
                if (to.equals("Birr")) {
                    convertedValue = inputValue;
                    outputValue = String.format("%.3f", convertedValue);
                    output.setText(inputValue + " Pound is " + outputValue + " Birr");
                }else  if (to.equals("Dollar")){
                    convertedValue = inputValue / 27;
                    outputValue = String.format("%.3f", convertedValue);
                    output.setText(inputValue + " Pound is " + outputValue + " Dollar");
                }else if(to.equals("Euro")){
                    convertedValue = inputValue / 29;
                    outputValue = String.format("%.3f", convertedValue);
                    output.setText(inputValue + " Pound is " + outputValue + " Euro");
                }else if(to.equals("Pound")){
                    convertedValue = inputValue;
                    outputValue = String.format("%.1f", convertedValue);
                    output.setText(inputValue + " Pound is " + outputValue + " Pound");
                }
            }else if(from.equals("Euro")){
                if (to.equals("Birr")) {
                    convertedValue = inputValue;
                    outputValue = String.format("%.3f", convertedValue);
                    output.setText(inputValue + " Euro is " + outputValue + "  Birr");
                }else  if (to.equals("Dollar")){
                    convertedValue = inputValue / 27;
                    outputValue = String.format("%.3f", convertedValue);
                    output.setText(inputValue + " Euro is " + outputValue + " Dollar");
                }else if(to.equals("Euro")){
                    convertedValue = inputValue;
                    outputValue = String.format("%.1f", convertedValue);
                    output.setText(inputValue + " Euro is " + outputValue + " Euro");
                }else if(to.equals("Pound")){
                    convertedValue = inputValue / 30;
                    outputValue = String.format("%.3f", convertedValue);
                    output.setText(inputValue + " Euro is " + outputValue + " Pound");
                }
            }

        }catch(NumberFormatException e){
            output.setText("Empty input");

        }catch (Exception e){
            output.setText("Sorry!, something is wrong!");
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Selected " + item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
