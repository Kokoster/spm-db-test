package spm.db.models;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import java.io.Serializable;

/**
 * Created by kokoster on 09/04/2017.
 */
@Embeddable
public class FEDirectorStatisticsID implements Serializable {
    @ManyToOne
    private FEDirector feDirector;
    @ManyToOne
    private DateTime dateTime;

    public FEDirector getFEDirector() {
        return feDirector;
    }

    public void setFEDirector(FEDirector feDirector) {
        this.feDirector = feDirector;
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

        FEDirectorStatisticsID that = (FEDirectorStatisticsID) o;

        if (feDirector != null ? !feDirector.equals(that.feDirector) : that.feDirector != null) return false;
        if (dateTime != null ? !dateTime.equals(that.dateTime) : that.dateTime != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (feDirector != null ? feDirector.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        return result;
    }
}
