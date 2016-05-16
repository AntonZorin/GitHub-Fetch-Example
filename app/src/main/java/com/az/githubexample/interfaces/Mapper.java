package com.az.githubexample.interfaces;


/**
 * Created: Zorin A.
 * Date: 016 16.05.16.
 */
public interface Mapper<From, To> {

    To map(From from);
}
