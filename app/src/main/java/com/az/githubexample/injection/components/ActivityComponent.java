package com.az.githubexample.injection.components;

import com.az.githubexample.injection.modules.ActivityModule;
import com.az.githubexample.injection.modules.FragmentModule;
import com.az.githubexample.injection.scopes.ActivityScope;
import com.az.githubexample.ui.activity.LoginActivity;
import com.az.githubexample.ui.activity.MainActivity;

import dagger.Subcomponent;

/**
 * Created: Zorin A.
 * Date: 016 16.05.16.
 */
@ActivityScope
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    FragmentComponent provideFragmentComponent(FragmentModule fragmentModule);

    void inject(MainActivity mainActivity);

    void inject(LoginActivity loginActivity);
}
