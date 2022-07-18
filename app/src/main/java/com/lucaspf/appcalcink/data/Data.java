package com.lucaspf.appcalcink.data;

import android.content.Context;

import android.content.SharedPreferences;

public class Data {
    private SharedPreferences mSharedPreferences;

    public Data(Context mContext) {
        this.mSharedPreferences = mContext.getSharedPreferences("NumberOfwall", Context.MODE_PRIVATE);
    }

    public void storeString(String key, String value) {
        this.mSharedPreferences.edit().putString(key, value).apply();
    }

    public String getStoredString(String key) {
        return this.mSharedPreferences.getString(key, "");
    }

    public String getNumWalls() {
        return this.getStoredString("NumberOfwall");
    }
    public void setNumWall(String value){
        this.storeString("NumberOWall", value);
    }

}
