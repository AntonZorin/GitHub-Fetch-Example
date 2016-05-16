package com.az.githubexample.injection.components;

import com.az.githubexample.injection.modules.FragmentModule;
import com.az.githubexample.injection.scopes.FragmentScope;
import com.az.githubexample.ui.fragment.ListFragment;

import dagger.Subcomponent;

/**
 * Created: Zorin A.
 * Date: 016 16.05.16.
 */

@FragmentScope
@Subcomponent(modules = {FragmentModule.class})
public interface FragmentComponent {

    void inject(ListFragment listFragment);

}
