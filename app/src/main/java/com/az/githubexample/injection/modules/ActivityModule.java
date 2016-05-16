package com.az.githubexample.injection.modules;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.az.githubexample.injection.qualifiers.ActivityQualifier;
import com.az.githubexample.injection.scopes.ActivityScope;

import java.lang.ref.WeakReference;

import dagger.Module;
import dagger.Provides;

/**
 * Created: Zorin A.
 * Date: 016 16.05.16.
 */
@Module
public class ActivityModule {
    private WeakReference<AppCompatActivity> mActivityRef;

    public ActivityModule(AppCompatActivity activity) {
        mActivityRef = new WeakReference<>(activity);
    }

    @ActivityScope
    @ActivityQualifier
    @Provides
    public Context provideActivityContext() {
        return mActivityRef.get();
    }
}
