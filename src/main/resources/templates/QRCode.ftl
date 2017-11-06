<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8" />
<script src="/js/jquery-2.1.0.js"></script>
</head>
<body>
<img src="/download/createQRCode" border="0"> 
<a href="/download/createQRCode" id="DemoImg" border="0">点击下载文件 </a>



 Welcome<br/>
    <input id="text" type="text" /><button onclick="send()">Send</button>    <button onclick="closeWebSocket()">Close</button>
    <div id="message">
    </div>
</body>
<script> 
	  var websocket = null;
       
      //判断当前浏览器是否支持WebSocket
      if('WebSocket' in window){
          websocket = new WebSocket("http://localhost:8088/chat");
      }
      else{
          alert('Not support websocket');
      }
       
      //连接发生错误的回调方法
      websocket.onerror = function(){
          setMessageInnerHTML("error");
      };
       
      //连接成功建立的回调方法
      websocket.onopen = function(event){
          setMessageInnerHTML("open");
      };
       
      //接收到消息的回调方法
      websocket.onmessage = function(){
          setMessageInnerHTML(event.data);
      };
       
      //连接关闭的回调方法
      websocket.onclose = function(){
          setMessageInnerHTML("close");
      };
       
      //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
      window.onbeforeunload = function(){
          websocket.close();
      };
       
      //将消息显示在网页上
      function setMessageInnerHTML(innerHTML){
          document.getElementById('message').innerHTML += innerHTML + '<br/>';
      }
       
      //关闭连接
      function closeWebSocket(){
          websocket.close();
      }
       

$("#DemoImg").click(function(){
	SaveAs5($(this).attr("href"));
});

function SaveAs5(imgURL){ 
	var oPop = window.open(imgURL,"","width=1, height=1, top=5000, left=5000"); 
	for(; oPop.document.readyState != "complete"; ){ 
		if (oPop.document.readyState == "complete")break; 
	} 
	oPop.document.execCommand("SaveAs"); 
	oPop.close(); 
}
</script> 
</html>
