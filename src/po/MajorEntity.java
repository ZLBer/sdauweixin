package po;

/**
 * Created by Minister on 2017/5/11.
 */
public class MajorEntity {
    private int majorid;
    private String majorname;
    private int collegeid;

    public int getMajorid() {
        return majorid;
    }

    public void setMajorid(int majorid) {
        this.majorid = majorid;
    }

    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname;
    }

    public int getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(int collegeid) {
        this.collegeid = collegeid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MajorEntity that = (MajorEntity) o;

        if (majorid != that.majorid) return false;
        if (collegeid != that.collegeid) return false;
        if (majorname != null ? !majorname.equals(that.majorname) : that.majorname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = majorid;
        result = 31 * result + (majorname != null ? majorname.hashCode() : 0);
        result = 31 * result + collegeid;
        return result;
    }
}
