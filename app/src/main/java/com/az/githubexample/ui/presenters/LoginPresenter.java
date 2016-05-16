package com.az.githubexample.ui.presenters;

import com.alorma.gitskarios.core.client.TokenProvider;
import com.az.githubexample.R;
import com.az.githubexample.common.SharedPrefs;
import com.az.githubexample.exception.GithubAuthException;
import com.az.githubexample.exception.NetworkException;
import com.az.githubexample.manager.GithubManager;
import com.az.githubexample.ui.presenters.view.LoginView;

import javax.inject.Inject;

/**
 * Created: Zorin A.
 * Date: 015 15.05.16.
 */
public class LoginPresenter extends BasePresenter<LoginView> {

    private GithubManager mGithubManager;
    private SharedPrefs mPreferenceManager;

    @Inject
    public LoginPresenter(GithubManager githubManager, SharedPrefs preferenceManager) {
        mGithubManager = githubManager;
        mPreferenceManager = preferenceManager;
    }

    public void login(String username, String password) {
        mGithubManager.login(username, password)
                .subscribe(o -> getView().loginSuccess(),
                        throwable -> {
                            int reason = 0;
                            if (throwable instanceof GithubAuthException) {
                                reason = R.string.wrong_log_or_pass;
                            } else if (throwable instanceof NetworkException) {
                                reason = R.string.network_error;
                            } else {
                                reason = R.string.unknown_error;
                            }
                            if (getView() != null) {
                                getView().loginFailed(reason);
                            }
                        });
    }

    public void checkLogin() {
        if (mPreferenceManager.getToken() != null && getView() != null) {
            TokenProvider.setTokenProviderInstance(() -> mPreferenceManager.getToken());
            getView().loginSuccess();
        }
    }
}
