package spm.db.db_repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.repository.CrudRepository;
import spm.db.models.DateTime;
import spm.db.models.FEDirector;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by kokoster on 08/04/2017.
 */
public interface DateTimeStatisticsRepository extends CrudRepository<DateTime, BigDecimal> {
    @Query("from DateTime where timeKey in " +
            "(select id.dateTime from FEDirectorStatistics where id.feDirector = :feDirector and " +
            "queue7 + queue8 + queue9 >= 1)")
    List<DateTime> findFEDirectorBusinessTime(@Param("feDirector") FEDirector feDirector);
}
