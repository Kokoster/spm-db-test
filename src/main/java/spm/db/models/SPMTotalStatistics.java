package spm.db.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kokoster on 10/04/2017.
 */
public class SPMTotalStatistics implements Serializable {
    private FEDirector fedirector;
    private List<TimeStorageGroupMap> storageGroups = new ArrayList<>();

    public SPMTotalStatistics(FEDirector fedirector) {
        this.fedirector = fedirector;
    }

    public void addStorageGroups(List<StorageGroup> storageGroup, DateTime timestamp) {
        storageGroups.add(new TimeStorageGroupMap(storageGroup, timestamp));
    }

    public FEDirector getFedirector() {
        return fedirector;
    }

    public List<TimeStorageGroupMap> getStorageGroups() {
        return storageGroups;
    }

    public void setStorageGroups(List<TimeStorageGroupMap> storageGroups) {
        this.storageGroups = storageGroups;
    }

    private class TimeStorageGroupMap implements Serializable {
        private List<StorageGroup> storageGroup;
        private DateTime timestamp;

        public TimeStorageGroupMap(List<StorageGroup> storageGroup, DateTime timestamp) {
            this.storageGroup = storageGroup;
            this.timestamp = timestamp;
        }

        public List<StorageGroup> getStorageGroup() {
            return storageGroup;
        }

        public void setStorageGroup(List<StorageGroup> storageGroup) {
            this.storageGroup = storageGroup;
        }

        public DateTime getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(DateTime timestamp) {
            this.timestamp = timestamp;
        }
    }
}
