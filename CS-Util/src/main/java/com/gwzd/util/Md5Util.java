package com.gwzd.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * MD5加密工具
 * @author qiangzi
 *
 */
public class Md5Util {
	/**
	 * 
	 * @功能描述: 把字符串MD5加密 
	 * @创建人: 强当安
	 * @创建时间: Jun 20, 2014 12:09:11 PM
	 * @param str
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException String 返回类型
	 */
	public static String StringToMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		//String ret="";
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		//ret=new String(md5.digest(str.getBytes("UTF-8")),"UTF-8");
		byte []bytes=md5.digest(str.getBytes("UTF-8"));
		StringBuilder sb=new StringBuilder(bytes.length<<1);
		for(int i=0;i<bytes.length;i++){  
			sb.append(Character.forDigit((bytes[i]>>4)&0xf,16));  
			sb.append(Character.forDigit(bytes[i]&0xf,16));
		}
		return sb.toString();
	}
	
}
