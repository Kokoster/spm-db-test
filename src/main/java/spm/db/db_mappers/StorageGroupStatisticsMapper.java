package spm.db.db_mappers;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import spm.db.models.DateTime;
import spm.db.models.StorageGroup;
import spm.db.models.StorageGroupStatistics;
import spm.db.models.StorageGroupStatisticsID;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kokoster on 09/04/2017.
 */
public interface StorageGroupStatisticsMapper
        extends CrudRepository<StorageGroupStatistics, StorageGroupStatisticsID> {
    @Query("from StorageGroupStatistics where id.dateTime = :dateTime " +
            "order by queriesCount")
    List<StorageGroup> findBusiestStorageGroups(@Param("dateTime") DateTime dateTime);
}
