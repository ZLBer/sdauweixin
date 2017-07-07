package po;

/**
 * Created by Minister on 2017/5/11.
 */
public class StudentloginEntity {
    private int studentid;
    private String studentpassword;

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getStudentpassword() {
        return studentpassword;
    }

    public void setStudentpassword(String studentpassword) {
        this.studentpassword = studentpassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentloginEntity that = (StudentloginEntity) o;

        if (studentid != that.studentid) return false;
        if (studentpassword != null ? !studentpassword.equals(that.studentpassword) : that.studentpassword != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentid;
        result = 31 * result + (studentpassword != null ? studentpassword.hashCode() : 0);
        return result;
    }
}
