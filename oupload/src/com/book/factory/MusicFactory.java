package com.book.factory;

import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;

import com.java.daoimp.MusicDaoImpl;


public  class MusicFactory {
	private static String className;
	private static Properties pro;
	private static MusicDaoImpl musicdao;
	static{
		InputStream in=MusicFactory.class.getClassLoader().getResourceAsStream("factory/factory.properties");
		pro=new Properties();
		try {
			pro.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static MusicDaoImpl getDaoImpl(){
		className=pro.getProperty("name");
		Class c ;
		try {
			c = Class.forName(className);
			musicdao=(MusicDaoImpl) c.newInstance();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return musicdao;
	}


}
