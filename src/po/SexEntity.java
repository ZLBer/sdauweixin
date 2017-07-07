package po;

/**
 * Created by Minister on 2017/5/11.
 */
public class SexEntity implements CodeName{
    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SexEntity sexEntity = (SexEntity) o;

        if (code != null ? !code.equals(sexEntity.code) : sexEntity.code != null) return false;
        if (name != null ? !name.equals(sexEntity.name) : sexEntity.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
