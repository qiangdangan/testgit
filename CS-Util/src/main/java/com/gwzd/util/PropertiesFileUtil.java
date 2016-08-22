package com.gwzd.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;

/**
 * upload.Properties文件中的属性读取
 * 
 * @author 强当安
 * 
 */
public class PropertiesFileUtil
{
	private static Properties p = null;
	static
	{
		try
		{
			String classPath = PropertiesFileUtil.class.getResource("/").getPath();
			classPath = URLDecoder.decode(classPath, "utf-8");
			p = new Properties();
			p.load(new FileInputStream(classPath + "syscfg.properties"));
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 按照keyName读取syscfg.properties文件中对应的值
	 * 
	 * @param keyName
	 * @author 强当安
	 * @return
	 */
	public static String getKey(String keyName)
	{
		return DataSwitch.convertObjectToString(p.get(keyName));
	}

	/**
	 * 读取上传文件根目录
	 * 
	 * @author 强当安
	 * @return
	 */
	public static String getRootSavePath()
	{
		return getKey("rootSavePath");
	}

	public static void main(String[] args)
	{
		System.out.println(PropertiesFileUtil.class.getResource("/").getPath());
	}
}
