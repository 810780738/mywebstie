package mywebstie;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


public class URLTest {
	
	public static Log logger = LogFactory.getLog(URLTest.class);
	
	public static void main(String[] args) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String time = simpleDateFormat.format(new Date());
//		String URL = ("http://api.goseek.cn/Tools/holiday?date="+time).trim();
		String URL = "http://www.divcss5.com/rumen/r544.shtml";
		
		
		BrowserVersion[] versions = { BrowserVersion.CHROME, BrowserVersion.FIREFOX_38,
				BrowserVersion.INTERNET_EXPLORER_11, BrowserVersion.INTERNET_EXPLORER_8 };
		@SuppressWarnings("resource")
		WebClient client = new WebClient(versions[(int) (versions.length * Math.random())]);
		client.getOptions().setUseInsecureSSL(true);
		client.getOptions().setThrowExceptionOnFailingStatusCode(false);
		client.getOptions().setJavaScriptEnabled(false);
		client.getOptions().setCssEnabled(false);
		client.getOptions().setThrowExceptionOnScriptError(false);
		client.getOptions().setTimeout(5000);
		client.getOptions().setAppletEnabled(true);
		client.getOptions().setGeolocationEnabled(true);
		client.getOptions().setRedirectEnabled(true);
		client.setJavaScriptTimeout(5000);
		String html = null;
		try {
			com.gargoylesoftware.htmlunit.Page page = null;
			try {
				page = client.getPage(URL);
				WebResponse response = page.getWebResponse();
				if (response.getContentType().equals("application/json")) {
					html = response.getContentAsString();
				} else if (page.isHtmlPage()) {
					html = ((HtmlPage) page).asXml();
				}
			} catch (Exception e) {
				logger.error("获取网页信息出错",e);
			}
		} catch (FailingHttpStatusCodeException e) {
			logger.error("访问"+URL+"出错！！！",e);
		}
		
		System.out.println(html);
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		org.apache.http.HttpEntity entity = null;
		String responseContent = null;
		try {
			// 创建默认的httpClient实例.
			String postUrl = URL;
			HttpPost httpPost = new HttpPost(postUrl);// 创建get请求
//			RequestConfig config = RequestConfig.custom().setSocketTimeout(0).setConnectTimeout(0)
//					.setConnectionRequestTimeout(0).build();
//			httpPost.setConfig(config);// 设置代理ip
										// 可根据响应状态进行换ip,ip在代理ip网站进行抓取，抓取到放到队列中
			httpPost.setHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.86 Safari/537.36");
			httpClient = HttpClients.createDefault();
			// 执行请求
			response = httpClient.execute(httpPost);
			entity = response.getEntity();
			responseContent = EntityUtils.toString(entity, "UTF-8");
//			JSONObject parseObject = JSON.parseObject(responseContent);
//			String status = Integer.toString((Integer)parseObject.get("data"));
//			if (status.equals("0"))System.out.println("今天工作");
//			if (status.equals("1"))System.out.println("今天休息");
//			if (status.equals("2"))System.out.println("今天放假");
//			System.out.println(responseContent);
		}catch (Exception e) {
			logger.error(e);
		}
	}
}
