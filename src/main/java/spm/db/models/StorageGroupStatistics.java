package spm.db.models;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by kokoster on 09/04/2017.
 */

@Entity
@Table(name = "dwf_storagegroup_r")
@AssociationOverrides({
        @AssociationOverride(name = "id.partitionkey",
                joinColumns = @JoinColumn(name = "partitionkey")),
        @AssociationOverride(name = "id.storageGroup",
                joinColumns = @JoinColumn(name = "storagegroupkey")),
        @AssociationOverride(name = "id.dateTime",
                joinColumns = @JoinColumn(name = "timekey")) })
public class StorageGroupStatistics implements Serializable {
    @EmbeddedId
    private StorageGroupStatisticsID id = new StorageGroupStatisticsID();

    @Formula ("spmreads + spmwrites")
    private float queriesCount;

    public StorageGroupStatistics() {}

    public StorageGroupStatisticsID getId() {
        return id;
    }

    public void setId(StorageGroupStatisticsID id) {
        this.id = id;
    }

    @Transient
    public StorageGroup getStorageGroup() {
        return getId().getStorageGroup();
    }

    public void setFEDirector(StorageGroup storageGroup) {
        getId().setStorageGroup(storageGroup);
    }

    @Transient
    public DateTime getDateTime() {
        return getId().getDateTime();
    }

    public void setDateTime(DateTime dateTime) {
        getId().setDateTime(dateTime);
    }

    public float getQueriesCount() {
        return queriesCount;
    }

    public void setQueriesCount(float queriesCount) {
        this.queriesCount = queriesCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        StorageGroupStatistics that = (StorageGroupStatistics) o;

        if (getId() != null ? !getId().equals(that.getId())
                : that.getId() != null)
            return false;

        return true;
    }

    public int hashCode() {
        return (getId() != null ? getId().hashCode() : 0);
    }

    @Override
    public String toString() {
        return getStorageGroup().getName() + ": " + queriesCount;
    }
}
