package spm.db.models;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by kokoster on 09/04/2017.
 */

@Embeddable
public class StorageGroupStatisticsID implements Serializable {
    private int partitionkey;

    @ManyToOne
    private StorageGroup storageGroup;
    @ManyToOne
    private DateTime dateTime;

    public StorageGroupStatisticsID() {};

    public int getPartitionkey() {
        return partitionkey;
    }

    public void setPartitionkey(int partitionkey) {
        this.partitionkey = partitionkey;
    }

    public StorageGroup getStorageGroup() {
        return storageGroup;
    }

    public void setStorageGroup(StorageGroup storageGroup) {
        this.storageGroup = storageGroup;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StorageGroupStatisticsID that = (StorageGroupStatisticsID) o;

        if (storageGroup != null ? !storageGroup.equals(that.storageGroup) : that.storageGroup != null) return false;
        if (dateTime != null ? !dateTime.equals(that.dateTime) : that.dateTime != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (storageGroup != null ? storageGroup.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        return result;
    }
}
