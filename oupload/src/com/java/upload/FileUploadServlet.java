package com.java.upload;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.book.factory.MusicFactory;
import com.java.bean.Music;
import com.java.daoimp.MusicDaoImpl;
import com.java.util.IdGenertor;


@WebServlet(name = "FileUploadServlet", urlPatterns = {"/upload"})
@MultipartConfig(location="C:\\WorkSpace\\EclipseJavaEE\\oupload\\WebContent\\Musics")
public class FileUploadServlet extends HttpServlet {
	
	private static final String SAVE_PATH = "C:\\WorkSpace\\EclipseJavaEE\\oupload\\WebContent\\Musics";
	
	private MusicDaoImpl mdi=MusicFactory.getDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			saveFile(request,response);
		
	}
	
	private void saveFile(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
        request.setCharacterEncoding("utf-8");
        
        Part part = request.getPart("file"); 
        File f = new File(SAVE_PATH + File.separator);
        if (!f.exists()) {
            f.mkdirs();
        }
        String h = part.getHeader("content-disposition");
        String filename = h.substring(h.lastIndexOf("=") + 2, h.length() - 1);
        
        String fileID=IdGenertor.genGUID();
        
        String realname="Musics"+File.separator+fileID+filename.substring(filename.lastIndexOf("."));
        
        String path=SAVE_PATH+File.separator+fileID+filename.substring(filename.lastIndexOf("."));
        
        part.write(path);
        
        System.out.println(filename);
        //todo 存进数据库
        mdi.saveMusic(new Music(fileID,filename,realname));
	}
	

}
