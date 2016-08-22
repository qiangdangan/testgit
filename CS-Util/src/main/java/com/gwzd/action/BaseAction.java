package com.gwzd.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.gwzd.model.po.LoginUserInfoEntity;
import com.gwzd.util.DataSwitch;
import com.opensymphony.xwork2.ActionSupport;

@ExceptionMappings({ @ExceptionMapping(result = "ERROR", exception = "java.lang.Exception") })
@Results({ @Result(name = "ERROR", location = "/error.jsp"), @Result(name = "InitExportPage", location = "/pages/util/daochu_dialog.jsp"), })
public class BaseAction extends ActionSupport
{

	private String moKuaiId; // 模块id
	private String jieDianId; // 节点Id
	private String jieDianUrl; // 节点url

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 获取HttpServletResponse对象
	 * 
	 * @return
	 */
	public HttpServletResponse getResponse()
	{
		return ServletActionContext.getResponse();
	}

	/**
	 * 获取HttpServletRequest对象
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest()
	{
		return ServletActionContext.getRequest();
	}

	/**
	 * 为HttpServletRequest设置属性
	 * 
	 * @param attrName
	 * @param attrValue
	 */
	public void setReuestAttr(String attrName, Object attrValue)
	{
		this.getRequest().setAttribute(attrName, attrValue);
	}

	/**
	 * 
	 * @功能简介：获取服务器路径
	 * @应用页面：
	 * @作者姓名：焦元超
	 * @创建时间：2014年12月27日 上午9:58:00
	 * @参数说明：@return
	 * @返回类型：String
	 * 
	 */
	@SuppressWarnings("deprecation")
	public String getAppRealPath()
	{
		return ServletActionContext.getRequest().getRealPath("/");
	}

	/**
	 * @功能简介：获取系统下新的临时目录
	 * @作者姓名：焦丽娜
	 * @创建时间：2015年3月9日 下午2:58:06
	 * @参数说明：@param pathName 相对程序目录的名，为空时，只返回 程序文件夹+tep
	 * @参数说明：@return 相对程序目录的名，为空时，只返回 程序文件夹+tmp 否则 相对程序目录的名，为空时，只返回 程序文件夹+tmp+相对程序目录的名
	 * @返回类型：String
	 * 
	 */
	public String getTmpPath(String pathName)
	{
		String realPath = this.getAppRealPath();
		String newTmpPath = realPath + "tmp" + File.separator;
		if (pathName != null && !"".equals(pathName))
		{
			newTmpPath = realPath + "tmp" + File.separator + pathName + File.separator;
		}
		File targetFileMl = new File(newTmpPath);
		if (!targetFileMl.exists())
		{
			targetFileMl.mkdirs();
		}
		return newTmpPath;
	}

	/**
	 * @功能简介：获得页面级Session
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月20日 下午2:04:13
	 * @return：
	 */
	public HttpSession getSession()
	{
		return ServletActionContext.getRequest().getSession();
	}

	/**
	 * @功能简介：获得登录用户的实体
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月20日 下午2:04:33
	 * @return：
	 */
	public LoginUserInfoEntity getLoginUserInfoEntity()
	{
		LoginUserInfoEntity loginUser = (LoginUserInfoEntity) getSession().getAttribute("loginUserInfo");
		return loginUser;
	}

	/**
	 * @功能简介：获取登录用户ID
	 * @应用页面：
	 * @作者姓名：强当安
	 * @创建时间：2015年11月13日 上午11:26:58
	 * @return：
	 */
	public String getLoginUserId()
	{
		return this.getLoginUserInfoEntity().getRy_id();
	}

	/**
	 * @功能简介：获取登录用户的当前角色Id
	 * @应用页面：
	 * @作者姓名：强当安
	 * @创建时间：2015年11月9日 下午3:30:11
	 * @参数说明：@return
	 * @返回类型：String
	 * 
	 */
	public String getNowJueSeId()
	{
		return this.getLoginUserInfoEntity().getNowJueSeId();
	}

	/**
	 * @功能简介：将页面参数自动转换成实体，要求页面参数命名 = 实体.fileName
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月20日 下午2:11:33
	 * @param typClass
	 *            ：实体的getClass()
	 * @return
	 * @throws Exception
	 *             ：
	 */
	@SuppressWarnings("unchecked")
	public <T> T convertRequestToEntity(Class<T> typClass) throws Exception
	{
		try
		{
			T t = typClass.newInstance();
			@SuppressWarnings("rawtypes")
			Map map = this.getRequest().getParameterMap();
			return (T) DataSwitch.ConvertDataTableToEntity(t, map);
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	/**
	 * @功能简介：获取页面某个参数的值
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月20日 下午2:13:09
	 * @param paraName
	 *            ：参数名称
	 * @return：
	 */
	public String getParameter(String paraName)
	{
		return DataSwitch.convertObjectToString(this.getRequest().getParameter(paraName));
	}

	/**
	 * @功能简介：获得Get方式参数根据UTF-8解码后的字符串
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月20日 下午2:39:57
	 * @param paraName
	 * @return
	 * @throws UnsupportedEncodingException
	 *             ：
	 */
	private String httpGetUrlDecodeUTF8(String paraName) throws UnsupportedEncodingException
	{
		String newStr = getParameter(paraName);
		try
		{
			String liuLanQiLeiXing = getRequest().getHeader("User-Agent");
			if (liuLanQiLeiXing.indexOf("MSIE") > -1)
			{
				// IE
				newStr = new String(newStr.getBytes("ISO8859-1"), "GBK");
			}
			else
			{
				newStr = new String(newStr.getBytes("ISO8859-1"), "UTF-8");
			}
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}

		return newStr;
	}

	/**
	 * @功能简介：浏览页导出方法时，初始化导出页面中所有要导出字段列表的方法， 注意：在调用时需要页面有参数columnNames和fileName的定义，联合导出共用js使用
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月20日 下午2:43:26：
	 */
	public void initBaseExportPage()
	{
		try
		{
			String[] fields = getParameter("fields").split(",");
			String columnNameStr = this.httpGetUrlDecodeUTF8("columnNames");
			String[] columnNames = columnNameStr.split(",");
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < fields.length; i++)
			{
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("field", fields[i]);
				map.put("columnName", columnNames[i]);
				list.add(map);
			}
			setReuestAttr("list", list);
			String fileName = httpGetUrlDecodeUTF8("fileName");
			setReuestAttr("fileName", fileName);
			setReuestAttr("actionUrl", getParameter("actionUrl"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @功能简介：获取导出Excel时，用户指定导出哪几列的列名称
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月20日 下午2:46:35
	 * @return：
	 */
	public List<Map<String, Object>> getExportFieldList()
	{
		String[] fields = getParameter("fields").split(",");
		String[] columnNames = getParameter("columnNames").split(",");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < fields.length; i++)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("field", fields[i]);
			map.put("columnName", columnNames[i]);
			list.add(map);
		}
		return list;
	}

	/**
	 * @功能简介：获得页面request参数，并返回map格式的数据
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月20日 下午2:54:56
	 * @return：
	 */
	public Map<String, Object> getParameterMap()
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, String[]> parasMap = getRequest().getParameterMap();
		for (Entry<String, String[]> kv : parasMap.entrySet())
		{
			String[] strs = (String[]) kv.getValue();
			map.put(kv.getKey(), strs[0]);
		}
		return map;
	}

	/**
	 * @功能简介：获得页面request参数，同一个name的时候获取数组
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月20日 下午2:56:24
	 * @param paraName
	 * @return：
	 */
	public String[] getParameterValues(String paraName)
	{
		return getRequest().getParameterValues(paraName);
	}

	/**
	 * @功能简介：设置session
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月20日 下午4:32:31
	 * @param attrName
	 * @param attrValue
	 *            ：
	 */
	public void setSessionAttr(String attrName, Object attrValue)
	{
		getSession().setAttribute(attrName, attrValue);
	}

	/**
	 * @功能简介：获取用户IP地址
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月19日 下午3:30:18
	 * @参数说明：@return
	 * @返回类型：String
	 * 
	 */
	public String getIpAddress()
	{
		HttpServletRequest request = this.getRequest();
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public String getMoKuaiId()
	{
		if (DataSwitch.isEmpty(moKuaiId))
		{
			setMoKuanIdAndJieDianId();
		}
		String mianBaoXieHtml = this.getParameter("mianBaoXieHtml"); // 面包屑html代码
		if (DataSwitch.isEmpty(mianBaoXieHtml))
		{

			initMianBaoXie();
		}
		return moKuaiId;
	}

	public void setMoKuaiId(String moKuaiId)
	{
		this.moKuaiId = moKuaiId;
	}

	public String getJieDianId()
	{
		return jieDianId;
	}

	public void setJieDianId(String jieDianId)
	{
		this.jieDianId = jieDianId;
	}

	/**
	 * @功能简介：设置模块id和节点id
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月20日 下午3:31:12
	 * @参数说明：
	 * @返回类型：void
	 * 
	 */
	private void setMoKuanIdAndJieDianId()
	{
		// 用户菜单组
		List<Map<String, Object>> userCaiDanZu = (List<Map<String, Object>>) getSession().getAttribute("userCaiDanZu");
		// 用户菜单
		List<Map<String, Object>> userCaiDan = (List<Map<String, Object>>) getSession().getAttribute("userCaiDan");
		String caiDanZuId = ""; // 菜单组ID
		for (Map<String, Object> map : userCaiDan)
		{
			String tmpUrl = DataSwitch.convertObjectToString(map.get("URL"));
			if (tmpUrl.equals(this.jieDianUrl))
			{
				this.jieDianId = DataSwitch.convertObjectToString(map.get("CDID"));
				caiDanZuId = DataSwitch.convertObjectToString(map.get("PID"));
				break;
			}
		}
		for (Map<String, Object> map : userCaiDanZu)
		{
			String tmpCdzId = DataSwitch.convertObjectToString(map.get("CDID"));
			if (tmpCdzId.equals(caiDanZuId))
			{
				this.moKuaiId = DataSwitch.convertObjectToString(map.get("PID"));
				break;
			}
		}
	}

	/**
	 * @功能简介：初始化面包屑
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月19日 下午11:30:05
	 * @参数说明：
	 * @返回类型：void
	 * 
	 */
	private void initMianBaoXie()
	{
		String moKuaiId = this.moKuaiId;
		if (DataSwitch.isEmpty(moKuaiId))
		{
			moKuaiId = this.getParameter("moKuaiId");
		}
		String jieDianId = this.jieDianId;
		if (DataSwitch.isEmpty(moKuaiId))
		{
			jieDianId = this.getParameter("jieDianId");
		}
		// 用户模块
		List<Map<String, Object>> userMoKuai = (List<Map<String, Object>>) getSession().getAttribute("userMoKuai");
		// 用户菜单组
		List<Map<String, Object>> userCaiDanZu = (List<Map<String, Object>>) getSession().getAttribute("userCaiDanZu");
		// 用户菜单
		List<Map<String, Object>> userCaiDan = (List<Map<String, Object>>) getSession().getAttribute("userCaiDan");
		String muKuaiMingCheng = ""; // 模块名称
		for (Map<String, Object> map : userMoKuai)
		{
			String tmpMkId = DataSwitch.convertObjectToString(map.get("CDID"));
			if (tmpMkId.equals(moKuaiId))
			{
				muKuaiMingCheng = DataSwitch.convertObjectToString(map.get("CaiDanMingCheng"));
				break;
			}
		}
		String caiDanMingCheng = ""; // 菜单名称
		String caiDanZuId = ""; // 菜单组Id
		for (Map<String, Object> map : userCaiDan)
		{
			String tmpCdId = DataSwitch.convertObjectToString(map.get("CDID"));
			if (tmpCdId.equals(jieDianId))
			{
				caiDanMingCheng = DataSwitch.convertObjectToString(map.get("CaiDanMingCheng"));
				caiDanZuId = DataSwitch.convertObjectToString(map.get("PID"));
				break;
			}
		}
		String caiDanZuMingCheng = ""; // 菜单组名称
		for (Map<String, Object> map : userCaiDanZu)
		{
			String tmpCdzId = DataSwitch.convertObjectToString(map.get("CDID"));
			if (tmpCdzId.equals(caiDanZuId))
			{
				caiDanZuMingCheng = DataSwitch.convertObjectToString(map.get("CaiDanMingCheng"));
				break;
			}
		}
		// 面包屑html代码
		StringBuffer mianBaoXieHtml = new StringBuffer();
		mianBaoXieHtml.append("<li><a href=\"#\">" + muKuaiMingCheng + "</a></li>");
		mianBaoXieHtml.append("<li><a href=\"#\">" + caiDanZuMingCheng + "</a></li>");
		mianBaoXieHtml.append("<li class=\"active\">" + caiDanMingCheng + "</li>");
		setReuestAttr("mianBaoXieHtml", mianBaoXieHtml);
	}

	public void setJieDianUrl(String jieDianUrl)
	{
		this.jieDianUrl = jieDianUrl;
	}
}
