package com.az.githubexample.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.az.githubexample.R;
import com.az.githubexample.ui.fragment.ListFragment;
import com.az.githubexample.ui.presenters.BasePresenter;
import com.az.githubexample.ui.presenters.RepositoryPresenter;

import javax.inject.Inject;

/**
 * Created: Zorin A.
 * Date: 015 15.05.16.
 */

public class MainActivity extends BaseActivity {

    @Inject
    RepositoryPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_repository_placeholder, new ListFragment())
                .commit();
    }

    @Override
    protected void injectDependencies() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter getPresenter() {
        return mPresenter;
    }

}
