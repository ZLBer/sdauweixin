package po;

/**
 * Created by libin on 2017/9/8.
 */
public class TeacherEntity {
    private int id;
    private String teacherCollege;
    private String teacherLocation;
    private String teacherAddress;
    private String teacherTel;
    private String teacherName;
    private String other2;
    private String other3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherCollege() {
        return teacherCollege;
    }

    public void setTeacherCollege(String teacherCollege) {
        this.teacherCollege = teacherCollege;
    }

    public String getTeacherLocation() {
        return teacherLocation;
    }

    public void setTeacherLocation(String teacherLocation) {
        this.teacherLocation = teacherLocation;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public String getTeacherTel() {
        return teacherTel;
    }

    public void setTeacherTel(String teacherTel) {
        this.teacherTel = teacherTel;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String other1) {
        this.teacherName = other1;
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

        TeacherEntity that = (TeacherEntity) o;

        if (id != that.id) return false;
        if (teacherCollege != null ? !teacherCollege.equals(that.teacherCollege) : that.teacherCollege != null)
            return false;
        if (teacherLocation != null ? !teacherLocation.equals(that.teacherLocation) : that.teacherLocation != null)
            return false;
        if (teacherAddress != null ? !teacherAddress.equals(that.teacherAddress) : that.teacherAddress != null)
            return false;
        if (teacherTel != null ? !teacherTel.equals(that.teacherTel) : that.teacherTel != null) return false;
        if (teacherName != null ? !teacherName.equals(that.teacherName) : that.teacherName != null) return false;
        if (other2 != null ? !other2.equals(that.other2) : that.other2 != null) return false;
        if (other3 != null ? !other3.equals(that.other3) : that.other3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (teacherCollege != null ? teacherCollege.hashCode() : 0);
        result = 31 * result + (teacherLocation != null ? teacherLocation.hashCode() : 0);
        result = 31 * result + (teacherAddress != null ? teacherAddress.hashCode() : 0);
        result = 31 * result + (teacherTel != null ? teacherTel.hashCode() : 0);
        result = 31 * result + (teacherName != null ? teacherName.hashCode() : 0);
        result = 31 * result + (other2 != null ? other2.hashCode() : 0);
        result = 31 * result + (other3 != null ? other3.hashCode() : 0);
        return result;
    }
}
