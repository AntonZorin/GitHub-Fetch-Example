package com.az.githubexample.repository;


import com.az.githubexample.repository.specification.Specification;

import java.util.List;

import rx.Observable;

/**
 * Created: Zorin A.
 * Date: 016 16.05.16.
 */
public interface Repository<T> {

    void add(T item);

    void add(Iterable<T> items);

    void update(T item);

    void remove(T item);

    Observable<List<T>> query(Specification specification);
}
