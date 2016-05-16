package com.az.githubexample;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.az.githubexample.injection.components.ApplicationComponent;
import com.az.githubexample.injection.components.DaggerApplicationComponent;
import com.az.githubexample.injection.modules.ApplicationModule;

import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * Created: Zorin A.
 * Date: 016 16.05.16.
 */
@Accessors(prefix = "m")
public class GitApplication extends Application {
    @Getter
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mApplicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
