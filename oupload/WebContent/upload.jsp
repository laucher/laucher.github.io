<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>音乐上传页面</title></head>
<body>
 
<form action="${pageContext.servletContext.contextPath}/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <button type="submit">submit</button>
</form>
<button id="get">获取音乐</button>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript">
	var but=document.querySelector("#get");
	
	function load(url){	
		return new Promise(function(reslove,reject){
			var ajax=new XMLHttpRequest();
			ajax.open("get", url);
			ajax.responseType="arraybuffer";
			ajax.onreadystatechange=function(){
				if(ajax.readyState===4&&ajax.status=="200"){
					reslove(ajax.response);
				}
				if(ajax.status=="404"){
					reject();	
				}
			};
			ajax.send();	
		}); 
	}
	$(but).on("click",function(){
		console.log("点击了");
		var url="${pageContext.servletContext.contextPath}/Musics/1.mp3";
		load(url).then(function(data){
			console.log(url);
		});;
	});
		
		
</script>
</body>
</html>