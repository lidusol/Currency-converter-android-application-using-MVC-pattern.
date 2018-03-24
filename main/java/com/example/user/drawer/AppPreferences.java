package com.example.user.drawer;

import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AppPreferences extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_preferences);

    }

    public static  class SettingsFragment extends PreferenceFragment{
        @Override
                public void onCreate(Bundle savedInstanceState){
                    super.onCreate(savedInstanceState);

                    addPreferencesFromResource(R.xml.app_preferences);
        }
    }
}
