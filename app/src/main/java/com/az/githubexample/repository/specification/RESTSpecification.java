package com.az.githubexample.repository.specification;

import com.alorma.github.sdk.bean.dto.response.Repo;

import java.util.List;

import rx.Observable;

/**
 * Created by Crazy on 04.04.2016.
 */
public interface RESTSpecification extends Specification {

    Observable<List<Repo>> getNetworkResults();
}
