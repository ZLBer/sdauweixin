package po;

import java.sql.Timestamp;

/**
 * Created by libin on 2017/9/8.
 */
public class ResumeEntity {
    private int id;
    private int studentId;
    private int teacherId;
    private Timestamp time;
    private int state;
    private String reason;
    private String other1;
    private String other2;
    private String other3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1(String other1) {
        this.other1 = other1;
    }

    public String getOther2() {
        return other2;
    }

    public void setOther2(String other2) {
        this.other2 = other2;
    }

    public String getOther3() {
        return other3;
    }

    public void setOther3(String other3) {
        this.other3 = other3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResumeEntity that = (ResumeEntity) o;

        if (id != that.id) return false;
        if (studentId != that.studentId) return false;
        if (teacherId != that.teacherId) return false;
        if (state != that.state) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;
        if (other1 != null ? !other1.equals(that.other1) : that.other1 != null) return false;
        if (other2 != null ? !other2.equals(that.other2) : that.other2 != null) return false;
        if (other3 != null ? !other3.equals(that.other3) : that.other3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + studentId;
        result = 31 * result + teacherId;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + state;
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (other1 != null ? other1.hashCode() : 0);
        result = 31 * result + (other2 != null ? other2.hashCode() : 0);
        result = 31 * result + (other3 != null ? other3.hashCode() : 0);
        return result;
    }
}
