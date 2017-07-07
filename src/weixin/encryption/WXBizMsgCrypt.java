
package weixin.encryption;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Random;


public class WXBizMsgCrypt {
	static Charset CHARSET = Charset.forName("utf-8");
	Base64 base64 = new Base64();
	byte[] aesKey;
	String token;
	String corpId;

	public WXBizMsgCrypt(String token, String encodingAesKey, String corpId) throws AesException {
		if (encodingAesKey.length() != 43) {
			throw new AesException(AesException.IllegalAesKey);
		}

		this.token = token;
		this.corpId = corpId;
		aesKey = Base64.decodeBase64(encodingAesKey + "=");
	}

	// 鐢熸垚4涓瓧鑺傜殑缃戠粶瀛楄妭搴�
	byte[] getNetworkBytesOrder(int sourceNumber) {
		byte[] orderBytes = new byte[4];
		orderBytes[3] = (byte) (sourceNumber & 0xFF);
		orderBytes[2] = (byte) (sourceNumber >> 8 & 0xFF);
		orderBytes[1] = (byte) (sourceNumber >> 16 & 0xFF);
		orderBytes[0] = (byte) (sourceNumber >> 24 & 0xFF);
		return orderBytes;
	}

	// 杩樺師4涓瓧鑺傜殑缃戠粶瀛楄妭搴�
	int recoverNetworkBytesOrder(byte[] orderBytes) {
		int sourceNumber = 0;
		for (int i = 0; i < 4; i++) {
			sourceNumber <<= 8;
			sourceNumber |= orderBytes[i] & 0xff;
		}
		return sourceNumber;
	}

	// 闅忔満鐢熸垚16浣嶅瓧绗︿覆
	String getRandomStr() {
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 16; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 瀵规槑鏂囪繘琛屽姞瀵�
	 * 
	 * @param text 闇�鍔犲瘑鐨勬槑鏂�
	 * @return 鍔犲瘑鍚巄ase64缂栫爜鐨勫瓧绗︿覆
	 * @throws AesException aes鍔犲瘑澶辫触
	 */
	String encrypt(String randomStr, String text) throws AesException {
		ByteGroup byteCollector = new ByteGroup();
		byte[] randomStrBytes = randomStr.getBytes(CHARSET);
		byte[] textBytes = text.getBytes(CHARSET);
		byte[] networkBytesOrder = getNetworkBytesOrder(textBytes.length);
		byte[] corpidBytes = corpId.getBytes(CHARSET);

		// randomStr + networkBytesOrder + text + corpid
		byteCollector.addBytes(randomStrBytes);
		byteCollector.addBytes(networkBytesOrder);
		byteCollector.addBytes(textBytes);
		byteCollector.addBytes(corpidBytes);

		// ... + pad: 浣跨敤鑷畾涔夌殑濉厖鏂瑰紡瀵规槑鏂囪繘琛岃ˉ浣嶅～鍏�
		byte[] padBytes = PKCS7Encoder.encode(byteCollector.size());
		byteCollector.addBytes(padBytes);

		// 鑾峰緱鏈�粓鐨勫瓧鑺傛祦, 鏈姞瀵�
		byte[] unencrypted = byteCollector.toBytes();

		try {
			// 璁剧疆鍔犲瘑妯″紡涓篈ES鐨凜BC妯″紡
			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			SecretKeySpec keySpec = new SecretKeySpec(aesKey, "AES");
			IvParameterSpec iv = new IvParameterSpec(aesKey, 0, 16);
			cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);

			// 鍔犲瘑
			byte[] encrypted = cipher.doFinal(unencrypted);

			// 浣跨敤BASE64瀵瑰姞瀵嗗悗鐨勫瓧绗︿覆杩涜缂栫爜
			String base64Encrypted = base64.encodeToString(encrypted);

			return base64Encrypted;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AesException(AesException.EncryptAESError);
		}
	}

	/**
	 * 瀵瑰瘑鏂囪繘琛岃В瀵�
	 * 
	 * @param text 闇�瑙ｅ瘑鐨勫瘑鏂�
	 * @return 瑙ｅ瘑寰楀埌鐨勬槑鏂�
	 * @throws AesException aes瑙ｅ瘑澶辫触
	 */
	String decrypt(String text) throws AesException {
		byte[] original;
		try {
			// 璁剧疆瑙ｅ瘑妯″紡涓篈ES鐨凜BC妯″紡
			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			SecretKeySpec key_spec = new SecretKeySpec(aesKey, "AES");
			IvParameterSpec iv = new IvParameterSpec(Arrays.copyOfRange(aesKey, 0, 16));
			cipher.init(Cipher.DECRYPT_MODE, key_spec, iv);

			// 浣跨敤BASE64瀵瑰瘑鏂囪繘琛岃В鐮�
			byte[] encrypted = Base64.decodeBase64(text);

			// 瑙ｅ瘑
			original = cipher.doFinal(encrypted);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AesException(AesException.DecryptAESError);
		}

		String xmlContent, from_corpid;
		try {
			// 鍘婚櫎琛ヤ綅瀛楃
			byte[] bytes = PKCS7Encoder.decode(original);

			// 鍒嗙16浣嶉殢鏈哄瓧绗︿覆,缃戠粶瀛楄妭搴忓拰corpId
			byte[] networkOrder = Arrays.copyOfRange(bytes, 16, 20);

			int xmlLength = recoverNetworkBytesOrder(networkOrder);

			xmlContent = new String(Arrays.copyOfRange(bytes, 20, 20 + xmlLength), CHARSET);
			from_corpid = new String(Arrays.copyOfRange(bytes, 20 + xmlLength, bytes.length),
					CHARSET);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AesException(AesException.IllegalBuffer);
		}

		// corpid涓嶇浉鍚岀殑鎯呭喌
		if (!from_corpid.equals(corpId)) {
			throw new AesException(AesException.ValidateCorpidError);
		}
		return xmlContent;

	}

	/**
	 * 灏嗗叕浼楀钩鍙板洖澶嶇敤鎴风殑娑堟伅鍔犲瘑鎵撳寘.
	 * <ol>
	 * 	<li>瀵硅鍙戦�鐨勬秷鎭繘琛孉ES-CBC鍔犲瘑</li>
	 * 	<li>鐢熸垚瀹夊叏绛惧悕</li>
	 * 	<li>灏嗘秷鎭瘑鏂囧拰瀹夊叏绛惧悕鎵撳寘鎴恱ml鏍煎紡</li>
	 * </ol>
	 * 
	 * @param replyMsg 鍏紬骞冲彴寰呭洖澶嶇敤鎴风殑娑堟伅锛寈ml鏍煎紡鐨勫瓧绗︿覆
	 * @param timeStamp 鏃堕棿鎴筹紝鍙互鑷繁鐢熸垚锛屼篃鍙互鐢║RL鍙傛暟鐨則imestamp
	 * @param nonce 闅忔満涓诧紝鍙互鑷繁鐢熸垚锛屼篃鍙互鐢║RL鍙傛暟鐨刵once
	 * 
	 * @return 鍔犲瘑鍚庣殑鍙互鐩存帴鍥炲鐢ㄦ埛鐨勫瘑鏂囷紝鍖呮嫭msg_signature, timestamp, nonce, encrypt鐨剎ml鏍煎紡鐨勫瓧绗︿覆
	 * @throws AesException 鎵ц澶辫触锛岃鏌ョ湅璇ュ紓甯哥殑閿欒鐮佸拰鍏蜂綋鐨勯敊璇俊鎭�
	 */
	public String EncryptMsg(String replyMsg, String timeStamp, String nonce) throws AesException {
		// 鍔犲瘑
		String encrypt = encrypt(getRandomStr(), replyMsg);

		// 鐢熸垚瀹夊叏绛惧悕
		if (timeStamp == "") {
			timeStamp = Long.toString(System.currentTimeMillis());
		}

		String signature = SHA1.getSHA1(token, timeStamp, nonce, encrypt);

		// System.out.println("鍙戦�缁欏钩鍙扮殑绛惧悕鏄� " + signature[1].toString());
		// 鐢熸垚鍙戦�鐨剎ml
		String result = XMLParse.generate(encrypt, signature, timeStamp, nonce);
		return result;
	}

	/**
	 * 妫�獙娑堟伅鐨勭湡瀹炴�锛屽苟涓旇幏鍙栬В瀵嗗悗鐨勬槑鏂�
	 * <ol>
	 * 	<li>鍒╃敤鏀跺埌鐨勫瘑鏂囩敓鎴愬畨鍏ㄧ鍚嶏紝杩涜绛惧悕楠岃瘉</li>
	 * 	<li>鑻ラ獙璇侀�杩囷紝鍒欐彁鍙杧ml涓殑鍔犲瘑娑堟伅</li>
	 * 	<li>瀵规秷鎭繘琛岃В瀵�/li>
	 * </ol>
	 * 
	 * @param msgSignature 绛惧悕涓诧紝瀵瑰簲URL鍙傛暟鐨刴sg_signature
	 * @param timeStamp 鏃堕棿鎴筹紝瀵瑰簲URL鍙傛暟鐨則imestamp
	 * @param nonce 闅忔満涓诧紝瀵瑰簲URL鍙傛暟鐨刵once
	 * @param postData 瀵嗘枃锛屽搴擯OST璇锋眰鐨勬暟鎹�
	 * 
	 * @return 瑙ｅ瘑鍚庣殑鍘熸枃
	 * @throws AesException 鎵ц澶辫触锛岃鏌ョ湅璇ュ紓甯哥殑閿欒鐮佸拰鍏蜂綋鐨勯敊璇俊鎭�
	 */
	public String DecryptMsg(String msgSignature, String timeStamp, String nonce, String postData)
			throws AesException {

		// 瀵嗛挜锛屽叕浼楄处鍙风殑app secret
		// 鎻愬彇瀵嗘枃
		Object[] encrypt = XMLParse.extract(postData);

		// 楠岃瘉瀹夊叏绛惧悕
		String signature = SHA1.getSHA1(token, timeStamp, nonce, encrypt[1].toString());

		// 鍜孶RL涓殑绛惧悕姣旇緝鏄惁鐩哥瓑
		// System.out.println("绗笁鏂规敹鍒癠RL涓殑绛惧悕锛� + msg_sign);
		// System.out.println("绗笁鏂规牎楠岀鍚嶏細" + signature);
		if (!signature.equals(msgSignature)) {
			throw new AesException(AesException.ValidateSignatureError);
		}

		// 瑙ｅ瘑
		String result = decrypt(encrypt[1].toString());
		return result;
	}

	/**
	 * 楠岃瘉URL
	 * @param msgSignature 绛惧悕涓诧紝瀵瑰簲URL鍙傛暟鐨刴sg_signature
	 * @param timeStamp 鏃堕棿鎴筹紝瀵瑰簲URL鍙傛暟鐨則imestamp
	 * @param nonce 闅忔満涓诧紝瀵瑰簲URL鍙傛暟鐨刵once
	 * @param echoStr 闅忔満涓诧紝瀵瑰簲URL鍙傛暟鐨別chostr
	 * 
	 * @return 瑙ｅ瘑涔嬪悗鐨別chostr
	 * @throws AesException 鎵ц澶辫触锛岃鏌ョ湅璇ュ紓甯哥殑閿欒鐮佸拰鍏蜂綋鐨勯敊璇俊鎭�
	 */
	public String VerifyURL(String msgSignature, String timeStamp, String nonce, String echoStr)
			throws AesException {
		String signature = SHA1.getSHA1(token, timeStamp, nonce, echoStr);

		if (!signature.equals(msgSignature)) {
			throw new AesException(AesException.ValidateSignatureError);
		}

		String result = decrypt(echoStr);
		return result;
	}

}