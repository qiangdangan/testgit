package com.gwzd.util;

import java.util.List;
import java.util.Map;

/**
 * @文件名称: BeanUtil.java
 * @包: com.gwzd.gwzdapi
 * @版本：V1.0
 * @版权所有：北京国网中电自动化技术有限公司
 * 
 * @创建人：焦元超
 * @创建时间：2014年10月16日
 * @功能简介：饼图，线图服务类
 * 
 */
public class HighChartUtil {
	/***
	 * @功能描述:生成绘图用json数据
	 * @创建人:jyc
	 * @创建时间:2014-7-9 上午10:19:50
	 * @param list
	 *            数据集合
	 * @param key
	 *            对应键列名字
	 * @param value
	 *            对应统计值
	 * @return 绘图用json数据
	 */
	public static String getHighchartsJson(List<Map<String, Object>> list,
			String key, String value) {

		String highchartsJson = "[";
		for (Map<String, Object> rysymjMap : list) {
			highchartsJson += "['" + rysymjMap.get(key) + "',"
					+ rysymjMap.get(value) + "],";
		}

		highchartsJson = highchartsJson + "]";
		return highchartsJson;
	}

	/**
	 * @功能简介：生成绘图用json数据
	 * @应用页面：
	 * @作者姓名：王飞
	 * @创建时间：2015年3月2日 下午4:24:55
	 * @参数说明：@param datalist 数据LIST
	 * @参数说明：@param paramList 数据获取参数LIST
	 * @参数说明：@return
	 * @返回类型：String
	 * 
	 */
	public static String getHighchartsJson(List<Map<String, Object>> datalist,
			List<Map<String, String>> paramList) {

		String dwsymjJson = "[";
		for (Map<String, String> map : paramList) {
			dwsymjJson += "{";
			dwsymjJson += "'name':'" + map.get("name") + "',";
			dwsymjJson += "'data':";
			dwsymjJson += "[";
			for (Map<String, Object> tongJiShuLiangMap : datalist) {
				// if(!tongJiShuLiangMap.get(map.get("dataValue")).toString().equals("0"))
				// {
				dwsymjJson += "['" + tongJiShuLiangMap.get(map.get("dataName"))
						+ "'," + tongJiShuLiangMap.get(map.get("dataValue"))
						+ "],";
				// }
			}
			dwsymjJson = dwsymjJson.substring(0, dwsymjJson.length() - 1);
			dwsymjJson += "]";
			/*
			 * dwsymjJson += "],"; dwsymjJson += "'dataId':"; dwsymjJson += "[";
			 * for (Map<String, Object> tongJiShuLiangMap : datalist) { if
			 * (!tongJiShuLiangMap.get(map.get("dataValue")).toString()
			 * .equals("0")) { dwsymjJson += "['"+
			 * tongJiShuLiangMap.get(map.get("dataId")) + "'],"; } } dwsymjJson
			 * = dwsymjJson.substring(0, dwsymjJson.length() - 1); dwsymjJson +=
			 * "]";
			 */
			dwsymjJson += "},";
		}
		dwsymjJson = dwsymjJson.substring(0, dwsymjJson.length() - 1);
		dwsymjJson += "]";
		return dwsymjJson;
	}

	/**
	 * @功能简介：生成绘图用json数据
	 * @应用页面：
	 * @作者姓名：王飞
	 * @创建时间：2015年3月2日 下午4:24:55
	 * @参数说明：@param datalist 数据LIST
	 * @参数说明：@param paramList 数据获取参数LIST
	 * @参数说明：@return
	 * @返回类型：String
	 * 
	 */
	public static String getHighchartsDmJson(
			List<Map<String, Object>> datalist,
			List<Map<String, String>> paramList) {

		String dwsymjJson = "[";
		for (Map<String, String> map : paramList) {
			dwsymjJson += "{";
			dwsymjJson += "'name':'" + map.get("name") + "',";
			dwsymjJson += "'data':";
			dwsymjJson += "[";
			for (Map<String, Object> tongJiShuLiangMap : datalist) {
				// if(!tongJiShuLiangMap.get(map.get("dataValue")).toString().equals("0"))
				// {
				dwsymjJson += "{'name':'"
						+ tongJiShuLiangMap.get(map.get("dataName")) + "'";
				dwsymjJson += ",'y':"
						+ tongJiShuLiangMap.get(map.get("dataValue")) + "";
				dwsymjJson += ",'id':'"
						+ tongJiShuLiangMap.get(map.get("dataId")) + "'";
				dwsymjJson += "},";
				// }
			}
			dwsymjJson = dwsymjJson.substring(0, dwsymjJson.length() - 1);
			dwsymjJson += "]";
			dwsymjJson += "},";
		}
		dwsymjJson = dwsymjJson.substring(0, dwsymjJson.length() - 1);
		dwsymjJson += "]";
		return dwsymjJson;
	}
}
