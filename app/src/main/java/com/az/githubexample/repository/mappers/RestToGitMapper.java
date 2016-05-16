package com.az.githubexample.repository.mappers;

import com.alorma.github.sdk.bean.dto.response.Repo;
import com.az.githubexample.database.GitRepository;
import com.az.githubexample.interfaces.Mapper;

/**
 * Created: Zorin A.
 * Date: 016 16.05.16.
 */

public class RestToGitMapper implements Mapper<Repo, GitRepository> {

    @Override
    public GitRepository map(Repo repo) {
        return new GitRepository(repo.id, repo.name);
    }
}
