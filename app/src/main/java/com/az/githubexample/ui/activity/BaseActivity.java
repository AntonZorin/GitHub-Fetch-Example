package com.az.githubexample.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialog;

import com.az.githubexample.GitApplication;
import com.az.githubexample.R;
import com.az.githubexample.injection.components.ActivityComponent;
import com.az.githubexample.injection.modules.ActivityModule;
import com.az.githubexample.ui.presenters.BasePresenter;

import butterknife.ButterKnife;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * Created: Zorin A.
 * Date: 015 15.05.16.
 */
@Accessors(prefix = "m")
public abstract class BaseActivity extends AppCompatActivity {
    @Getter
    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        ButterKnife.bind(this);

        mActivityComponent = ((GitApplication)getApplication()).getApplicationComponent()
                .provideActivityComponent(new ActivityModule(this));
        injectDependencies();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().attachView(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPresenter().detachView();
    }

    abstract protected void injectDependencies();

    abstract protected int getLayoutRes();

    abstract protected BasePresenter getPresenter();

    protected void showMessageDialog(int messageId) {
        AppCompatDialog dialog = new AlertDialog.Builder(this)
                .setMessage(messageId)
                .setCancelable(true)
                .setPositiveButton(R.string.ok, null)
                .create();
        dialog.show();
    }
}
