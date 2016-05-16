package com.az.githubexample.ui.adapters;

import android.view.ViewGroup;

import com.az.githubexample.database.GitRepository;
import com.az.githubexample.ui.views.RepositoryView;

import javax.inject.Inject;


/**
 * Created: Zorin A.
 * Date: 015 15.05.16.
 */
public class RepositoryAdapter extends BaseAdapter<GitRepository, RepositoryView, BaseViewHolder<RepositoryView>> {

    @Inject
    public RepositoryAdapter() {
    }

    @Override
    public BaseViewHolder<RepositoryView> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseViewHolder<>(new RepositoryView(parent.getContext()));
    }
}
