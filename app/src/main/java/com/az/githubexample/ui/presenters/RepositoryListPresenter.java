package com.az.githubexample.ui.presenters;


import com.az.githubexample.repository.GitRepositories;
import com.az.githubexample.repository.specification.RepositoriesSpecification;
import com.az.githubexample.ui.presenters.view.RepositoryListView;

import javax.inject.Inject;

/**
 * Created: Zorin A.
 * Date: 016 16.05.16.
 */
public class RepositoryListPresenter extends BasePresenter<RepositoryListView> {

    private GitRepositories mRepository;

    @Inject
    public RepositoryListPresenter(GitRepositories githubRepository) {
        mRepository = githubRepository;
    }

    public void loadSelfRepositories() {
        getView().setRefreshing(true);
        mRepository.query(new RepositoriesSpecification())
                .subscribe(githubRepositories -> {
                    if (getView() != null) {
                        getView().setData(githubRepositories);
                        getView().setRefreshing(false);
                    }
                }, throwable -> {
                    if (getView() != null) {
                        getView().showUpdateFailSnackbar();
                        getView().setRefreshing(false);
                    }
                });
    }
}
