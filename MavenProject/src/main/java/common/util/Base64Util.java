package common.util;
import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;

public class Base64Util {
	
	/**
	 * º”√‹
	 * @param key
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("restriction")
	public static String base64Encryt(byte[] key) throws Exception{
		return (new BASE64Encoder()).encode(key);
	}
	/**
	 * Ω‚√‹
	 * @param key
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("restriction")
	public static byte[] base64Decoder(String key) throws Exception{
		return new BASE64Decoder().decodeBuffer(key);
	}
}
