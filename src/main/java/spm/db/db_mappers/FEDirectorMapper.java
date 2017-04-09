package spm.db.db_mappers;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import spm.db.models.FEDirector;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by kokoster on 07/04/2017.
 */

public interface FEDirectorMapper extends CrudRepository<FEDirector, Integer> {
    @Query("from FEDirector")
    List<FEDirector> readFEDirectors();
}
