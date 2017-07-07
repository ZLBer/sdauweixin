package po;

/**
 * Created by Minister on 2017/5/11.
 */
public class ColumnEntity {
    private int columnid;
    private String columnname;

    public int getColumnid() {
        return columnid;
    }

    public void setColumnid(int columnid) {
        this.columnid = columnid;
    }

    public String getColumnname() {
        return columnname;
    }

    public void setColumnname(String columnname) {
        this.columnname = columnname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ColumnEntity that = (ColumnEntity) o;

        if (columnid != that.columnid) return false;
        if (columnname != null ? !columnname.equals(that.columnname) : that.columnname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = columnid;
        result = 31 * result + (columnname != null ? columnname.hashCode() : 0);
        return result;
    }
}
