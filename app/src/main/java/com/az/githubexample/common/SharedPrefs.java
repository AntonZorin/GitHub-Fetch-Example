package com.az.githubexample.common;

import android.content.Context;
import android.content.SharedPreferences;

import com.az.githubexample.injection.qualifiers.ApplicationQualifier;


import javax.inject.Inject;

/**
 * Created: Zorin A.
 * Date: 016 16.05.16.
 */
public class SharedPrefs {

    private static final String PREFS_NAME = "SharedPrefs";

    SharedPreferences mSharedPreferences;

    @Inject
    public SharedPrefs(@ApplicationQualifier Context context) {
        mSharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void setToken(String token) {
        mSharedPreferences.edit().putString("git_token", token).apply();
    }

    public String getToken() {
        return mSharedPreferences.getString("git_token", null);
    }
}
