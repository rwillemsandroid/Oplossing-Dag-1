package be.vdab.simplelayout.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by RWIL on 08/09/2015.
 */
public class PreferencesHelper {

    private final static String PREF_NAME = "pref_name";


    public static String getNamePreference(Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(PREF_NAME, null);
    }

    public static void setNamePreference(Context context, String name){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(PREF_NAME, name);
        editor.apply();
    }

    public static void clearNamePreference(Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(PREF_NAME);
        editor.apply();
    }

}