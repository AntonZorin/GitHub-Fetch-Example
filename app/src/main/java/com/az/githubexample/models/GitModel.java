package com.az.githubexample.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Created: Zorin A.
 * Date: 016 16.05.16.
 */

@Data
@AllArgsConstructor
@Accessors(prefix = "m")
@Table(name = "Repository")
@NoArgsConstructor
public class GitModel extends Model {

    @Column(name = "serverId", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    private long mServerId;

    @Column(name = "name")
    private String mName;
}
