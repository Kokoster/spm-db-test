package spm.db.db_repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.repository.CrudRepository;
import spm.db.models.FEDirector;

import java.util.List;

/**
 * Created by kokoster on 07/04/2017.
 */

public interface FEDirectorRepository extends CrudRepository<FEDirector, Integer> {
    @Query("from FEDirector")
    List<FEDirector> readFEDirectors();

    @Query("from FEDirector where name = :feDirectorName")
    FEDirector findFEDirectorByName(@Param("feDirectorName") String feDirectorName);
}
