package com.az.githubexample.repository;

import com.activeandroid.ActiveAndroid;
import com.alorma.github.sdk.bean.dto.response.Repo;
import com.az.githubexample.database.GitRepository;
import com.az.githubexample.interfaces.Mapper;
import com.az.githubexample.models.GitModel;
import com.az.githubexample.repository.mappers.DbToGitMapper;
import com.az.githubexample.repository.mappers.GitRepositoryToDbMapper;
import com.az.githubexample.repository.mappers.RestToGitMapper;
import com.az.githubexample.repository.specification.RepositoriesSpecification;
import com.az.githubexample.repository.specification.Specification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created: Zorin A.
 * Date: 016 16.05.16.
 */
public class GitRepositories implements Repository<GitRepository> {

    private final Mapper<GitRepository, GitModel> mToDatabaseModelMapper;
    private final Mapper<GitModel, GitRepository> mToGitRepositoryMapper;
    private final Mapper<Repo, GitRepository> mRestToGitRepositoryMapper;

    @Inject
    public GitRepositories() {
        mToDatabaseModelMapper = new GitRepositoryToDbMapper();
        mToGitRepositoryMapper = new DbToGitMapper();
        mRestToGitRepositoryMapper = new RestToGitMapper();
    }

    @Override
    public void add(GitRepository item) {
        add(Collections.singletonList(item));
    }

    @Override
    public void add(Iterable<GitRepository> items) {
        ActiveAndroid.beginTransaction();
        try {
            for (GitRepository item : items) {
                GitModel dbModel = mToDatabaseModelMapper.map(item);
                dbModel.save();
            }
            ActiveAndroid.setTransactionSuccessful();
        } catch (RuntimeException e) {

        }
        ActiveAndroid.endTransaction();
    }

    @Override
    public void update(GitRepository item) {
        GitModel dbModel = mToDatabaseModelMapper.map(item);
        dbModel.save();
    }

    @Override
    public void remove(GitRepository item) {
    }

    @Override
    public Observable<List<GitRepository>> query(Specification specification) {
        List<GitModel> localResults = ((RepositoriesSpecification) specification).getResults();
        Observable<List<Repo>> networkResults = ((RepositoriesSpecification) specification).getNetworkResults();

        ArrayList<GitRepository> repositories = new ArrayList<>();
        for (GitModel result : localResults) {
            repositories.add(mToGitRepositoryMapper.map(result));
        }

        return Observable.concat(Observable.just(repositories),
                networkResults.map((Func1<List<Repo>, List<GitRepository>>) repos -> {
                    ArrayList<GitRepository> githubRepositories = new ArrayList<>();
                    for (Repo repo : repos) {
                        githubRepositories.add(mRestToGitRepositoryMapper.map(repo));
                    }

                    return githubRepositories;
                }))
                .doOnNext(this::add);
    }
}
