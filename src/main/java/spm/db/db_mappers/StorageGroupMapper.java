package spm.db.db_mappers;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import spm.db.models.FEDirector;
import spm.db.models.StorageGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kokoster on 08/04/2017.
 */
public interface StorageGroupMapper extends CrudRepository<StorageGroup, Integer> {
    @Query("from StorageGroup")
    List<StorageGroup> readStorageGroups();
}
