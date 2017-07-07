package po;

/**
 * Created by john on 2017/5/24.
 */
public class CollegeloginEntity {
    private int collegeuserid;
    private int collegeid;
    private String collegepwd;
    private String empno;
    private String teachername;

    public int getCollegeuserid() {
        return collegeuserid;
    }

    public void setCollegeuserid(int collegeuserid) {
        this.collegeuserid = collegeuserid;
    }

    public int getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(int collegeid) {
        this.collegeid = collegeid;
    }

    public String getCollegepwd() {
        return collegepwd;
    }

    public void setCollegepwd(String collegepwd) {
        this.collegepwd = collegepwd;
    }

    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollegeloginEntity that = (CollegeloginEntity) o;

        if (collegeuserid != that.collegeuserid) return false;
        if (collegeid != that.collegeid) return false;
        if (collegepwd != null ? !collegepwd.equals(that.collegepwd) : that.collegepwd != null) return false;
        if (empno != null ? !empno.equals(that.empno) : that.empno != null) return false;
        if (teachername != null ? !teachername.equals(that.teachername) : that.teachername != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = collegeuserid;
        result = 31 * result + collegeid;
        result = 31 * result + (collegepwd != null ? collegepwd.hashCode() : 0);
        result = 31 * result + (empno != null ? empno.hashCode() : 0);
        result = 31 * result + (teachername != null ? teachername.hashCode() : 0);
        return result;
    }
}
