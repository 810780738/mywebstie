package cn.mywebsite.util;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * ClassName:QRCode ClassDescription:Google的zxing生成二维码
 * 
 * @author Administrator
 * @Data 2017年11月2日 下午4:09:06
 */
public class QRCode {

	private static Log logger = LogFactory.getLog(QRCode.class);

	private final static int width = 200;// 二维码宽
	private final static int height = 200;// 二维码高

	/**
	 * MethodDescription:生成二维码
	 * 
	 * @author 朱守明
	 * @Data 2017年11月2日 下午4:10:41
	 * @param contents
	 *            二维码中的内容
	 */
	public static BitMatrix createQR(String contents) {
		BitMatrix encode = null;
		if (OSName.getOSName().equals(OSName.Windows)) {
			QRCodeWriter writer = new QRCodeWriter();
			if (!StringUtil.isEmpty(contents)) {
				try {
					contents = new String(contents.getBytes("UTF-8"), "ISO-8859-1");
					encode = writer.encode(contents, BarcodeFormat.QR_CODE, height, width);
				} catch (WriterException e) {
					logger.error("二维码生成出错", e);
				} catch (UnsupportedEncodingException e) {
					logger.error("二维码内容编码出错", e);
				}
			}

		}
		
		return encode;
	}

}
