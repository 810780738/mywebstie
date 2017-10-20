package mywebstie;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class URLTest {
	public static void main(String[] args) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String time = simpleDateFormat.format(new Date());
		String URL = ("http://api.goseek.cn/Tools/holiday?date="+time).trim();
		String str = "asdasda&&12315";
		String ss = str.split("&&")[0];
		System.out.println(ss);
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
			JSONObject parseObject = JSON.parseObject(responseContent);
			String status = Integer.toString((Integer)parseObject.get("data"));
			if (status.equals("0"))System.out.println("今天工作");;
			if (status.equals("1"))System.out.println("今天休息");;
			if (status.equals("2"))System.out.println("今天放假");;
		}catch (Exception e) {
			System.err.println("访问发生异常："+e);
		}
	}
}
