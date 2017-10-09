package cn.mywebsite;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

@EnableAutoConfiguration
@SpringBootApplication
public class Application implements EmbeddedServletContainerCustomizer {

	public static Log logger = LogFactory.getLog(Application.class);

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		SpringApplication.run(Application.class, args);
		long endTime = System.currentTimeMillis();
		logger.info("启动成功!耗时：" + (endTime - startTime) + "毫秒");
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(8088);// 修改内置tomcat启动端口
	}

}
