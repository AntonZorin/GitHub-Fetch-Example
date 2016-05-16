package com.az.githubexample.injection.modules;

import android.support.v4.app.Fragment;

import dagger.Module;

/**
 * Created: Zorin A.
 * Date: 016 16.05.16.
 */

@Module
public class FragmentModule {

    private Fragment mBaseFragment;

    public FragmentModule(Fragment baseFragment) {
        mBaseFragment = baseFragment;
    }
}