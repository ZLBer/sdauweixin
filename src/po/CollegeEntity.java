package po;

/**
 * Created by Minister on 2017/5/11.
 */
public class CollegeEntity {
    private int collegeid;
    private String collegename;

    public int getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(int collegeid) {
        this.collegeid = collegeid;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollegeEntity that = (CollegeEntity) o;

        if (collegeid != that.collegeid) return false;
        if (collegename != null ? !collegename.equals(that.collegename) : that.collegename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = collegeid;
        result = 31 * result + (collegename != null ? collegename.hashCode() : 0);
        return result;
    }
}
