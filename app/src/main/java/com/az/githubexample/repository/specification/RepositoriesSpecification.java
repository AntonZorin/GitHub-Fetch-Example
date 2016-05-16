package com.az.githubexample.repository.specification;

import com.activeandroid.query.Select;
import com.alorma.github.sdk.bean.dto.response.Repo;
import com.alorma.github.sdk.services.repos.UserReposClient;
import com.alorma.gitskarios.core.Pair;
import com.az.githubexample.models.GitModel;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;

/**
 * Created: Zorin A.
 * Date: 016 16.05.16.
 */
public class RepositoriesSpecification implements ActiveAndroidSpecification, RESTSpecification {

    public RepositoriesSpecification() {
    }

    @Override
    public List<GitModel> getResults() {
        return new Select().from(GitModel.class).execute();
    }

    @Override
    public Observable<List<Repo>> getNetworkResults() {
        return new UserReposClient()
                .observable()
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<Pair<List<Repo>, Integer>, List<Repo>>() {
                    @Override
                    public List<Repo> call(Pair<List<Repo>, Integer> listIntegerPair) {
                        return listIntegerPair.first;
                    }
                });
    }
}
