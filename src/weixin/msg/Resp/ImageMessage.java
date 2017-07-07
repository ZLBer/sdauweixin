package weixin.msg.Resp;

/**
 *
 * @author Engineer.Jsp
 * @date 2014.10.08*
 */
public class ImageMessage extends BaseMessage {

	private weixin.msg.Resp.Image Image;

	public weixin.msg.Resp.Image getImage() {
		return Image;
	}

	public void setImage(weixin.msg.Resp.Image image) {
		Image = image;
	}
}
