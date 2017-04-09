package spm.db.web_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMethod;
import spm.db.db_mappers.FEDirectorMapper;
import spm.db.db_mappers.StorageGroupMapper;
import spm.db.models.FEDirector;
import spm.db.models.StorageGroup;

import java.util.List;

/**
 * Created by kokoster on 09/04/2017.
 */
@RestController
public class SPMConnectionController {
    @Autowired
    FEDirectorMapper feDirectorMapper;

    @Autowired
    StorageGroupMapper storageGroupMapper;

    @RequestMapping(value = "/fedirectors", method = RequestMethod.GET)
    public List<FEDirector> getFEDirectors() {
        return feDirectorMapper.readFEDirectors();
    }

    @RequestMapping(value = "/storagegroups", method = RequestMethod.GET)
    public List<StorageGroup> getStorageGroups() {
        return storageGroupMapper.readStorageGroups();
    }
}
