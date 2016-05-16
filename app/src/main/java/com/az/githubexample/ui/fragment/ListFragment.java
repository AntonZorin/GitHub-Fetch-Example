package com.az.githubexample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.az.githubexample.R;
import com.az.githubexample.database.GitRepository;
import com.az.githubexample.ui.adapters.RepositoryAdapter;
import com.az.githubexample.ui.presenters.BasePresenter;
import com.az.githubexample.ui.presenters.RepositoryListPresenter;
import com.az.githubexample.ui.presenters.view.RepositoryListView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created: Zorin A.
 * Date: 016 16.05.16.
 */

public class ListFragment extends BaseFragment implements RepositoryListView, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    RepositoryListPresenter mPresenter;

    @Inject
    RepositoryAdapter mRepositoryAdapter;

    @Bind(R.id.fragment_repository_list_recycler)
    RecyclerView mRepositoryRecycler;
    @Bind(R.id.fragment_repository_list_refresher)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initRecycler();
        mPresenter.loadSelfRepositories();
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        mPresenter.loadSelfRepositories();
    }

    @Override
    public void setData(List<GitRepository> gitRepositories) {
        mRepositoryAdapter.setData(gitRepositories);
    }

    @Override
    public void showUpdateFailSnackbar() {
        Snackbar.make(getView(), R.string.failed_to_fetch_repositories, Snackbar.LENGTH_LONG)
                .setAction(R.string.retry, view -> {
                    mPresenter.loadSelfRepositories();
                })
                .show();
    }

    @Override
    public void setRefreshing(boolean refreshing) {
        mSwipeRefreshLayout.setRefreshing(refreshing);
    }

    @Override
    protected void injectDependencies() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_repository_list;
    }

    @Override
    protected BasePresenter getPresenter() {
        return mPresenter;
    }

    private void initRecycler() {
        mRepositoryRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mRepositoryRecycler.setAdapter(mRepositoryAdapter);
    }
}
