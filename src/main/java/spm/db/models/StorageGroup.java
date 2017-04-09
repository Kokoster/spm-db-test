package spm.db.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kokoster on 08/04/2017.
 */

@Entity
@Table(name = "dwd_storagegroup")
public class StorageGroup implements Serializable {
    @Id
    @Column(name = "storagegroupkey")
    private int storageGroupKey;

    @Column(name = "storagegroupid")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "id.storageGroup")
    private Set<StorageGroupStatistics> statistics = new HashSet<>();

    public StorageGroup() {};

    public int getStorageGroupKey() {
        return storageGroupKey;
    }

    public void setStorageGroupKey(int storageGroupKey) {
        this.storageGroupKey = storageGroupKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<StorageGroupStatistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(Set<StorageGroupStatistics> statistics) {
        this.statistics = statistics;
    }

    @Override
    public String toString() {
        return storageGroupKey + ": " + name;
    }
}
