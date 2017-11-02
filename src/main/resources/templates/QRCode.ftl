<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8" />
<script src="/js/jquery-2.1.0.js"></script>
</head>
<body>
<img src="/download/downloadQRCode" border="0"> 
<a href="/download/downloadQRCode" id="DemoImg" border="0">点击下载文件 </a>
</body>
<script> 

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
</script> 
</html>
