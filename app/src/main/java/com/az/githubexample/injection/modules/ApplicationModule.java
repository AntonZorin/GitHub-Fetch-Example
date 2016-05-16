package com.az.githubexample.injection.modules;

import android.app.Application;
import android.content.Context;

import com.az.githubexample.injection.qualifiers.ApplicationQualifier;
import com.az.githubexample.injection.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created: Zorin A.
 * Date: 016 16.05.16.
 */
@Module
public class ApplicationModule {
    private Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @ApplicationScope
    @ApplicationQualifier
    @Provides
    public Context provideApplicationContext() {
        return mApplication;
    }
}
