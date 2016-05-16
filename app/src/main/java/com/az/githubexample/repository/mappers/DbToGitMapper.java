package com.az.githubexample.repository.mappers;

import com.az.githubexample.database.GitRepository;
import com.az.githubexample.interfaces.Mapper;
import com.az.githubexample.models.GitModel;
/**
 * Created: Zorin A.
 * Date: 016 16.05.16.
 */
public class DbToGitMapper implements Mapper<GitModel, GitRepository> {

    @Override
    public GitRepository map(GitModel githubRepositoryModel) {
        return new GitRepository(githubRepositoryModel.getServerId(), githubRepositoryModel.getName());
    }
}
