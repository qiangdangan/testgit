package com.gwzd.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @文件名称: BeanUtil.java 
 * @包: com.gwzd.gwzdapi 
 * @版本：V1.0  
 * @版权所有：北京国网中电自动化技术有限公司
 * 
 * @创建人：高洪涛、强当安
 * @创建时间：2014年10月16日
 * @功能简介：类对象的常用工具类
 *
 */
public class BeanUtil
{

	/**
	 * @功能简介：用于java对象的克隆
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月16日 下午6:26:59
	 * @param obj：要克隆的目标对象
	 * @return：
	 */
	public static final Object cloneBean(Object obj)
	{
		try
		{
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(baos);
			out.writeObject(obj);
			out.close();
			ByteArrayInputStream bin = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream in = new ObjectInputStream(bin);
			Object clone = in.readObject();
			in.close();
			return (clone);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * @功能简介：使用反射根据属性名称获取属性值
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月16日 下午6:32:55
	 * @param fieldName 属性名称
	 * @param o 操作对象
	 * @return：属性值
	 */
	@SuppressWarnings("unused")
	private static Object getFieldValueByName(String fieldName, Object o)
	{
		Object value = null;
		try
		{
			if (fieldName.equals("serialVersionUID"))
			{
				value = "";
			}
			else
			{
				String firstLetter = fieldName.substring(0, 1).toUpperCase();
				String getter = "get" + firstLetter + fieldName.substring(1);
				Method method = o.getClass().getMethod(getter, new Class[] {});
				value = method.invoke(o, new Object[] {});
			}
		}
		catch (Exception e)
		{
			System.out.println("属性不存在");
		}
		return value;
	}

	/**
	 * @功能简介：根据实体获得对应数据库的表名
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月16日 下午6:52:22
	 * @param clazz
	 * @return：
	 */
	public static String getTableName(Class clazz)
	{
		@SuppressWarnings("unchecked")
		Table table = (Table) clazz.getAnnotation(Table.class);
		if (table != null)
		{
			return table.name();
		}
		return null;
	}

	

	/**
	 * @功能简介：根据实体获得指定属性对应数据库的字段
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月16日 下午6:50:56
	 * @param clazz
	 * @param fieldname
	 * @return：
	 */
	@SuppressWarnings("rawtypes")
	public static String getColumnName(Class clazz, String fieldname)
	{
		// 需要比较的属性
		PropertyDescriptor pd = null;
		try
		{
			pd = new PropertyDescriptor(fieldname, clazz);
		}
		catch (IntrospectionException e)
		{
			e.printStackTrace();
		}
		// field属性所对应的的属性方法
		Method method = pd.getReadMethod();
		return getColumnName(method);
	}
	
	private static String getColumnName(Method method)
	{
		Column column = method.getAnnotation(Column.class);
		if (column != null)
		{
			return column.name();
		}
		return null;
	}

	/**
	 * 把List&lt;Map&lt;String,Object&gt;&gt;转换为List&lt;String[]&gt;
	 * 
	 * @author 强当安
	 * @param list
	 *            被转化的List&lt;Map&lt;String,Object&gt;&gt;
	 * @param keysOrder
	 *            map中key的排序数组
	 * @return List&lt;String[]&gt;
	 */
	public static List<String[]> listMapConverToListString(List<Map<String, Object>> list, String[] keysOrder)
	{
		List<String[]> resultList = null;
		if (list != null && list.size() > 0 && keysOrder != null && keysOrder.length > 0)
		{
			resultList = new ArrayList<String[]>();
			for (Map<String, Object> map : list)
			{
				String[] strs = null;
				if (map != null && map.size() > 0)
				{

					strs = new String[keysOrder.length];
					int index = 0;
					for (String key : keysOrder)
					{

						String value = null;
						if (map.get(key) != null)
						{
							value = map.get(key).toString();
							value = value.trim();
						}
						strs[index] = value;
						index++;

					}
				}
				resultList.add(strs);
			}
		}
		return resultList;
	}
}
