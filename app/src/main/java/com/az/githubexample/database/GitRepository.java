package com.az.githubexample.database;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created: Zorin A.
 * Date: 016 16.05.16.
 */

@Data
@AllArgsConstructor
@Accessors(prefix = "m")
public class GitRepository {

    private long mServerId;
    private String mName;
}
