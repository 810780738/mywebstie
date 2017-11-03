package cn.mywebsite.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.zxing.client.j2se.MatrixToImageWriter;

import cn.mywebsite.util.QRCode;

@RequestMapping("/download")
@RestController
public class DownloadController {
	private static Log logger = LogFactory.getLog(DownloadController.class);

	@RequestMapping("/createQRCode")
	public void DownloadCode(HttpServletResponse response){
		ServletOutputStream stream = null;
			try {
				stream = response.getOutputStream();
				MatrixToImageWriter.writeToStream(QRCode.createQR("小雨" + UUID.randomUUID().toString()), "png", stream);
			} catch (IOException e) {
				logger.error("二维码生成异常",e);
			}finally {
				if (stream != null) {
					try {
						stream.flush();
					} catch (IOException e) {
						logger.error("流刷新异常",e);
					}
					try {
						stream.close();
					} catch (IOException e) {
						logger.error("溜关闭异常",e);
					}
				}
			}
	}

	@RequestMapping("/QRCode")
	public ModelAndView qrcode() {
		return new ModelAndView("QRCode");
	}

}
