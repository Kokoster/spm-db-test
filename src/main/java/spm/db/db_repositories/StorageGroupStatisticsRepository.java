package spm.db.db_repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.repository.CrudRepository;
import spm.db.models.DateTime;
import spm.db.models.StorageGroupStatistics;
import spm.db.models.StorageGroupStatisticsID;

import java.util.List;

/**
 * Created by kokoster on 09/04/2017.
 */
public interface StorageGroupStatisticsRepository
        extends CrudRepository<StorageGroupStatistics, StorageGroupStatisticsID> {
    @Query("from StorageGroupStatistics where id.dateTime = :dateTime " +
            "order by queriesCount")
    List<StorageGroupStatistics> findBusiestStorageGroups(@Param("dateTime") DateTime dateTime);
}
