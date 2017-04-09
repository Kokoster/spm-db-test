package spm.db.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kokoster on 07/04/2017.
 */

@Entity
@Table(name = "dwd_fedirector")
public class FEDirector implements Serializable {
    @Id
    @Column(name = "fedirectorkey")
    private int fedirectorKey;

    @Column(name = "fedirectorid")
    private String name;

    @OneToMany(mappedBy = "id.feDirector")
    private Set<FEDirectorStatistics> statistics = new HashSet<>();

    public FEDirector() {};

    public int getFedirectorKey() {
        return fedirectorKey;
    }

    public void setFedirectorKey(int fedirectorKey) {
        this.fedirectorKey = fedirectorKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<FEDirectorStatistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(Set<FEDirectorStatistics> statistics) {
        this.statistics = statistics;
    }

    @Override
    public String toString() {
        return fedirectorKey + ": " + name;
    }
}
