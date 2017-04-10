package spm.db.db_mappers;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import spm.db.models.DateTime;
import spm.db.models.FEDirector;
import spm.db.models.FEDirectorStatistics;
import spm.db.models.FEDirectorStatisticsID;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kokoster on 08/04/2017.
 */
public interface DateTimeMapper extends CrudRepository<DateTime, BigDecimal> {
    @Query("from DateTime where timeKey in " +
            "(select id.dateTime from FEDirectorStatistics where id.feDirector = :feDirector and " +
            "queue7 + queue8 + queue9 >= 1)")
    List<DateTime> findFEDirectorBusinessTime(@Param("feDirector") FEDirector feDirector);
}
