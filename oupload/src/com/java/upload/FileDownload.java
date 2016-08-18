package com.java.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.factory.MusicFactory;
import com.java.bean.Music;
import com.java.daoimp.MusicDaoImpl;


@WebServlet("/index")
public class FileDownload extends HttpServlet {
	
	private MusicDaoImpl mdi=MusicFactory.getDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().setAttribute("musics", findAllMusic());
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private List<Music> findAllMusic(){
		
		
		
		return mdi.getMusics();
	}

}
