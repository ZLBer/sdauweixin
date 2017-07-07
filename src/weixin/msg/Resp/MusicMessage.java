package weixin.msg.Resp;
/**
 * 音乐消息
 * Author Engineer.Jsp
 * Date 2014.10.08*/
public class MusicMessage extends BaseMessage{
    // 音乐
    private weixin.msg.Resp.Music Music;

    public weixin.msg.Resp.Music getMusic() {
        return Music;
    }

    public void setMusic(weixin.msg.Resp.Music music) {
        Music = music;
    }

}
