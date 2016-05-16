package com.az.githubexample.ui.presenters.view;


import com.az.githubexample.database.GitRepository;

import java.util.List;

/**
 * Created: Zorin A.
 * Date: 017 17.05.16.
 */
public interface RepositoryListView {

    void setData(List<GitRepository> githubRepositories);

    void showUpdateFailSnackbar();

    void setRefreshing(boolean b);
}
