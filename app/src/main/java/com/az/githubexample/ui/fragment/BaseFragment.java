package com.az.githubexample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.az.githubexample.injection.components.ActivityComponent;
import com.az.githubexample.injection.components.FragmentComponent;
import com.az.githubexample.injection.modules.FragmentModule;
import com.az.githubexample.ui.activity.BaseActivity;
import com.az.githubexample.ui.presenters.BasePresenter;

import butterknife.ButterKnife;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * Created: Zorin A.
 * Date: 016 16.05.16.
 */
@Accessors(prefix = "m")
public abstract class BaseFragment extends Fragment {
    @Getter
    private FragmentComponent mFragmentComponent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Do not recreate presenter
        setRetainInstance(true);

        mFragmentComponent = getActivityComponent()
                .provideFragmentComponent(new FragmentModule(this));
        injectDependencies();
    }

    @Override
    public void onPause() {
        super.onPause();
        getPresenter().detachView();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(getLayoutRes(), container, false);
        ButterKnife.bind(this, view);
        getPresenter().attachView(this);

        return view;
    }

    protected ActivityComponent getActivityComponent() {
        return ((BaseActivity) getActivity()).getActivityComponent();
    }

    abstract protected void injectDependencies();

    abstract protected int getLayoutRes();

    abstract protected BasePresenter getPresenter();
}
