package com.az.githubexample.repository.mappers;


import com.az.githubexample.database.GitRepository;
import com.az.githubexample.interfaces.Mapper;
import com.az.githubexample.models.GitModel;
/**
 * Created: Zorin A.
 * Date: 016 16.05.16.
 */
public class GitRepositoryToDbMapper implements Mapper<GitRepository, GitModel> {

    @Override
    public GitModel map(GitRepository githubRepository) {
        return new GitModel(githubRepository.getServerId(), githubRepository.getName());
    }
}
