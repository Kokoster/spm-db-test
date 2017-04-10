package spm.db.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by kokoster on 08/04/2017.
 */

@Entity
@Table(name = "dwf_fedirector_r")
@AssociationOverrides({
        @AssociationOverride(name = "id.feDirector",
                joinColumns = @JoinColumn(name = "fedirectorkey")),
        @AssociationOverride(name = "id.dateTime",
                joinColumns = @JoinColumn(name = "timekey")) })
public class FEDirectorStatistics implements Serializable {
    @EmbeddedId
    private FEDirectorStatisticsID id = new FEDirectorStatisticsID();

    @Column(name = "spmqueuedepcount7")
    private float queue7;

    @Column(name = "spmqueuedepcount8")
    private float queue8;

    @Column(name = "spmqueuedepcount9")
    private float queue9;

    public FEDirectorStatistics() {}

    public FEDirectorStatisticsID getId() {
        return this.id;
    }

    public void setId(FEDirectorStatisticsID id) {
        this.id = id;
    }

    @Transient
    public FEDirector getFEDirector() {
        return getId().getFEDirector();
    }

    public void setFEDirector(FEDirector feDirector) {
        getId().setFEDirector(feDirector);
    }

    @Transient
    public DateTime getDateTime() {
        return getId().getDateTime();
    }

    public void setDateTime(DateTime dateTime) {
        getId().setDateTime(dateTime);
    }

    public float getQueue7() {
        return queue7;
    }

    public void setQueue7(float queue7) {
        this.queue7 = queue7;
    }

    public float getQueue8() {
        return queue8;
    }

    public void setQueue8(float queue8) {
        this.queue8 = queue8;
    }

    public float getQueue9() {
        return queue9;
    }

    public void setQueue9(float queue9) {
        this.queue9 = queue9;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        FEDirectorStatistics that = (FEDirectorStatistics) o;

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
        return id.getFEDirector().getFedirectorKey() + ": " + getDateTime().getDatestamp();
    }
}
