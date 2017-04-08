package spm.db;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kokoster on 08/04/2017.
 */

@Entity
@Table(name = "dwd_time_n_utc")
public class DateTime implements Serializable {
    @Id
    @Column(name = "timekey")
    private int timeKey;
    private Timestamp datestamp;

    @OneToMany(mappedBy = "id.dateTime", targetEntity = FEDirectorStatistics.class)
    private Set<DateTime> fedirectorStatistics = new HashSet<>();

    public DateTime() {};

    public int getTimeKey() {
        return timeKey;
    }

    public void setTimeKey(int timeKey) {
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

    @Override
    public String toString() {
        return Integer.toString(timeKey);
    }
}
