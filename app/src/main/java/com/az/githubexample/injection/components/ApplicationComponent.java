package com.az.githubexample.injection.components;

import com.az.githubexample.GitApplication;
import com.az.githubexample.injection.modules.ActivityModule;
import com.az.githubexample.injection.modules.ApplicationModule;
import com.az.githubexample.injection.scopes.ApplicationScope;

import dagger.Component;

/**
 * Created: Zorin A.
 * Date: 016 16.05.16.
 */
@ApplicationScope
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    ActivityComponent provideActivityComponent(ActivityModule activityModule);

    void inject(GitApplication application);
}
