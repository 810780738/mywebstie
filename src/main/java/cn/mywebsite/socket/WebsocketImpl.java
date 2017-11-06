package cn.mywebsite.socket;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RestController;

import cn.mywebsite.util.GetIpAddress;
import cn.mywebsite.util.OnlineCount;


/**
 * ClassName:WebsocketImpl
 * ClassDescription:基于websocket主动消息推送客户端
 * @author Administrator
 * @Data 2017年11月3日 下午3:16:28
 */
@ServerEndpoint("/chat")
@RestController
public class WebsocketImpl {
	private static Log logger = LogFactory.getLog(WebsocketImpl.class);
	
	//concurrent包下的set是线程安全的，用于存放每个客户端对应的websocket对象。如果需要服务端与客户端单一通信可以使用map存放
	private static CopyOnWriteArraySet<WebsocketImpl> webSocketSet = new CopyOnWriteArraySet<WebsocketImpl>();
	
	private Session session;//用于给客户端发送消息
	
	@OnOpen
	public void onOpen(Session session,HttpServletRequest request){
		this.session = session;
		webSocketSet.add(this);
		OnlineCount.addLineCount();//记录在线用户数量（在线用户数量常驻内存）
		logger.info("新连接加入,地址是："+GetIpAddress.getIpAddress(request));
	}
	
	@OnClose
	public void onClose() {
		webSocketSet.remove(this);
		OnlineCount.removeLineCount();
		logger.info("有新连接关闭，当前在线人数为："+OnlineCount.getOnLineCount());
	}
	
	/**
	 * MethodDescription:接受客户端发送过来的消息
	 * @author 朱守明
	 * @Data 2017年11月3日 下午3:38:02
	 * @param message 接收到的消息
	 * @param session session 可选参数
	 */
	@OnMessage
	public void onMessage(String message,Session session) {
		logger.info("接收到客户端发送的消息"+message);
		//群发消息，获取所有的在线人数
		for (WebsocketImpl websocketImpl : webSocketSet) {
			try {
				websocketImpl.sendMessage(message);
			} catch (IOException e) {
				logger.error("WebSocket:发送消息出错",e);
				continue;
			}
		}
	}
	
	/**
	 * MethodDescription:消息发送失败时捕获发送原因
	 * @author 朱守明
	 * @Data 2017年11月3日 下午3:45:32
	 */
	@OnError
	public void onError(Session session,Throwable error) {
		System.err.println("WebSocket发送消息出错");
		error.printStackTrace();
	}
	
	/**
	 * MethodDescription:发送消息
	 * @author 朱守明
	 * @Data 2017年11月3日 下午3:43:12
	 * @param message
	 * @throws IOException 
	 */
	public void sendMessage(String message) throws IOException {
//		try {
			this.session.getBasicRemote().sendText(message);
//		} catch (IOException e) {
//			logger.error("WebSocket:发送消息出错",e);
//		}
	}
}
