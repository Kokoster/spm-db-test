package spm.db.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kokoster on 08/04/2017.
 */

@Entity
@Table(name = "dwd_time_n_utc")
public class DateTime implements Serializable {
    @JsonIgnore
    @Id
    @Column(name = "timekey")
    private BigDecimal timeKey;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @Column(name = "datestamp")
    private Timestamp datestamp;

    @JsonIgnore
    @OneToMany(mappedBy = "id.dateTime", targetEntity = FEDirectorStatistics.class)
    private Set<DateTime> fedirectorStatistics = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "id.dateTime", targetEntity = StorageGroupStatistics.class)
    private Set<DateTime> storageGroupStatistics = new HashSet<>();

    public DateTime() {};

    public BigDecimal getTimeKey() {
        return timeKey;
    }

    public void setTimeKey(BigDecimal timeKey) {
        this.timeKey = timeKey;
    }

    public Timestamp getDatestamp() {
        return datestamp;
    }

    public void setDatestamp(int Timestamp) {
        this.datestamp = datestamp;
    }

    public Set<DateTime> getFedirectorStatistics() {
        return fedirectorStatistics;
    }

    public void setFedirectorStatistics(Set<DateTime> fedirectorStatistics) {
        this.fedirectorStatistics = fedirectorStatistics;
    }

    public Set<DateTime> getStorageGroupStatistics() {
        return storageGroupStatistics;
    }

    public void setStorageGroupStatistics(Set<DateTime> storageGroupStatistics) {
        this.storageGroupStatistics = storageGroupStatistics;
    }

    @Override
    public String toString() {
        return datestamp.toString();
    }
}
