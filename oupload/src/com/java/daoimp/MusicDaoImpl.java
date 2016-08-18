package com.java.daoimp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.java.bean.Music;
import com.java.util.DBCPutil;


public class MusicDaoImpl {

	QueryRunner qr=new QueryRunner(DBCPutil.getDataSource());
	
	public void saveMusic(Music music){
		try {
			qr.update("insert into musics(id,name,path) values(?,?,?)",
					music.getId(),music.getName(),music.getPath());
		} catch (SQLException e) {
			
			throw new IllegalArgumentException();
		}
	}
	
	public List<Music> getMusics(){
		
		try {
			List<Music> musiclist=qr.query("select * from musics", new BeanListHandler<Music>(Music.class));
			return musiclist;
		} catch (Exception e) {
			throw new RuntimeException();		
		}
		
	}
	
}
