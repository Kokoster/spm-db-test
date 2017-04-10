package spm.db.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kokoster on 10/04/2017.
 */
@JsonPropertyOrder({"feDirector", "dateTimeList"})
public class FEDirectorBusinessStatistics implements Serializable {
    private FEDirector feDirector;
    private List<DateTime> dateTimeList;

    public FEDirectorBusinessStatistics(
            FEDirector feDirector, List<DateTime> dateTimeList) {
        this.feDirector = feDirector;
        this.dateTimeList = dateTimeList;
    }

    public FEDirector getFEDirector() {
        return feDirector;
    }

    public void setFEDirector(FEDirector feDirector) {
        this.feDirector = feDirector;
    }

    public List<DateTime> getDateTimeList() {
        return dateTimeList;
    }

    public void setDateTimeList(List<DateTime> dateTimeList) {
        this.dateTimeList = dateTimeList;
    }
}
