package po;

import java.sql.Timestamp;

/**
 * Created by Minister on 2017/5/11.
 */
public class ArticleEntity {
    private int articleid;
    private String enterprisename;
    private String articletext;
    private Timestamp articletime;
    private Integer columnid;
    private String author;
    private String authortel;
    private String mediaid;
    private String state;
    private String other;

    public int getArticleid() {
        return articleid;
    }

    public void setArticleid(int articleid) {
        this.articleid = articleid;
    }

    public String getEnterprisename() {
        return enterprisename;
    }

    public void setEnterprisename(String enterprisename) {
        this.enterprisename = enterprisename;
    }

    public String getArticletext() {
        return articletext;
    }

    public void setArticletext(String articletext) {
        this.articletext = articletext;
    }

    public Timestamp getArticletime() {
        return articletime;
    }

    public void setArticletime(Timestamp articletime) {
        this.articletime = articletime;
    }

    public Integer getColumnid() {
        return columnid;
    }

    public void setColumnid(Integer columnid) {
        this.columnid = columnid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthortel() {
        return authortel;
    }

    public void setAuthortel(String authortel) {
        this.authortel = authortel;
    }

    public String getMediaid() {
        return mediaid;
    }

    public void setMediaid(String mediaid) {
        this.mediaid = mediaid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleEntity that = (ArticleEntity) o;

        if (articleid != that.articleid) return false;
        if (enterprisename != null ? !enterprisename.equals(that.enterprisename) : that.enterprisename != null)
            return false;
        if (articletext != null ? !articletext.equals(that.articletext) : that.articletext != null) return false;
        if (articletime != null ? !articletime.equals(that.articletime) : that.articletime != null) return false;
        if (columnid != null ? !columnid.equals(that.columnid) : that.columnid != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (authortel != null ? !authortel.equals(that.authortel) : that.authortel != null) return false;
        if (mediaid != null ? !mediaid.equals(that.mediaid) : that.mediaid != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (other != null ? !other.equals(that.other) : that.other != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = articleid;
        result = 31 * result + (enterprisename != null ? enterprisename.hashCode() : 0);
        result = 31 * result + (articletext != null ? articletext.hashCode() : 0);
        result = 31 * result + (articletime != null ? articletime.hashCode() : 0);
        result = 31 * result + (columnid != null ? columnid.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (authortel != null ? authortel.hashCode() : 0);
        result = 31 * result + (mediaid != null ? mediaid.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (other != null ? other.hashCode() : 0);
        return result;
    }
}
