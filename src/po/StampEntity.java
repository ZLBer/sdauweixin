package po;

import java.sql.Timestamp;

/**
 * Created by john on 2017/5/24.
 */
public class StampEntity {
    private int stampid;
    private String studentid;
    private String studentname;
    private String studentmajor;
    private String collegestate;
    private String nstate;
    private String stampuserid;
    private Timestamp stamptime;
    private String functron;
    private String collegeid;

    public int getStampid() {
        return stampid;
    }

    public void setStampid(int stampid) {
        this.stampid = stampid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getStudentmajor() {
        return studentmajor;
    }

    public void setStudentmajor(String studentmajor) {
        this.studentmajor = studentmajor;
    }

    public String getCollegestate() {
        return collegestate;
    }

    public void setCollegestate(String collegestate) {
        this.collegestate = collegestate;
    }

    public String getNstate() {
        return nstate;
    }

    public void setNstate(String nstate) {
        this.nstate = nstate;
    }

    public String getStampuserid() {
        return stampuserid;
    }

    public void setStampuserid(String stampuserid) {
        this.stampuserid = stampuserid;
    }

    public Timestamp getStamptime() {
        return stamptime;
    }

    public void setStamptime(Timestamp stamptime) {
        this.stamptime = stamptime;
    }

    public String getFunctron() {
        return functron;
    }

    public void setFunctron(String functron) {
        this.functron = functron;
    }

    public String getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(String collegeid) {
        this.collegeid = collegeid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StampEntity that = (StampEntity) o;

        if (stampid != that.stampid) return false;
        if (studentid != null ? !studentid.equals(that.studentid) : that.studentid != null) return false;
        if (studentname != null ? !studentname.equals(that.studentname) : that.studentname != null) return false;
        if (studentmajor != null ? !studentmajor.equals(that.studentmajor) : that.studentmajor != null) return false;
        if (collegestate != null ? !collegestate.equals(that.collegestate) : that.collegestate != null) return false;
        if (nstate != null ? !nstate.equals(that.nstate) : that.nstate != null) return false;
        if (stampuserid != null ? !stampuserid.equals(that.stampuserid) : that.stampuserid != null) return false;
        if (stamptime != null ? !stamptime.equals(that.stamptime) : that.stamptime != null) return false;
        if (functron != null ? !functron.equals(that.functron) : that.functron != null) return false;
        if (collegeid != null ? !collegeid.equals(that.collegeid) : that.collegeid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stampid;
        result = 31 * result + (studentid != null ? studentid.hashCode() : 0);
        result = 31 * result + (studentname != null ? studentname.hashCode() : 0);
        result = 31 * result + (studentmajor != null ? studentmajor.hashCode() : 0);
        result = 31 * result + (collegestate != null ? collegestate.hashCode() : 0);
        result = 31 * result + (nstate != null ? nstate.hashCode() : 0);
        result = 31 * result + (stampuserid != null ? stampuserid.hashCode() : 0);
        result = 31 * result + (stamptime != null ? stamptime.hashCode() : 0);
        result = 31 * result + (functron != null ? functron.hashCode() : 0);
        result = 31 * result + (collegeid != null ? collegeid.hashCode() : 0);
        return result;
    }
}
