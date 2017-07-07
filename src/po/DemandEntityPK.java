package po;

import java.io.Serializable;

/**
 * Created by Minister on 2017/5/11.
 */
public class DemandEntityPK implements Serializable {
    private int articleid;
    private int majorid;

    public int getArticleid() {
        return articleid;
    }

    public void setArticleid(int articleid) {
        this.articleid = articleid;
    }

    public int getMajorid() {
        return majorid;
    }

    public void setMajorid(int majorid) {
        this.majorid = majorid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DemandEntityPK that = (DemandEntityPK) o;

        if (articleid != that.articleid) return false;
        if (majorid != that.majorid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = articleid;
        result = 31 * result + majorid;
        return result;
    }
}
