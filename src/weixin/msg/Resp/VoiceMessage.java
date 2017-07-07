package weixin.msg.Resp;

/**
 * 语音消息
 *
 * @author Engineer.Jsp
 * @date 2014.10.08*
 */
public class VoiceMessage extends BaseMessage {
	// 语音
	private weixin.msg.Resp.Voice Voice;

	public weixin.msg.Resp.Voice getVoice() {
		return Voice;
	}

	public void setVoice(weixin.msg.Resp.Voice voice) {
		Voice = voice;
	}
}
