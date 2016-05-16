package com.az.githubexample.ui.presenters;

import android.support.annotation.Nullable;

import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * Created: Zorin A.
 * Date: 016 16.05.16.
 */
@Accessors(prefix = "m")
public class BasePresenter<V> {

    @Getter
    @Nullable
    private V mView;

    public void attachView(V view) {
        mView = view;
    }

    public void detachView() {
        mView = null;
    }
}
