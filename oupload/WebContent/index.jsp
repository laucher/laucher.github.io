<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="description" content="HTML5 Audio Spectrum Visualizer">
        <meta charset="utf-8" />
        <title>HTML5 音乐播放器</title>
        <link rel="stylesheet" href="style/bootstrap.min.css" />
        <link type="text/css" rel="stylesheet" href="style/style.css">
    </head>
    <body>
    	
        <div id="wrapper">
        <div class="">
            <div id="fileWrapper" class="file_wrapper">
            	<h1 class="text-center">音乐/可视化</h1>
                <input type="file" id="uploadedFile"></input>
                <div class="text-center">
                	<strong id="vol-title">音量调节 </strong><input type="range" min="0" max="100" value="100" id="vol-progress">
                </div>
            </div>
            <div id="visualizer_wrapper" class="fixclear">
            	<div class="bar col-xs-3">
            		<button class="btn btn-danger btn-lg btn-block btn-upload">上传音乐</button>
            		<ul class="menu list-unstyled " >
		                <c:forEach items="${musics}" var="music" >
		                	<li class="item" data-path="${music.path}">${music.name}</li>
		                </c:forEach>
		            </ul>
            	</div>
            	<div class="col-xs-9">
            		<div id="info" class="text-left">
	                   show your music
            		</div>
                	<canvas id='canvas' width="800" height="350"></canvas>
                </div>
            </div>
        </div>
        </div>
        <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
        <script type="text/javascript" src="script/html5_audio_visualizer.js"></script>
    </body>
</html>