package weixin.msg.Resp;

/**
 * Created by Administrator on 2017/9/8.
 */
public class TextCard {
    private String title;       //文本卡片信息的标题
    private String description;    //描述
    private String url;             //链接
    private String btntxt;          //详情

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBtntxt() {
        return btntxt;
    }

    public void setBtntxt(String btntxt) {
        this.btntxt = btntxt;
    }
}
