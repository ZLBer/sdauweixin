package po;

/**
 * Created by libin on 2017/6/3.
 */
public class XieyiEntity {
    private int studentid;
    private int xieyiid;
    private String comname;
    private String comnumber;
    private String comadress;
    private Integer comzipcode;
    private String comcontact;
    private String comtel;
    private String comemail;
    private String comnature;
    private String danganaddress;
    private Integer state;
    private String others;
    private String xieyinum;
    private String collegename;
    private String industry;
    private String category;
    private Integer downloadstate;

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getXieyiid() {
        return xieyiid;
    }

    public void setXieyiid(int xieyiid) {
        this.xieyiid = xieyiid;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }

    public String getComnumber() {
        return comnumber;
    }

    public void setComnumber(String comnumber) {
        this.comnumber = comnumber;
    }

    public String getComadress() {
        return comadress;
    }

    public void setComadress(String comadress) {
        this.comadress = comadress;
    }

    public Integer getComzipcode() {
        return comzipcode;
    }

    public void setComzipcode(Integer comzipcode) {
        this.comzipcode = comzipcode;
    }

    public String getComcontact() {
        return comcontact;
    }

    public void setComcontact(String comcontact) {
        this.comcontact = comcontact;
    }

    public String getComtel() {
        return comtel;
    }

    public void setComtel(String comtel) {
        this.comtel = comtel;
    }

    public String getComemail() {
        return comemail;
    }

    public void setComemail(String comemail) {
        this.comemail = comemail;
    }

    public String getComnature() {
        return comnature;
    }

    public void setComnature(String comnature) {
        this.comnature = comnature;
    }

    public String getDanganaddress() {
        return danganaddress;
    }

    public void setDanganaddress(String danganaddress) {
        this.danganaddress = danganaddress;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getXieyinum() {
        return xieyinum;
    }

    public void setXieyinum(String xieyinum) {
        this.xieyinum = xieyinum;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getDownloadstate() {
        return downloadstate;
    }

    public void setDownloadstate(Integer downloadstate) {
        this.downloadstate = downloadstate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XieyiEntity that = (XieyiEntity) o;

        if (studentid != that.studentid) return false;
        if (xieyiid != that.xieyiid) return false;
        if (comname != null ? !comname.equals(that.comname) : that.comname != null) return false;
        if (comnumber != null ? !comnumber.equals(that.comnumber) : that.comnumber != null) return false;
        if (comadress != null ? !comadress.equals(that.comadress) : that.comadress != null) return false;
        if (comzipcode != null ? !comzipcode.equals(that.comzipcode) : that.comzipcode != null) return false;
        if (comcontact != null ? !comcontact.equals(that.comcontact) : that.comcontact != null) return false;
        if (comtel != null ? !comtel.equals(that.comtel) : that.comtel != null) return false;
        if (comemail != null ? !comemail.equals(that.comemail) : that.comemail != null) return false;
        if (comnature != null ? !comnature.equals(that.comnature) : that.comnature != null) return false;
        if (danganaddress != null ? !danganaddress.equals(that.danganaddress) : that.danganaddress != null)
            return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (others != null ? !others.equals(that.others) : that.others != null) return false;
        if (xieyinum != null ? !xieyinum.equals(that.xieyinum) : that.xieyinum != null) return false;
        if (collegename != null ? !collegename.equals(that.collegename) : that.collegename != null) return false;
        if (industry != null ? !industry.equals(that.industry) : that.industry != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (downloadstate != null ? !downloadstate.equals(that.downloadstate) : that.downloadstate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentid;
        result = 31 * result + xieyiid;
        result = 31 * result + (comname != null ? comname.hashCode() : 0);
        result = 31 * result + (comnumber != null ? comnumber.hashCode() : 0);
        result = 31 * result + (comadress != null ? comadress.hashCode() : 0);
        result = 31 * result + (comzipcode != null ? comzipcode.hashCode() : 0);
        result = 31 * result + (comcontact != null ? comcontact.hashCode() : 0);
        result = 31 * result + (comtel != null ? comtel.hashCode() : 0);
        result = 31 * result + (comemail != null ? comemail.hashCode() : 0);
        result = 31 * result + (comnature != null ? comnature.hashCode() : 0);
        result = 31 * result + (danganaddress != null ? danganaddress.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (others != null ? others.hashCode() : 0);
        result = 31 * result + (xieyinum != null ? xieyinum.hashCode() : 0);
        result = 31 * result + (collegename != null ? collegename.hashCode() : 0);
        result = 31 * result + (industry != null ? industry.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (downloadstate != null ? downloadstate.hashCode() : 0);
        return result;
    }
}
