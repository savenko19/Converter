package com.example.testconverter.model.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesHelper {

    private static SharedPreferences mSharedPreferences;

     public static void initPreferences(Context context) {
         mSharedPreferences = context.getSharedPreferences("main", Context.MODE_PRIVATE);
     }


}
