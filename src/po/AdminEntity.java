package po;

/**
 * Created by Minister on 2017/5/11.
 */
public class AdminEntity {
    private int gid;
    private String gname;
    private String gpassword;

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGpassword() {
        return gpassword;
    }

    public void setGpassword(String gpassword) {
        this.gpassword = gpassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminEntity that = (AdminEntity) o;

        if (gid != that.gid) return false;
        if (gname != null ? !gname.equals(that.gname) : that.gname != null) return false;
        if (gpassword != null ? !gpassword.equals(that.gpassword) : that.gpassword != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gid;
        result = 31 * result + (gname != null ? gname.hashCode() : 0);
        result = 31 * result + (gpassword != null ? gpassword.hashCode() : 0);
        return result;
    }
    private static String getCity(String s){
        int index = 0;
        if(s.indexOf("省")>0){
            String city = s.substring(0,s.indexOf("市")+1);
            String county = s.substring(s.indexOf("市")+1,s.length());
            if (county.indexOf("区")>0){
                index = county.indexOf("区");
                return city+county.substring(0,index+1);
            }else if (county.indexOf("县")>0){
                index = county.indexOf("县");
                return city+county.substring(0,index+1);
            }else if (county.indexOf("市")>0){
                index = county.indexOf("市");
                return city+county.substring(0,index+1);
            }
        }
        return s;
    }
    public static void main(String[] args){
        System.out.println(getCity("山东省威海市乳山市asd"));
        System.out.println(getCity("山东省东营市东营区"));
        System.out.println(getCity("山东省威海市环翠区asd"));
        System.out.println(getCity("上海市"));
    }

}
