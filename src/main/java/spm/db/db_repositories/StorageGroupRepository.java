package spm.db.db_repositories;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import spm.db.models.StorageGroup;

import java.util.List;

/**
 * Created by kokoster on 08/04/2017.
 */
public interface StorageGroupRepository extends CrudRepository<StorageGroup, Integer> {
    @Query("from StorageGroup")
    List<StorageGroup> readStorageGroups();
}
