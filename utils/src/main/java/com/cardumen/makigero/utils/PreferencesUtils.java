package com.cardumen.makigero.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * @author diego.rotondale
 * @version 0.1
 *
 * Utils to work with preferences
 */
public class PreferencesUtils {

    //region Constructor
    private PreferencesUtils() {
        // Private constructor to avoid instantiation.
    }
    //endregion

    //region Public Static Implementation
    /**
     * Save a {@link Boolean} value into the default shared preferences
     * @param context A context to get the default shared preferences
     * @param key The key to associate the value to save
     * @param value The value to save
     */
    public static void saveBoolean(Context context, String key, boolean value) {
        final SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * Get a {@link Boolean} value from the default shared preferences
     * @param context A context to get the default shared preferences
     * @param key The key to find the value
     * @param value The default value if it can't be found with the passed key
     * @return The value found or the default if it couldn't be found
     */
    public static boolean getBoolean(Context context, String key, Boolean value) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(key, value);
    }

    /**
     * Save a {@link String} value into the default shared preferences
     * @param context A context to get the default shared preferences
     * @param key The key to associate the value to save
     * @param value The value to save
     */
    public static void setString(Context context, String key, String value) {
        final SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * Get a {@link String} value from the default shared preferences
     * @param context A context to get the default shared preferences
     * @param key The key to find the value
     * @param value The default value if it can't be found with the passed key
     * @return The value found or the default if it couldn't be found
     */
    public static String getString(Context context, String key, String value) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(key, value);
    }
    //endregion

}