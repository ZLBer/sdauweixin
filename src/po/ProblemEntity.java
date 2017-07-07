package po;

import java.sql.Timestamp;

/**
 * Created by john on 2017/5/24.
 */
public class ProblemEntity {
    private int studentid;
    private int problemid;
    private String problemtext;
    private int collegeid;
    private Integer problemstate;
    private Timestamp problemtime;
    private String replytext;
    private Timestamp replytime;
    private String teachername;

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getProblemid() {
        return problemid;
    }

    public void setProblemid(int problemid) {
        this.problemid = problemid;
    }

    public String getProblemtext() {
        return problemtext;
    }

    public void setProblemtext(String problemtext) {
        this.problemtext = problemtext;
    }

    public int getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(int collegeid) {
        this.collegeid = collegeid;
    }

    public Integer getProblemstate() {
        return problemstate;
    }

    public void setProblemstate(Integer problemstate) {
        this.problemstate = problemstate;
    }

    public Timestamp getProblemtime() {
        return problemtime;
    }

    public void setProblemtime(Timestamp problemtime) {
        this.problemtime = problemtime;
    }

    public String getReplytext() {
        return replytext;
    }

    public void setReplytext(String replytext) {
        this.replytext = replytext;
    }

    public Timestamp getReplytime() {
        return replytime;
    }

    public void setReplytime(Timestamp replytime) {
        this.replytime = replytime;
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

        ProblemEntity that = (ProblemEntity) o;

        if (studentid != that.studentid) return false;
        if (problemid != that.problemid) return false;
        if (collegeid != that.collegeid) return false;
        if (problemtext != null ? !problemtext.equals(that.problemtext) : that.problemtext != null) return false;
        if (problemstate != null ? !problemstate.equals(that.problemstate) : that.problemstate != null) return false;
        if (problemtime != null ? !problemtime.equals(that.problemtime) : that.problemtime != null) return false;
        if (replytext != null ? !replytext.equals(that.replytext) : that.replytext != null) return false;
        if (replytime != null ? !replytime.equals(that.replytime) : that.replytime != null) return false;
        if (teachername != null ? !teachername.equals(that.teachername) : that.teachername != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentid;
        result = 31 * result + problemid;
        result = 31 * result + (problemtext != null ? problemtext.hashCode() : 0);
        result = 31 * result + collegeid;
        result = 31 * result + (problemstate != null ? problemstate.hashCode() : 0);
        result = 31 * result + (problemtime != null ? problemtime.hashCode() : 0);
        result = 31 * result + (replytext != null ? replytext.hashCode() : 0);
        result = 31 * result + (replytime != null ? replytime.hashCode() : 0);
        result = 31 * result + (teachername != null ? teachername.hashCode() : 0);
        return result;
    }
}
