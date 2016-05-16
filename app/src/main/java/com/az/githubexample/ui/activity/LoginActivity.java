package com.az.githubexample.ui.activity;

import android.content.Intent;
import android.widget.EditText;

import com.az.githubexample.R;
import com.az.githubexample.ui.presenters.BasePresenter;
import com.az.githubexample.ui.presenters.LoginPresenter;
import com.az.githubexample.ui.presenters.view.LoginView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created: Zorin A.
 * Date: 015 15.05.16.
 */
public class LoginActivity extends BaseActivity  implements LoginView {

    @Inject
    LoginPresenter mPresenter;

    @Bind(R.id.activity_login_username_edit)
    EditText mUsernameEdit;
    @Bind(R.id.activity_login_password_edit)
    EditText mPasswordEdit;

    @Override
    protected void injectDependencies() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected BasePresenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.checkLogin();
    }

    @OnClick(R.id.activity_login_login_button)
    public void onLoginClick() {
        mPresenter.login(mUsernameEdit.getText().toString(),
                mPasswordEdit.getText().toString());
    }

    @Override
    public void loginSuccess() {
        switchToLoggedIn();
    }

    private void switchToLoggedIn() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void loginFailed(int reason) {
        showMessageDialog(reason);
    }
}
