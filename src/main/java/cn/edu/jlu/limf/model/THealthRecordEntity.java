package cn.edu.jlu.limf.model;

import javax.persistence.*;

/**
 * Created by merlin on 17-5-6.
 */
@Entity
@Table(name = "t_HealthRecord", schema = "HIMSDB", catalog = "")
public class THealthRecordEntity {
    private int id;
    private String userAccountId;
    private String date;
    private String startTime;
    private String endTime;
    private String caloriesOut;
    private String max;
    private String min;
    private String minutes;
    private String typeName;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userAccountID", nullable = false, length = 20)
    public String getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(String userAccountId) {
        this.userAccountId = userAccountId;
    }

    @Basic
    @Column(name = "date", nullable = true, length = 45)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "start_time", nullable = true, length = 45)
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time", nullable = true, length = 45)
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "CaloriesOut", nullable = true, length = 45)
    public String getCaloriesOut() {
        return caloriesOut;
    }

    public void setCaloriesOut(String caloriesOut) {
        this.caloriesOut = caloriesOut;
    }

    @Basic
    @Column(name = "max", nullable = true, length = 45)
    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    @Basic
    @Column(name = "min", nullable = true, length = 45)
    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    @Basic
    @Column(name = "minutes", nullable = true, length = 45)
    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    @Basic
    @Column(name = "type_name", nullable = true, length = 45)
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        THealthRecordEntity that = (THealthRecordEntity) o;

        if (id != that.id) return false;
        if (userAccountId != null ? !userAccountId.equals(that.userAccountId) : that.userAccountId != null)
            return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (caloriesOut != null ? !caloriesOut.equals(that.caloriesOut) : that.caloriesOut != null) return false;
        if (max != null ? !max.equals(that.max) : that.max != null) return false;
        if (min != null ? !min.equals(that.min) : that.min != null) return false;
        if (minutes != null ? !minutes.equals(that.minutes) : that.minutes != null) return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userAccountId != null ? userAccountId.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (caloriesOut != null ? caloriesOut.hashCode() : 0);
        result = 31 * result + (max != null ? max.hashCode() : 0);
        result = 31 * result + (min != null ? min.hashCode() : 0);
        result = 31 * result + (minutes != null ? minutes.hashCode() : 0);
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        return result;
    }
}
