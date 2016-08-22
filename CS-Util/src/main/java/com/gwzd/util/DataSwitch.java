package com.gwzd.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @文件名称: DataSwitch.java
 * @包: com.gwzd.gwzdapi
 * @版本：V1.0
 * @版权所有：北京国网中电自动化技术有限公司
 * 
 * @创建人：高洪涛
 * @创建时间：2014年10月16日
 * @功能简介：
 * 
 */
public class DataSwitch
{

    private static final Logger logger = Logger.getLogger(DataSwitch.class);

    /**
     * 
     * @功能简介：将整型对象格式字符串转换成整型对象，如果传入对象为 null 或 空，返回 0
     * @应用页面：
     * @作者姓名：高洪涛
     * @创建时间：2014年10月16日 下午3:30:39
     * @参数说明：@param value
     * @返回类型：Integer
     * 
     */
    public static Integer convertObjectToInteger(Object value)
    {
        try
        {
            if (null != value)
            {
                return Integer.parseInt(value.toString());
            }
            else
            {
                return null;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    /**
     * 
     * @功能简介：将类型转换成Double对象，如果传入对象为 null 或 空，返回 0.0
     * @应用页面：
     * @作者姓名：高洪涛
     * @创建时间：2014年10月16日 下午3:38:47
     * @返回类型：Double
     * 
     */
    public static Double convertObjectToDouble(Object value)
    {
        try
        {
            if (null != value)
            {
                return Double.parseDouble(value.toString());
            }
            else
            {
                return null;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    /**
     * @功能简介：转换货币格式的字符串，保留2为小数格式
     * @应用页面：
     * @作者姓名：高洪涛
     * @创建时间：2014年10月16日 下午3:43:32
     * @返回类型：String
     * 
     */
    public static String convertToMoney(Object value)
    {
        try
        {
            if (null != value)
            {
                String format = "#.00";
                return new DecimalFormat(format).format(value);
            }
            else
            {
                return null;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    /**
     * @功能简介：将对象转换成Long对象，如果传入对象为 null 或 空，返回 0l
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午5:50:49
     * @param value
     *            ： 传入参数值
     * @return：
     */
    public static Long convertObjectToLong(Object value)
    {
        try
        {
            if (null != value)
            {
                return Long.valueOf(value.toString());
            }
            else
            {
                return null;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    /**
     * @功能简介：将对象转换成Float对象，如果传入对象为 null 或 空，返回 0f
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午3:52:20
     * @参数说明：@param value
     * @参数说明：@return
     * @返回类型：Float
     * 
     */
    public static Float convertObjectToFloat(Object value)
    {
        try
        {
            if (null != value)
            {
                return Float.valueOf(value.toString());
            }
            else
            {
                return null;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    /**
     * @功能简介：将对象转换成BigDecimal对象，如果传入对象为 null 或 空，返回 null
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午3:52:54
     * @参数说明：@param value
     * @参数说明：@return
     * @返回类型：BigDecimal
     */
    public static BigDecimal convertObjectToBigDecimal(Object value)
    {
        try
        {
            if (null != value)
            {
                return new BigDecimal(value.toString());
            }
            else
            {
                return null;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    /**
     * @功能简介：将对象转换成Short对象，如果传入对象为 null 或 空，返回 null
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午4:06:51
     * @参数说明：@param value
     * @参数说明：@return
     * @返回类型：Short
     */
    public static Short convertObjectToShort(Object value)
    {
        try
        {
            if (null != value)
            {
                return Short.parseShort(value.toString());
            }
            else
            {
                return null;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    /**
     * @功能简介：将对象转换成Boolean对象，如果传入对象为 null 或 空，返回 0
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午4:07:23
     * @参数说明：@param value
     * @参数说明：@return
     * @返回类型：Boolean
     */
    public static Boolean convertObjectToBoolean(Object value)
    {
        try
        {
            if (null != value)
            {
                return (Boolean) value;
            }
            else
            {
                return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }
    }

    /**
     * @功能简介：将对象转换成String对象，如果传入对象为 null 或 空，返回 ""
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午4:08:53
     * @参数说明：@param value
     * @参数说明：@return
     * @返回类型：String
     */
    public static String convertObjectToString(Object value)
    {
        try
        {
            if (null != value)
            {
                return value.toString();
            }
            else
            {
                return "";
            }
        }
        catch (Exception e)
        {
        	e.printStackTrace();
            return "";
        }
    }

    /**
     * @功能简介：oracle.sql.Clob类型转换成String类型
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午4:10:01
     * @参数说明：@param clob
     * @参数说明：@return
     * @返回类型：String
     */
    public static String convertClobToString(Clob clob)
    {
        String reString = "";
        Reader is = null;
        try
        {
            is = clob.getCharacterStream();
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 得到流
        BufferedReader br = new BufferedReader(is);
        String s = null;
        try
        {
            s = br.readLine();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        StringBuffer sb = new StringBuffer();
        while (s != null)
        {
            // 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
            sb.append(s);
            try
            {
                s = br.readLine();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        reString = sb.toString();
        return reString;
    }

    /**
     * @功能简介：根据用户传入的实体类型(数组)，和页面级Map，获得返回实体
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午4:18:27
     * @参数说明：@param typClass: 实体类型
     * @参数说明：@param map
     * @返回类型：T
     */
    public static <T> T ConvertDataTableToEntity(T typClass, Map<String, String[]> map)
    {
        try
        {
            BeanInfo beanInfo = Introspector.getBeanInfo(typClass.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors)
            {
                String name = propertyDescriptor.getName();
                Type type = propertyDescriptor.getPropertyType();
                String[] value = map.get(name);
                if (map.keySet().contains(name))
                {
                    // propertyDescriptor.getWriteMethod().invoke(typClass, getDefaultValue(Escape.unescape(value[0].trim()), type));
                    propertyDescriptor.getWriteMethod().invoke(typClass, getDefaultValue(value[0].trim(), type));
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        return typClass;
    }

    private static Object getDefaultValue(Object value, Type type)
    {
        Object resultObject = "";
        if (value == null)
        {
            resultObject = "";
        }
        else
        {
            if (type == String.class)
            {
                resultObject = convertObjectToString(value);
            }
            else if (type == Integer.class || type == int.class)
            {
                resultObject = convertObjectToInteger(value);
            }
            else if (type == Long.class || type == long.class)
            {
                resultObject = convertObjectToLong(value);
            }
            else if (type == Date.class)
            {
                resultObject = convertObjectToDate(value);
            }
            else if (type == Double.class || type == double.class)
            {
                resultObject = convertObjectToDouble(value);
            }
            else if (type == Float.class || type == float.class)
            {
                resultObject = convertObjectToFloat(value);
            }
            else if (type == Boolean.class || type == boolean.class)
            {
                resultObject = convertObjectToBoolean(value);
            }
            else if (type == BigDecimal.class)
            {
                resultObject = convertObjectToBigDecimal(value);
            }
            else if (type == Short.class)
            {
                resultObject = convertObjectToShort(value);
            }
            else
            {
                resultObject = "";
            }
        }
        return resultObject;
    }

    /**
     * @功能简介：将日期字符串转换成日期对象
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午4:56:34
     * @param time
     * @return：
     */
    public static Date convertObjectToDate(Object time)
    {
        try
        {
            String format = null;
            if (time == null || "".equals(DataSwitch.convertObjectToString(time)))
            {
                return null;
            }
            if (time.toString().contains(":"))
            {
                if (time.toString().indexOf(":") == time.toString().lastIndexOf(":"))
                {
                    format = "yyyy-MM-dd HH:mm";
                }
                else
                {
                    format = "yyyy-MM-dd HH:mm:ss";
                }
            }
            else
            {
                format = "yyyy-MM-dd";
            }
            return DateUtils.parseDate(time.toString(), new String[]{
                format
            });
        }
        catch (ParseException e)
        {
            logger.error("日期格式错误{" + time + "}，正确格式为：yyyy-MM-dd HH:mm");
            throw new RuntimeException(e);
        }
    }

    /**
     * @功能简介：根据用户传入的实体类型，和页面级Map，获得返回实体
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午4:21:16
     * @参数说明：@param typClass
     * @参数说明：@param map
     * @参数说明：@return
     * @返回类型：T
     */
    public static <T> T ConvertMapToEntity(T typClass, Map<String, Object> map)
    {
        try
        {
            BeanInfo beanInfo = Introspector.getBeanInfo(typClass.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors)
            {
                String name = propertyDescriptor.getName().toUpperCase();

                Type type = propertyDescriptor.getPropertyType();
                Object value = map.get(name);
                if (value == null || value.toString().length() == 0)
                {
                    continue;
                }
                if (map.keySet().contains(name))
                {
                    propertyDescriptor.getWriteMethod().invoke(typClass, getDefaultValue(value.toString().trim(), type));
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        return typClass;

    }

    /**
     * @功能简介：将实体对象转换成Map对象
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午4:23:54
     * @参数说明：@param typClass:实体
     * @参数说明：@param childType：实体类型
     * @参数说明：@return
     * @返回类型：Map<String,Object>
     */
    @SuppressWarnings({
            "unchecked", "rawtypes"
    })
    public static <T> Map<String, Object> ConvertEntityToMap(T typClass, T... childType)
    {
        Map<String, Object> map = new IdentityHashMap<String, Object>();
        try
        {

            BeanInfo beanInfo = Introspector.getBeanInfo(typClass.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors)
            {
                String name = propertyDescriptor.getName();
                if (name.endsWith("Entity") || name.endsWith("class") || name.endsWith("hibernateLazyInitializer"))
                {
                    continue;
                }

                Method method = propertyDescriptor.getReadMethod();
                if (method == null)
                {
                    continue;
                }
                Object value = method.invoke(typClass);
                if (propertyDescriptor.getPropertyType().equals(Set.class) || propertyDescriptor.getPropertyType().equals(List.class))
                {

                    String nameTemp = name.replace("Entities", "Entity");

                    if (nameTemp.equalsIgnoreCase("TTzliuchengEntityForTzlcTzsbid"))
                    {

                        System.out.println("111");

                    }
                    T entityType = null;
                    for (T entityTypeTemp : childType)
                    {
                        String[] className = entityTypeTemp.getClass().getName().split("[.]");
                        String classNameTemp = className[className.length - 1];
                        if (nameTemp.equals(classNameTemp))
                        {
                            entityType = entityTypeTemp;
                            break;
                        }
                    }
                    if (entityType == null)
                    {
                        continue;
                    }
                    Set setValue = (Set) value;
                    List<Object> childList = new ArrayList<Object>();
                    for (Object object : setValue)
                    {
                        T newEntity = (T) object;
                        Map<String, Object> childMap = ConvertEntityToMap(newEntity, childType);
                        childList.add(childMap);

                    }
                    map.put(new String(name), childList);
                }
                else
                {
                    map.put(new String(name), value);
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return map;

        // return typClass;

    }

    /**
     * @功能简介：将单个实体转换为Map
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午6:47:09
     * @param entityObject
     *            :目标实体对象
     * @param isValueAddNull
     *            :是否将null值放进Map
     * @return：
     */
    @SuppressWarnings({
            "unchecked", "rawtypes"
    })
    public static <T> Map<String, T> ConvertEntityToMap(Object entityObject, boolean isValueAddNull)
    {
        // 转换后的Map
        Map<String, T> map = new HashMap<String, T>();
        try
        {
            Class clas = entityObject.getClass();
            Field[] fields = entityObject.getClass().getDeclaredFields();
            for (Field field : fields)
            {
                String key = field.getName();
                // 获取field的属性字段
                PropertyDescriptor pd = new PropertyDescriptor(key, clas);
                // field属性所对应的的属性方法
                Method method = pd.getReadMethod();
                // entityObject对象的field属性value值
                T value = (T) method.invoke(entityObject);
                // 是否将null值装载进Map
                if (!isValueAddNull)
                {
                    // getColumnName(method)!=null
                    if (value != null)
                    {
                        map.put(field.getName(), value);
                    }
                }
                else
                {
                    map.put(field.getName(), value);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * @功能简介：将listEntity转换成listMap
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午6:48:27
     * @param listEntityObject
     * @param isValueAddNull
     * @return：
     */
    public static <T> List<Map<String, T>> listEntityToMap(List<Object> listEntityObject, boolean isValueAddNull)
    {

        List<Map<String, T>> listMap = new ArrayList<Map<String, T>>();
        for (int i = 0; i < listEntityObject.size(); i++)
        {
            // 将实体转换成Map
            Map<String, T> map = ConvertEntityToMap(listEntityObject.get(i), isValueAddNull);
            // 将转换后的Map 装载进List
            listMap.add(map);
        }
        return listMap;

    }
    /**
     * @功能简介：字符串格式转换成数据库查询格式的字符串格式，将str1,2,3,4格式的字符串转换为result'1','2','3','4'格式
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午4:30:36
     * @参数说明：@param str
     * @参数说明：@return
     * @返回类型：String
     */
    public static String formatSqlInString(String str)
    {
        String result = "";// 已选研究方向代码
        if (str.trim().length() != 0)
        {
            result = "'" + str.replaceAll(",", "','") + "'";
        }
        else
        {
            result = "''";
        }
        return result;
    }

    /**
     * 
     * @功能描述:Jsp页面参数实体复制到新实体中
     * @创建人:焦元超
     * @创建时间:2013-8-4 上午10:46:20
     * @param <T>
     *            实本类
     * @param pageEntity
     *            jsp页面实体 非空对像
     * @param newEntity
     *            需要赋值的实体 非空对像
     * @param prefix
     *            从map中取值的key为 prefix + attr 如"entity."+"name"、"entitys[i]."+"name"、"entityMap[key]."+"name"
     * @return
     * @throws Exception
     */
    /**
     * @功能简介：
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午5:02:59
     * @param sourceEntity
     * @param destEntity
     * @param prefix
     *            :从map中取值的key为 prefix + attr 如"entity."+"name"、"entitys[i]."+"name"、"entityMap[key]."+"name"
     * @param parameterMap
     * @return
     * @throws Exception
     *             ：
     */
    public static <T> T mergeEntity(T sourceEntity, T destEntity, String prefix, Map<String, String[]> parameterMap) throws Exception
    {
        try
        {
            // 获取属性
            BeanInfo sourceBean = Introspector.getBeanInfo(sourceEntity.getClass(), java.lang.Object.class);
            PropertyDescriptor[] sourceProperty = sourceBean.getPropertyDescriptors();

            BeanInfo destBean = Introspector.getBeanInfo(destEntity.getClass(), java.lang.Object.class);
            PropertyDescriptor[] destProperty = destBean.getPropertyDescriptors();

            for (PropertyDescriptor destpropertyDescriptor : destProperty)
            {
                String name = destpropertyDescriptor.getName();
                if (!parameterMap.keySet().contains(prefix + name))
                {
                    continue;
                }
                for (PropertyDescriptor sourcepropertyDescriptor : sourceProperty)
                {
                    if (sourcepropertyDescriptor.getName().equals(destpropertyDescriptor.getName()))
                    {
                        destpropertyDescriptor.getWriteMethod().invoke(destEntity,
                                sourcepropertyDescriptor.getReadMethod().invoke(sourceEntity));
                    }
                }

            }

        }
        catch (Exception e)
        {
            throw new Exception("属性复制失败:" + e.getMessage());
        }
        return destEntity;

    }

    /**
     * @功能简介：转换日期为中文格式的字符串
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午4:50:10
     * @param dateStr
     *            （String格式，结构为yyyy-MM-dd）
     * @return：String 小写汉字的日期 方法描述：土办法解决日期转换问题
     */
    public static String convertDateToChinese(String dateStr)
    {

        String resultStr = "";

        for (int j = 0; j < dateStr.length(); j++)
        {
            switch (dateStr.charAt(j))
            {
                case '0' :
                    resultStr += "〇";
                    break;
                case '1' :
                    resultStr += "一";
                    break;
                case '2' :
                    resultStr += "二";
                    break;
                case '3' :
                    resultStr += "三";
                    break;
                case '4' :
                    resultStr += "四";
                    break;
                case '5' :
                    resultStr += "五";
                    break;
                case '6' :
                    resultStr += "六";
                    break;
                case '7' :
                    resultStr += "七";
                    break;
                case '8' :
                    resultStr += "八";
                    break;
                case '9' :
                    resultStr += "九";
                    break;
            }
        }
        return resultStr;
    }

    /**
     * @功能简介：转换月份大写
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午4:52:34
     * @param dateStr
     *            ：格式：01，02，03，04
     * @return：
     */
    public static String convertMonthToChinese(String dateStr)
    {
        if (dateStr.equals("01"))
        {
            return "一";
        }
        else if (dateStr.equals("02"))
        {
            return "二";
        }
        else if (dateStr.equals("03"))
        {
            return "三";
        }
        else if (dateStr.equals("04"))
        {
            return "四";
        }
        else if (dateStr.equals("05"))
        {
            return "五";
        }
        else if (dateStr.equals("06"))
        {
            return "六";
        }
        else if (dateStr.equals("07"))
        {
            return "七";
        }
        else if (dateStr.equals("08"))
        {
            return "八";
        }
        else if (dateStr.equals("09"))
        {
            return "九";
        }
        else if (dateStr.equals("10"))
        {
            return "十";
        }
        else if (dateStr.equals("11"))
        {
            return "十一";
        }
        else if (dateStr.equals("12"))
        {
            return "十二";
        }
        else
        {
            return "";
        }
    }

    /**
     * @功能简介：转换天大写
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午4:53:51
     * @param day
     * @return：
     */
    public static String convertDayToChinese(String day)
    {
        if (day.equals("01"))
        {
            return "一";
        }
        else if (day.equals("02"))
        {
            return "二";
        }
        else if (day.equals("03"))
        {
            return "三";
        }
        else if (day.equals("04"))
        {
            return "四";
        }
        else if (day.equals("05"))
        {
            return "五";
        }
        else if (day.equals("06"))
        {
            return "六";
        }
        else if (day.equals("07"))
        {
            return "七";
        }
        else if (day.equals("08"))
        {
            return "八";
        }
        else if (day.equals("09"))
        {
            return "九";
        }
        else if (day.equals("10"))
        {
            return "十";
        }
        else if (day.equals("11"))
        {
            return "十一";
        }
        else if (day.equals("12"))
        {
            return "十二";
        }
        else if (day.equals("13"))
        {
            return "十三";
        }
        else if (day.equals("14"))
        {
            return "十四";
        }
        else if (day.equals("15"))
        {
            return "十五";
        }
        else if (day.equals("16"))
        {
            return "十六";
        }
        else if (day.equals("17"))
        {
            return "十七";
        }
        else if (day.equals("18"))
        {
            return "十八";
        }
        else if (day.equals("19"))
        {
            return "十九";
        }
        else if (day.equals("20"))
        {
            return "二十";
        }
        else if (day.equals("21"))
        {
            return "二十一";
        }
        else if (day.equals("22"))
        {
            return "二十二";
        }
        else if (day.equals("23"))
        {
            return "二十三";
        }
        else if (day.equals("24"))
        {
            return "二十四";
        }
        else if (day.equals("25"))
        {
            return "二十五";
        }
        else if (day.equals("26"))
        {
            return "二十六";
        }
        else if (day.equals("27"))
        {
            return "二十七";
        }
        else if (day.equals("28"))
        {
            return "二十八";
        }
        else if (day.equals("29"))
        {
            return "二十九";
        }
        else if (day.equals("30"))
        {
            return "三十";
        }
        else if (day.equals("31"))
        {
            return "三十一";
        }
        else
        {
            return "";
        }
    }

    /**
     * @功能简介：将list转换为ListSet
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午6:28:07
     * @param list
     * @return：
     */
    public static <T> Set<T> listConverToSet(List<T> list)
    {
        Set<T> set = null;
        if (list != null && list.size() > 0)
        {
            set = new HashSet<T>();
            for (T t : list)
            {
                set.add(t);
            }
        }
        return set;
    }

    /**
     * @功能简介：将json格式的字符串转换成目标实体
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午6:38:21
     * @param json
     *            ：json格式的字符串
     * @param classType
     *            ：实体
     * @return：返回转换后目标实体
     */
    public static <T> T convertJsonToEntity(String json, Class<T> classType)
    {
        T entity = null;
        try
        {
            entity = classType.newInstance();
            Gson gson = new Gson();
            entity = gson.fromJson(json, classType);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            // new MyException(e, JsonUtil.class, "json字符串转换为实体异常！");
        }
        return entity;
    }

    /**
     * @功能简介：将实体对象转换成json字符串
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午6:40:36
     * @param obj
     * @return：返回格式化好的json字符串
     */
    public static String convertEntityToJson(Object obj)
    {
        String json = "";
        try
        {

            // Gson gson = new Gson();
            // json = gson.toJson(obj);
            // GsonBuilder gson =new GsonBuilder().serializeNulls();//处理Null
            Gson gson = new GsonBuilder().serializeNulls().create();
            return gson.toJson(obj);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            // new MyException(e, JsonUtil.class, "objcet转换为json字符串异常！");
        }
        return json;
    }

    /**
     * @功能简介：获得JqueryEasyUi Tree 的json数据格式
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午6:42:50
     * @param list
     *            ：每个节点的数据，格式：ID PID TEXT
     * @param rootNode
     *            ：根节点的数据：ID PID TEXT
     * @return：转换好的JqueryEasyUi Tree 的json数据格式字符串
     */
    public static String getTreeJson(Map<String, Object> rootNode, List<Map<String, Object>> list)
    {

        List<Map<String, Object>> treeList = convertListToTreeList(list, rootNode);
        String treeJson = convertEntityToJson(treeList);
        treeJson = treeJson.replaceAll("\"ID\"", "\"id\"");
        treeJson = treeJson.replaceAll("\"TEXT\"", "\"text\"");
        treeJson = treeJson.replaceAll("\"PID\"", "\"pid\"");
        treeJson = treeJson.replaceAll("\"ICONCLS\"", "\"iconCls\"");
        return treeJson;
    }

    /**
     * 
     * @功能描述: 把普通的ListMap转换为TreeList数据对象
     * @创建人: 强当安
     * @创建时间: Jun 13, 2014 3:55:16 PM
     * @param list
     *            tree数据ListMap key键如下：ID PID TEXT
     * @param rootNode
     *            树的根节点 key键如下：ID PID TEXT
     * @return List<Map<String,Object>> 返回类型
     */
    private static List<Map<String, Object>> convertListToTreeList(List<Map<String, Object>> list, Map<String, Object> rootNode)
    {

        List<Map<String, Object>> nowTreeList = new ArrayList<Map<String, Object>>();
        String nowNodeId = DataSwitch.convertObjectToString(rootNode.get("ID"));
        for (Map<String, Object> nodeMap : list)
        {
            String tempNodePid = DataSwitch.convertObjectToString(nodeMap.get("PID"));
            if (tempNodePid.equals(nowNodeId))
            {
                nowTreeList.add(nodeMap);
                convertListToTreeList(list, nodeMap);
            }
        }
        if (nowTreeList.size() > 0)
        {
            rootNode.put("children", nowTreeList);
        }
        else
        {
            return null;
        }
        List<Map<String, Object>> treeList = new ArrayList<Map<String, Object>>();
        treeList.add(rootNode);
        return treeList;
    }

    /**
     * @功能简介：将ajax url中文解码
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月20日 下午2:15:47
     * @param strValue
     *            ：url中需要解码的字符串
     * @return：返回通过UTF-8解码后的字符串
     */
    public String httpUrlDecodeUTF8(String strValue)
    {
        try
        {
            return URLDecoder.decode(strValue, "utf-8");
        }
        catch (Exception ex)
        {
        }
        return "";
    }

    /**
     * 
     * @创建人：杜曼科
     * @创建时间：2014-12-6
     * @功能说明：(A,B,C)获得处理过后的字符串 ('A','B','C')
     * @param str
     * @return
     */
    public static String getFixStr(String str)
    {
        StringBuffer sbString = new StringBuffer();
        String[] strArr = str.split(",");
        for (String string : strArr)
        {
            if (string.trim().length() == 0)
            {
                continue;
            }
            sbString.append("'");
            sbString.append(string);
            sbString.append("',");
        }
        sbString.append("'-1'");
        return sbString.toString();
    }

    /**
     * @功能简介：将list数组转成字符串
     * @应用页面：
     * @作者姓名：弋蓬勃
     * @创建时间：2014年12月06日 下午2:15:47
     * @param list数组
     * @return：返回格式： A,B,C
     */
    public static String listToString(List<String> stringList)
    {
        if (stringList == null)
        {
            return null;
        }
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        for (String s : stringList)
        {
            if (flag)
            {
                result.append(",");
            }
            else
            {
                flag = true;
            }
            result.append(s);
        }
        return result.toString();
    }


    /**
     * @功能简介：把list分割成字符串list
     * @应用页面：
     * @作者姓名：弋蓬勃
     * @创建时间：2014年12月06日 下午2:15:47
     * @param list数组
     *            ,num:拼装后字符串长度
     * @return：返回格式：[A,B,C][D,E,F][G,H,I]
     */
    public static List<String> listToStringList(List<String> stringList, int num)
    {
        List<String> listTem = new ArrayList<String>();
        List<String> listRet = new ArrayList<String>();
        if (stringList == null)
        {
            return null;
        }
        if (stringList.size() <= num)
        {
            listRet.add(listToString(stringList));
            return listRet;
        }
        for (int i = 0; i < stringList.size(); i++)
        {
            String str = (String) stringList.get(i);
            listTem.add(str);
            if (listTem.size() == num)
            {
                listRet.add(listToString(listTem));
                listTem.clear();
            }
            if (i == stringList.size() - 1)
            {
                listRet.add(listToString(listTem));
            }
        }
        return listRet;
    }
    /**
     * @功能简介：将json格式的字符串转换成List对象
     * @创建时间：2015年1月23日 上午11:50:42
     * @作者姓名：强当安
     * @param jsonStr
     * @return：
     */
    public static List<Object> convertJsonStrToList(String jsonStr)
    {
        if (jsonStr == null || "".equals(jsonStr))
        {
            return null;
        }
        else
        {
            JsonParser parser = new JsonParser();
//            JsonArray jsonArray = parser.parse(jsonStr).getAsJsonArray();
            //wf2015-9-2 ADD  .replaceAll("\"\"\"\"", "\"\"")  处理传过来的JSON 问题     XXXX:"""" 
			JsonArray jsonArray = parser.parse(jsonStr.replaceAll("\"\"\"\"", "\"\"")).getAsJsonArray();
            return toList(jsonArray);
        }
    }
    /**
     * @功能简介：将json格式的字符串转换成Map对象
     * @创建时间：2015年1月23日 上午11:50:42
     * @作者姓名：强当安
     * @param jsonStr
     * @return：
     */
    public static Map<String, Object> convertJsonStrToMap(String jsonStr)
    {
        if (jsonStr == null || "".equals(jsonStr))
        {
            return null;
        }
        else
        {
            JsonParser parser = new JsonParser();
            //wf2015-9-2 ADD  .replaceAll("\"\"\"\"", "\"\"")  处理传过来的JSON 问题     XXXX:"""" 
            JsonObject jsonObj = parser.parse(jsonStr.replaceAll("\"\"\"\"", "\"\"")).getAsJsonObject();
            return toMap(jsonObj);
        }
    }
    /**
     * @功能简介：对象转换成Map-List集合
     * @作者姓名：强当安
     * @创建时间：2015年1月22日 下午6:06:47
     * @param json
     * @return：
     */
    private static Map<String, Object> toMap(JsonObject json)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        Set<Entry<String, JsonElement>> entrySet = json.entrySet();
        for (Iterator<Entry<String, JsonElement>> iter = entrySet.iterator(); iter.hasNext();)
        {
            Entry<String, JsonElement> entry = iter.next();
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof JsonArray)
                map.put((String) key, toList((JsonArray) value));
            else if (value instanceof JsonObject)
                map.put((String) key, toMap((JsonObject) value));
            else
                map.put((String) key, value.toString().replaceAll("\"", ""));
        }
        return map;
    }

    /**
     * @功能简介：将JSONArray对象转换成List集合
     * @作者姓名：强当安
     * @创建时间：2015年1月22日 下午6:06:38
     * @param json
     * @return：
     */
    private static List<Object> toList(JsonArray json)
    {
        List<Object> list = new ArrayList<Object>();
        for (int i = 0; i < json.size(); i++)
        {
            Object value = json.get(i);
            if (value instanceof JsonArray)
            {
                list.add(toList((JsonArray) value));
            }
            else if (value instanceof JsonObject)
            {
                list.add(toMap((JsonObject) value));
            }
            else
            {
                list.add(value);
            }
        }
        return list;
    }
    /**
	 * @功能简介：判断字符串对象是否为空
	 * @应用页面：
	 * @作者姓名：刘凯
	 * @创建时间：2014年12月06日 下午2:15:47
	 * @param   
	 * @return： 
	 */
	public static boolean isEmpty(String str){
		 if(str==null || "".equals(str)){
			return true; 
		 }
    	return false;
    }
	
	/**
	 * 获取汉字串拼音首字母，英文字符不变
	 * 
	 * @param chinese
	 *            汉字串
	 * @return 汉语拼音首字母
	 */
	public static String getCn2FirstSpell(String chinese)
	{
		StringBuffer pybf = new StringBuffer();
		char[] arr = chinese.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] > 128)
			{
				try
				{
					String[] _t = PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat);
					if (_t != null)
					{
						pybf.append(_t[0].charAt(0));
					}
				}
				catch (BadHanyuPinyinOutputFormatCombination e)
				{
					e.printStackTrace();
				}
			}
			else
			{
				pybf.append(arr[i]);
			}
		}
		return pybf.toString().replaceAll("\\W", "").trim().toUpperCase();
	}

	/**
	 * @功能简介：将List数据转换成，自定义Map的Key和Value值
	 * @应用页面：
	 * @作者姓名：焦丽娜
	 * @创建时间：2014年11月20日 下午4:10:47
	 * @参数说明：@param sourseList
	 * @参数说明：@param keyName
	 * @参数说明：@param valueName
	 * @参数说明：@return
	 * @返回类型：Map<String,Object>
	 */
	public static Map<String, Object> convertListMapToHashMap(List<Map<String, Object>> sourseList, String keyName, String valueName)
	{
		try
		{
			Map<String, Object> retmap = new HashMap<String, Object>();
			if (null != sourseList && sourseList.size() > 0)
			{
				for (Map<String, Object> mapData : sourseList)
				{
					String keyStr = DataSwitch.convertObjectToString(mapData.get(keyName));
					String keyValue = DataSwitch.convertObjectToString(mapData.get(valueName));
					if (!retmap.containsKey(keyStr))
					{
						retmap.put(keyStr, keyValue);
					}
				}
				return retmap;
			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			return null;
		}
	}
}
