package po;

/**
 * Created by Minister on 2017/5/11.
 */
public class NavigationloginEntity {
    private int navigationid;
    private String navigationname;
    private String navigationpwd;

    public int getNavigationid() {
        return navigationid;
    }

    public void setNavigationid(int navigationid) {
        this.navigationid = navigationid;
    }

    public String getNavigationname() {
        return navigationname;
    }

    public void setNavigationname(String navigationname) {
        this.navigationname = navigationname;
    }

    public String getNavigationpwd() {
        return navigationpwd;
    }

    public void setNavigationpwd(String navigationpwd) {
        this.navigationpwd = navigationpwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NavigationloginEntity that = (NavigationloginEntity) o;

        if (navigationid != that.navigationid) return false;
        if (navigationname != null ? !navigationname.equals(that.navigationname) : that.navigationname != null)
            return false;
        if (navigationpwd != null ? !navigationpwd.equals(that.navigationpwd) : that.navigationpwd != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = navigationid;
        result = 31 * result + (navigationname != null ? navigationname.hashCode() : 0);
        result = 31 * result + (navigationpwd != null ? navigationpwd.hashCode() : 0);
        return result;
    }
}
