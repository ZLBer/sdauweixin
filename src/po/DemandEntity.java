package po;

/**
 * Created by Minister on 2017/5/11.
 */
public class DemandEntity {
    private int articleid;
    private int majorid;
    private int demandnum;

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

    public int getDemandnum() {
        return demandnum;
    }

    public void setDemandnum(int demandnum) {
        this.demandnum = demandnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DemandEntity that = (DemandEntity) o;

        if (articleid != that.articleid) return false;
        if (majorid != that.majorid) return false;
        if (demandnum != that.demandnum) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = articleid;
        result = 31 * result + majorid;
        result = 31 * result + demandnum;
        return result;
    }
}
