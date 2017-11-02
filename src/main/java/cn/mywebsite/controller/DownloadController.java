package cn.mywebsite.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.zxing.client.j2se.MatrixToImageWriter;

import cn.mywebsite.util.QRCode;

@RequestMapping("/download")
@RestController
public class DownloadController {

	@RequestMapping("/downloadQRCode")
	public void DownloadCode(HttpServletResponse response) throws IOException {
		ServletOutputStream stream = response.getOutputStream();
		MatrixToImageWriter.writeToStream(QRCode.createQR("小雨" + UUID.randomUUID().toString()), "png", stream);
		if (stream != null) {
			stream.flush();
			stream.close();
		}
	}

	@RequestMapping("/QRCode")
	public ModelAndView qrcode() {
		return new ModelAndView("QRCode");
	}

}
