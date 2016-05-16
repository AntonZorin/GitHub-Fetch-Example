package com.az.githubexample.manager;

import com.alorma.github.sdk.bean.dto.request.CreateAuthorization;
import com.alorma.github.sdk.services.login.CreateAuthorizationClient;
import com.alorma.gitskarios.core.client.TokenProvider;
import com.az.githubexample.common.SharedPrefs;
import com.az.githubexample.exception.GithubAuthException;
import com.az.githubexample.exception.NetworkException;

import javax.inject.Inject;

import retrofit.RetrofitError;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created: Zorin A.
 * Date: 015 15.05.16.
 */
public class GithubManager {

    public static final String CLIENT_ID = "2369ca14f5be8c9bd1e6";
    public static final String CLIENT_SECRET = "569d9a7982b5a5cdfa37628f5a8277f6be7dd446";
    public static final String[] SCOPES = new String[]{"public_repo"};

    private SharedPrefs mSharedPrefsManager;

    @Inject
    public GithubManager(SharedPrefs sharedPrefsManager) {
        mSharedPrefsManager = sharedPrefsManager;
    }

    public Observable login(String username, String password) {
        CreateAuthorization createAuthorization = new CreateAuthorization();
        createAuthorization.client_id = CLIENT_ID;
        createAuthorization.client_secret = CLIENT_SECRET;
        createAuthorization.scopes = SCOPES;

        return new CreateAuthorizationClient(username, password, createAuthorization)
                .observable()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(githubAuthorization -> {
                    mSharedPrefsManager.setToken(githubAuthorization.token);
                    TokenProvider.setTokenProviderInstance(() -> githubAuthorization.token);
                })
                .onErrorResumeNext(throwable -> {
                    if (throwable instanceof RetrofitError) {
                        return Observable.error(new NetworkException());
                    } else {
                        return Observable.error(new GithubAuthException());
                    }
                });
    }
}
