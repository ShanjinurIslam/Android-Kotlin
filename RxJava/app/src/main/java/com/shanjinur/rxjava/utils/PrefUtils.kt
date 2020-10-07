package com.shanjinur.rxjava.utils

import android.content.Context;
import android.content.SharedPreferences;

class PrefUtils{
    companion object {
        private fun getSharedPreferences(context: Context): SharedPreferences { // singleton
            return context.getSharedPreferences("APP_PREF",Context.MODE_PRIVATE);
        }

        fun storeApiKey(context: Context, apiKey: String) {
            val editor:SharedPreferences.Editor = getSharedPreferences(context).edit();
            editor.putString("API_KEY",apiKey)
            editor.apply()
        }

        fun getApiKey(context: Context): String? {
            return getSharedPreferences(context).getString("API_KEY",null)
        }
    }
}