package com.java.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.java.bean.Music;
import com.java.daoimp.MusicDaoImpl;
import com.java.util.IdGenertor;

public class DaoTest {

	@Test
	public void test() {
		
		MusicDaoImpl mdi=new MusicDaoImpl();
		
		Music mus1=new Music("11111", "这是第一张专辑", "33333");
		
		Music mus2=new Music("22222", "这是第二张专辑", "33333");
		

		
		List<Music> list=mdi.getMusics();
		
		assertEquals(list.size(), 2);
		
		for(Music m:list){
			System.out.println(m.getName());
			System.out.println(m.getPath());
		}
		
	}

}
