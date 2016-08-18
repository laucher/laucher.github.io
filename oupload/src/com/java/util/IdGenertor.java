package com.java.util;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class IdGenertor {
	public static String genGUID(){
		return new BigInteger(165, new Random()).toString(36).toUpperCase();
	}

	public static String genOrdernum() {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		String s1 = df.format(now);
		return s1+System.nanoTime();
	}
}
