package com.gwzd.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * @文件名称: DateUtil.java
 * @包: com.gwzd.gwzdapi
 * @版本：V1.0
 * @版权所有：北京国网中电自动化技术有限公司
 * 
 * @创建人：高洪涛/强当安
 * @创建时间：2014年10月16日
 * @功能简介：
 * 
 */
public class DateUtil
{

    /**
     * 获取日期 天数差
     * 
     * @param date1
     *            开始日期
     * @param date2
     *            结束日期
     * @return：相差天数
     */
    public static int getRiQiChaDays(Date date1, Date date2)
    {
        int dayInt = 0;
        long date1Time = date1.getTime();
        long date2Time = date2.getTime();
        if (date2Time > date1Time)
        {
            dayInt = (int) ((date2Time - date1Time) / 1000 / 60 / 60 / 24);
        }
        return dayInt;
    }

    /**
     * 计算当前时间加上指定月份的时间
     * 
     * @param month
     * @return
     */
    /**
     * @功能简介：根据当前时间并加上指定月份返回
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午5:52:29
     * @param month
     *            ：月份
     * @return：计算后的日期
     */
    public static Date getNowAddMonth(int month)
    {
        return addMonth(new Date(), month);
    }

    /**
     * @功能简介：在指定的时间上加上月份并返回日期格式
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午5:59:46
     * @param date
     *            ：您指定的时间
     * @param month
     *            ：加上的月份int，可为负数
     * @return：计算后的日期
     */
    public static Date addMonth(Date date, int month)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, month);
        return cal.getTime();
    }
    
    public static Date addDay(Date date, int day)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, day);
        return  cal.getTime();
    }

    /**
     * 获取当前时间字符串(年月日时分秒)
     * 
     * @return
     */
    public static String getCurrentDateStr()
    {
        return getDateFormatStr(new Date(), "yyyy-MM-dd HH:mm:ss");
    }
    /**
     * 获取当前时间字符串(年月日时分秒)
     * 
     * @return
     */
    public static String getCurrentYearStr()
    {
    	 Calendar cal = Calendar.getInstance();
         cal.setTime(new Date());
         int year=cal.get(Calendar.YEAR);
    	return year+"";
    }
    

    /**
     * 获取当前时间字符串(年月日)
     * 
     * @return
     */
    public static String getCurrentDateString()
    {
        return getDateFormatStr(new Date(), "yyyy-MM-dd");
    }

    /**
     * 获取时间对象
     * 
     * @param dateStr
     *            时间字符串 yyyy-MM-dd
     * @return
     * @throws ParseException
     */
    public static Date getDate(String dateStr) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(dateStr);
    }

    /**
     * 获取时间对象
     * 
     * @param dateStr
     *            时间字符串
     * @param formatStr
     *            时间格式字符串 yyyy-MM-dd
     * @return
     * @throws ParseException
     */
    public static Date getDateByFormat(String dateStr, String formatStr) throws ParseException
    {
        if (StringUtils.isBlank(dateStr))
        {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        return sdf.parse(dateStr);
    }

    /**
     * 获取当前时间字符串
     * 
     * @param date
     *            时间对象
     * @param formatStr
     *            时间格式字符串
     * @return
     */
    public static String getDateFormatStr(Date date, String formatStr)
    {
        if (date == null)
        {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        return sdf.format(date);
    }

    /**
     * 获取当前日期的第一天或最后一天
     * 
     * @param islast
     *            true 最后一天 false 第一天 王飞2014-12-25修改
     * @param date
     * @param format
     * @return
     * 
     */
    public static String getFirstOrLastDateByDate(boolean islast, Date date, String format)
    {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date); // someDate 为你要获取的那个月的时间
        // Calendar cal = Calendar.getInstance();
        // cal.setTime(date);
        // cal.set(Calendar.MONTH, 0);
        if (islast)
        {
            // cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) + 1);
            // cal.set(Calendar.DATE, 0);
            ca.set(Calendar.DAY_OF_MONTH, 1);
        }
        else
        {
            // cal.set(Calendar.DATE, 1);
            ca.add(Calendar.MONTH, 1);
            ca.set(Calendar.DAY_OF_MONTH, 1);
            ca.add(Calendar.DAY_OF_MONTH, -1);
        }
        return getDateFormatStr(ca.getTime(), format);
    }

    /**
     * @功能描述:金额格式化
     * @创建人:王宝
     * @param jine
     * @return
     */
    public static String getFormatJine(double jine)
    {
        DecimalFormat df = new DecimalFormat(",###.00");
        return df.format(jine);
    }

    /**
     * 
     * @功能描述:根据周获取，周次
     * @创建人:焦元超
     * @创建时间:2013-9-11 上午11:21:58
     * @param num
     * @return
     */
    public static String getWhichWeek(int num)
    {
        String week = "";
        switch (num)
        {
            case 1 :
                week = "星期日";
                break;
            case 2 :
                week = "星期一";
                break;
            case 3 :
                week = "星期二";
                break;
            case 4 :
                week = "星期三";
                break;
            case 5 :
                week = "星期四";
                break;
            case 6 :
                week = "星期五";
                break;
            case 7 :
                week = "星期六";
                break;
            default :
                week = "";
                break;
        }
        return week;
    }

    /**
     * 获取中文格式的年月日表示方法 二0一三年十一月二十五日
     * 
     * @param date
     * @return
     */
    public static String getChinaDateByDate(Date date)
    {
        SimpleDateFormat mindateformatter = new SimpleDateFormat("yyyy-MM-dd");
        String str = mindateformatter.format(date);

        StringBuffer sb = new StringBuffer();
        int pos1 = str.indexOf("-");
        int pos2 = str.lastIndexOf("-");
        for (int i = 0; i < 4; i++)
        {
            sb.append(formatDateDigit(str.charAt(i)));
        }
        sb.append('年');
        if (getMidLen(str, pos1, pos2) == 1)
        {
            sb.append(formatDateDigit(str.charAt(5)) + "月");
            if (str.charAt(7) != '0')
            {
                if (getLastLen(str, pos2) == 1)
                {
                    sb.append(formatDateDigit(str.charAt(7)) + "日");
                }
                if (getLastLen(str, pos2) == 2)
                {
                    if (str.charAt(7) != '1' && str.charAt(8) != '0')
                    {
                        sb.append(formatDateDigit(str.charAt(7)) + "十" + formatDateDigit(str.charAt(8)) + "日");
                    }
                    else if (str.charAt(7) != '1' && str.charAt(8) == '0')
                    {
                        sb.append(formatDateDigit(str.charAt(7)) + "十日");
                    }
                    else if (str.charAt(7) == '1' && str.charAt(8) != '0')
                    {
                        sb.append("十" + formatDateDigit(str.charAt(8)) + "日");
                    }
                    else
                    {
                        sb.append("十日");
                    }
                }
            }
            else
            {
                sb.append(formatDateDigit(str.charAt(8)) + "日");
            }
        }
        if (getMidLen(str, pos1, pos2) == 2)
        {
            if (str.charAt(5) != '0' && str.charAt(6) != '0')
            {
                sb.append("十" + formatDateDigit(str.charAt(6)) + "月");
                if (getLastLen(str, pos2) == 1)
                {
                    sb.append(formatDateDigit(str.charAt(8)) + "日");
                }
                if (getLastLen(str, pos2) == 2)
                {
                    if (str.charAt(8) != '0')
                    {
                        if (str.charAt(8) != '1' && str.charAt(9) != '0')
                        {
                            sb.append(formatDateDigit(str.charAt(8)) + "十" + formatDateDigit(str.charAt(9)) + "日");
                        }
                        else if (str.charAt(8) != '1' && str.charAt(9) == '0')
                        {
                            sb.append(formatDateDigit(str.charAt(8)) + "十日");
                        }
                        else if (str.charAt(8) == '1' && str.charAt(9) != '0')
                        {
                            sb.append("十" + formatDateDigit(str.charAt(9)) + "日");
                        }
                        else
                        {
                            sb.append("十日");
                        }
                    }
                    else
                    {
                        sb.append(formatDateDigit(str.charAt(9)) + "日");
                    }
                }
            }
            else if (str.charAt(5) != '0' && str.charAt(6) == '0')
            {
                sb.append("十月");
                if (getLastLen(str, pos2) == 1)
                {
                    sb.append(formatDateDigit(str.charAt(8)) + "日");
                }
                if (getLastLen(str, pos2) == 2)
                {
                    if (str.charAt(8) != '0')
                    {
                        if (str.charAt(8) != '1' && str.charAt(9) != '0')
                        {
                            sb.append(formatDateDigit(str.charAt(8)) + "十" + formatDateDigit(str.charAt(9)) + "日");
                        }
                        else if (str.charAt(8) != '1' && str.charAt(9) == '0')
                        {
                            sb.append(formatDateDigit(str.charAt(8)) + "十日");
                        }
                        else if (str.charAt(8) == '1' && str.charAt(9) != '0')
                        {
                            sb.append("十" + formatDateDigit(str.charAt(9)) + "日");
                        }
                        else
                        {
                            sb.append("十日");
                        }
                    }
                    else
                    {
                        sb.append(formatDateDigit(str.charAt(9)) + "日");
                    }
                }
            }
            else
            {
                sb.append(formatDateDigit(str.charAt(6)) + "月");
                if (getLastLen(str, pos2) == 1)
                {
                    sb.append(formatDateDigit(str.charAt(8)) + "日");
                }
                if (getLastLen(str, pos2) == 2)
                {
                    if (str.charAt(8) != '0')
                    {
                        if (str.charAt(8) != '1' && str.charAt(9) != '0')
                        {
                            sb.append(formatDateDigit(str.charAt(8)) + "十" + formatDateDigit(str.charAt(9)) + "日");
                        }
                        else if (str.charAt(8) != '1' && str.charAt(9) == '0')
                        {
                            sb.append(formatDateDigit(str.charAt(8)) + "十日");
                        }
                        else if (str.charAt(8) == '1' && str.charAt(9) != '0')
                        {
                            sb.append("十" + formatDateDigit(str.charAt(9)) + "日");
                        }
                        else
                        {
                            sb.append("十日");
                        }
                    }
                    else
                    {
                        sb.append(formatDateDigit(str.charAt(9)) + "日");
                    }
                }
            }
        }
        return sb.toString();

    }

    /**
     * create date:2010-5-22下午03:31:51 描述： 获得月份字符串的长度
     * 
     * @param str
     *            待转换的源字符串
     * @param pos1
     *            第一个'-'的位置
     * @param pos2
     *            第二个'-'的位置
     * @return
     */
    public static int getMidLen(String str, int pos1, int pos2)
    {
        return str.substring(pos1 + 1, pos2).length();
    }

    /**
     * create date:2010-5-22下午03:32:17 描述：获得日期字符串的长度
     * 
     * @param str
     *            待转换的源字符串
     * @param pos2
     *            第二个'-'的位置
     * @return
     */
    public static int getLastLen(String str, int pos2)
    {
        return str.substring(pos2 + 1).length();
    }

    /**
     * 
     * @功能描述:
     * @创建人:焦元超
     * @创建时间:2013-12-30 下午04:14:37
     * @param sign
     * @return
     */
    private static char formatDateDigit(char sign)
    {
        if (sign == '0')
            sign = '0';
        if (sign == '1')
            sign = '一';
        if (sign == '2')
            sign = '二';
        if (sign == '3')
            sign = '三';
        if (sign == '4')
            sign = '四';
        if (sign == '5')
            sign = '五';
        if (sign == '6')
            sign = '六';
        if (sign == '7')
            sign = '七';
        if (sign == '8')
            sign = '八';
        if (sign == '9')
            sign = '九';
        return sign;
    }

    /**
     * @功能描述：通过日期字符串获得Timestamp
     * @创建人：刘凯
     * @创建时间：2014-6-17 上午11:53:11
     * @返回类型：int
     * @param str
     * @param pos2
     * @return
     * @throws ParseException
     */
    public static Timestamp getTimestampByHalfDateStr(String DateStr) throws ParseException
    {
        Date date = DateUtil.getDateByFormat(DateStr, "yyyy-MM-dd");
        @SuppressWarnings("deprecation")
        Timestamp jzwjcriqiStamp = new Timestamp(date.getYear(), date.getMonth(), date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds(), 0);
        return jzwjcriqiStamp;
    }

    /**
     * @功能描述：通过日期字符串获得Timestamp
     * @创建人：刘凯
     * @创建时间：2014-6-17 上午11:53:11
     * @返回类型：int
     * @param str
     * @param pos2
     * @return
     * @throws ParseException
     */
    public static Timestamp getTimestampByFullDateStr(String DateStr) throws ParseException
    {
        Date date = DateUtil.getDateByFormat(DateStr, "yyyy-MM-dd HH:mm:ss");
        @SuppressWarnings("deprecation")
        Timestamp jzwjcriqiStamp = new Timestamp(date.getYear(), date.getMonth(), date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds(), 0);
        return jzwjcriqiStamp;
    }

    /**
     * @方法描述: 获取当前时间 带时分秒
     * @return java.sql.Date
     * @返回: Date
     * @作者: 汪旭
     * @创建时间: 2014-8-18 下午07:43:18
     */
    public static Date getSqlDate()
    {
        return new Date(System.currentTimeMillis());
    }

    /**
     * 
     * @功能简介：把yyyy/MM/dd yyyy-MM-dd yyyyMMdd 格式字符串日期转换为yyyy-MM-dd格式日期
     * @应用页面：
     * @作者姓名：弋蓬勃
     * @创建时间：2014年12月20日 下午7:52:00
     * @参数说明：@param checkValue
     * @参数说明：@return
     * @返回类型：Date
     * 
     */
    public static Date getDateByFormat(String dataValue)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        String tmp = "";
        if (StringUtils.isNotBlank(dataValue))
        {
            if (dataValue.split("/").length > 1)
            {
                dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            }
            if (dataValue.split("-").length > 1)
            {
                dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            }
        }
        else
        {
            return null;
        }
        try
        {
            date = dateFormat.parse(dataValue);
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            tmp = dateFormat.format(date);
            date = dateFormat.parse(tmp);
        }
        catch (Exception e)
        {
            return null;
        }
        return date;
    }

    /**
     * 
     * @功能简介：检验一个字符串是否是规定的时间格式（yyyy/MM/dd yyyy-MM-dd yyyyMMdd）
     * @应用页面：
     * @作者姓名：弋蓬勃
     * @创建时间：2014年12月20日 下午7:58:26
     * @参数说明：@param checkValue
     * @参数说明：@return
     * @返回类型：boolean
     * 
     */
    public static boolean isDate(String checkValue)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date d = null;
        String ret = "";
        if (StringUtils.isNotBlank(checkValue))
        {
            if (checkValue.split("/").length > 1)
            {
                dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            }
            if (checkValue.split("-").length > 1)
            {
                dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            }
        }
        else
        {
            return false;
        }
        try
        {
            d = dateFormat.parse(checkValue);
        }
        catch (Exception e)
        {
            return false;
        }
        ret = dateFormat.format(d);

        return ret.equals(checkValue);
    }

    /**
     * @功能简介：获取两个时间的时间差  秒~
     * @应用页面：
     * @作者姓名：王飞
     * @创建时间：2014年12月27日 下午4:54:48
     * @参数说明：@param startdate开始时间
     * @参数说明：@param enddate结束时间
     * @参数说明：@return  时间差秒值
     * @返回类型：int
     *
     */
    public static int getSeconds(Date startdate, Date enddate)
    {
        long time = enddate.getTime() - startdate.getTime();
        int totalS = new Long(time / 1000).intValue();
        return totalS;
    }
    
    
    /**
     * @功能简介：根据节次下标获取节次字符串（第几周 周几  第几节）
     * @应用页面：
     * @作者姓名：王飞
     * @创建时间：2015年5月22日 下午4:55:43
     * @参数说明：@param jieCiIndex  节次下标
     * @参数说明：@return
     * @返回类型：String
     *
     */
    public static String getShangKeJieCiStr(int jieCiIndex)
    {
    	int zc;
		int zj;
		int jc;
		//计算第几周
		if(jieCiIndex>=91)
		{
			zc=jieCiIndex/91+1;
		}
		else
		{
			zc=1;
		}
		//计算周几
		if(jieCiIndex-((zc-1)*7*13)>=13)
		{
			zj=(jieCiIndex-((zc-1)*7*13))/13+1;
		}
		else
		{
			zj=1;
		}
		//计算节次
		jc=jieCiIndex-((zc-1)*7*13)-((zj-1)*13)+1;
		String jieCiStr="第"+zc+"周 周"+zj+" 第"+jc+"节";
        return jieCiStr;
    }
}
