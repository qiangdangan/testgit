package com.gwzd.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.gwzd.model.dbentity.TbDengLuRiZhi;
import com.gwzd.model.enumeration.publicenum.ReturnFlagEnum;
import com.gwzd.model.po.LoginUserInfoEntity;
import com.gwzd.service.LoginService;
import com.gwzd.util.DataSwitch;
import com.gwzd.util.PublicMethod;

/**
 * @文件名称: LoginAction.java
 * @包: com.gwzd.action
 * @版本：V1.0
 * @版权所有：北京国网中电自动化技术有限公司
 * 
 * @创建人：强子
 * @创建时间：2016年8月18日
 * @功能简介：用户登录
 * 
 */
@Controller
@Scope("prototype")
@Namespace("/")
@ParentPackage(value = "default-package")
@Results({ @Result(name = "initLoginPage", location = "/main/login.jsp")
, @Result(name = "initLoginUserInfo", location = "/main/loginUserInfo.jsp") 
, @Result(name = "initDefaultJdPage", location = "/main/defaultJdPage.jsp") 
, @Result(name = "initHeaderPage", location = "/main/header.jsp") 
, @Result(name = "initLeftPage", location = "/main/left.jsp") 
})
public class LoginAction extends BaseAction
{
	private LoginService loginService;

	@Resource
	public void setLoginService(LoginService loginService)
	{
		this.loginService = loginService;
	}

	/**
	 * @功能简介：初始化登录页面
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月18日 下午4:39:54
	 * @参数说明：@return
	 * @返回类型：String
	 * 
	 */
	@Action("userLogin.initLoginPage")
	public String initLoginPage()
	{
		return "initLoginPage";
	}

	/**
	 * @功能简介：
	 * @应用页面：
	 * @throws Exception
	 * @作者姓名：强子
	 * @创建时间：2016年8月18日 下午5:27:28
	 * @参数说明：
	 * @返回类型：void
	 * 
	 */
	@Action("userLogin.ajaxUserNameIsExist")
	public void ajaxUserNameIsExist() throws Exception
	{
		try
		{
			String userName = super.getParameter("validateparam1"); // 用户名
			boolean isExist = this.loginService.searchUserNameIsExist(userName);
			if (isExist)
			{
				PublicMethod.writeToPage(ReturnFlagEnum.trueMessage);
			}
			else
			{
				PublicMethod.writeToPage(ReturnFlagEnum.falseMessage);
			}
		}
		catch (Exception e)
		{
			PublicMethod.writeToPage(ReturnFlagEnum.falseMessage);
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @throws Exception
	 * @功能简介：用户登录
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月18日 下午5:06:16
	 * @参数说明：
	 * @返回类型：void
	 * 
	 */
	@Action("userLogin.login")
	public void login() throws Exception
	{
		String retFlag = "100"; // 允许登录

		try
		{
			boolean isCanLogin = true;
			String userName = super.getParameter("userName"); // 用户名
			String password = super.getParameter("password"); // 密码
			Map<String, Object> loginUserMap = this.loginService.seachLoginUserMap(userName, password);
			if (loginUserMap != null && loginUserMap.size() > 0)
			{
				// 是否允许登录
				boolean shiFouYunXuDengLu = DataSwitch.convertObjectToBoolean(loginUserMap.get("ShiFouYunXuDengLu"));
				if (!shiFouYunXuDengLu)
				{
					retFlag = "20";// 不允许登录
					isCanLogin = false;
				}
				int renYuanQuanXianCnt = DataSwitch.convertObjectToInteger(loginUserMap.get("ryqxcnt")); // 人员权限数量
				int jueSeQuanXianCnt = DataSwitch.convertObjectToInteger(loginUserMap.get("jsqxcnt")); // 所属角色权限数量
				if (isCanLogin && renYuanQuanXianCnt == 0 && jueSeQuanXianCnt == 0)
				{
					retFlag = "30";// 没有权限
					isCanLogin = false;
				}
			}
			else
			{
				retFlag = "10"; // 用户名后密码错误
				isCanLogin = false;
			}
			if (isCanLogin)
			{
				// 保存登录人员信息到session
				saveLoginUserInFoToSession(loginUserMap);
			}
		}
		catch (Exception e)
		{
			retFlag = "90";// 系统错误
			e.printStackTrace();
			throw e;
		}
		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("retFlag", retFlag);
		String jsonStr = DataSwitch.convertEntityToJson(retMap); // json字符串
		PublicMethod.writeToPage(jsonStr);
	}

	/**
	 * @功能简介：保存登录人员信息到session中
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月19日 上午9:36:02
	 * @参数说明：@param loginUserMap 人员信息map
	 * @返回类型：void
	 * 
	 */
	private void saveLoginUserInFoToSession(Map<String, Object> loginUserMap)
	{
		try
		{
			LoginUserInfoEntity loginUser = new LoginUserInfoEntity();
			loginUser.setXtyh_id(DataSwitch.convertObjectToString(loginUserMap.get("XTYH_ID"))); // 系统用户id
			loginUser.setRy_id(DataSwitch.convertObjectToString(loginUserMap.get("RY_ID"))); // 人员id
			loginUser.setShiFouIpBangDing(DataSwitch.convertObjectToBoolean(loginUserMap.get("ShiFouIPBangDing"))); // 是否ip绑定
			loginUser.setIp(DataSwitch.convertObjectToString(loginUserMap.get("IP"))); // ip地址
			loginUser.setNiCheng(DataSwitch.convertObjectToString(loginUserMap.get("XiTongNiCheng")));// 昵称
			loginUser.setXl_id(DataSwitch.convertObjectToString(loginUserMap.get("XL_ID"))); // 学历id
			loginUser.setRenYuanDaiMa(DataSwitch.convertObjectToString(loginUserMap.get("RenYuanDaiMa"))); // 人员代码
			loginUser.setXingMing(DataSwitch.convertObjectToString(loginUserMap.get("XingMing"))); // 姓名
			loginUser.setXingBie(DataSwitch.convertObjectToString(loginUserMap.get("XingBie"))); // 性别
			loginUser.setZhiGongHao(DataSwitch.convertObjectToString(loginUserMap.get("ZhiGongHao"))); // 职工号
			loginUser.setBanGongDianHua(DataSwitch.convertObjectToString(loginUserMap.get("BanGongDianHua"))); // 办公电话
			loginUser.setGeRenDianHua(DataSwitch.convertObjectToString(loginUserMap.get("GeRenDianHua"))); // 个人电话
			loginUser.setShenFenZhengHao(DataSwitch.convertObjectToString(loginUserMap.get("ShenFenZhengHao"))); // 身份证号
			loginUser.setShiFouZaiZhi(DataSwitch.convertObjectToString(loginUserMap.get("ShiFouZaiZhi"))); // 是否在职
			loginUser.setQq(DataSwitch.convertObjectToString(loginUserMap.get("QQ"))); // qq号码
			loginUser.setWeiXinHao(DataSwitch.convertObjectToString(loginUserMap.get("WeiXinHao"))); // 微信号
			loginUser.setYouJianDiZhi(DataSwitch.convertObjectToString(loginUserMap.get("YouJianDiZhi"))); // 邮件地址
			loginUser.setJiGouDaiMa(DataSwitch.convertObjectToString(loginUserMap.get("DiaMa"))); // 机构代码
			loginUser.setJiGouQuanCheng(DataSwitch.convertObjectToString(loginUserMap.get("QuanCheng"))); // 机构全称
			loginUser.setJiGouJianCheng(DataSwitch.convertObjectToString(loginUserMap.get("JianCheng"))); // 机构简称
			loginUser.setBuMenMingCheng(DataSwitch.convertObjectToString(loginUserMap.get("BuMenMingCheng"))); // 部门名称
			setSessionAttr("loginUserInfo", loginUser);

			// 上次登录时间
			String yongHuId = loginUser.getXtyh_id(); // 系统用户Id
			String shangCiDengLuShiJian = this.loginService.searchShangCiDengLuShiJian(yongHuId);
			setSessionAttr("shangCiDengLuShiJian", shangCiDengLuShiJian);
			// 用户的ip地址
			String loginUserIp = getIpAddress();
			setSessionAttr("loginUserIp", loginUserIp);
			// 保存登录日志
			TbDengLuRiZhi dengLuRiZhi = new TbDengLuRiZhi();
			dengLuRiZhi.setDengLuShiJian(new Date());
			dengLuRiZhi.setIp(loginUserIp);
			dengLuRiZhi.setDengLuYongHu(yongHuId);
			this.loginService.saveDengLuRiZhi(dengLuRiZhi);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @throws Exception
	 * @功能简介：初始化登录人员信息页面
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月19日 上午11:02:11
	 * @参数说明：@return
	 * @返回类型：String
	 * 
	 */
	@Action("userLogin.initLoginUserInfo")
	public String initLoginUserInfo() throws Exception
	{
		try
		{
			LoginUserInfoEntity loginUser = super.getLoginUserInfoEntity();
			loginUser.setNowJueSeId(null);
			loginUser.setNowJueSeMingCheng(null);
			String yongHuId = loginUser.getXtyh_id(); // 系统用户Id
			// 用户角色
			List<Map<String, Object>> userJueSeList = this.loginService.searchUserJueSeList(yongHuId);
			loginUser.setJueSeList(userJueSeList);
			setSessionAttr("loginUserInfo", loginUser);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return "initLoginUserInfo";
	}

	/**
	 * @功能简介：
	 * @应用页面：
	 * @throws Exception
	 * @作者姓名：强子
	 * @创建时间：2016年8月19日 下午2:50:15
	 * @参数说明：@return
	 * @返回类型：String
	 * 
	 */
	@Action("userLogin.loginOut")
	public String loginOut() throws Exception
	{
		try
		{
			LoginUserInfoEntity loginUser = super.getLoginUserInfoEntity();
			String yongHuId = loginUser.getXtyh_id(); // 系统用户Id
			this.loginService.updateLoginOutTime(yongHuId); // 修改用户退出系统时间
			getSession().invalidate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return "initLoginPage";
	}

	/**
	 * @throws Exception
	 * @功能简介：初始化系统主页
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月19日 下午4:52:04
	 * @参数说明：@return
	 * @返回类型：String
	 * 
	 */
	@Action("userLogin.initMain")
	public void initMain() throws Exception
	{
		try
		{
			String jueSeId = super.getParameter("jsid");// 角色Id
			String jueSeMingCheng = super.getParameter("jsmc");// 角色名称
			LoginUserInfoEntity loginUser = super.getLoginUserInfoEntity();
			loginUser.setNowJueSeId(jueSeId);
			loginUser.setNowJueSeMingCheng(jueSeMingCheng);
			setSessionAttr("loginUserInfo", loginUser);
			String yongHuId = loginUser.getXtyh_id(); // 系统用户Id
			// 用户模块
			List<Map<String, Object>> userMoKuai = (List<Map<String, Object>>) getSession().getAttribute("userMoKuai");
			// 用户菜单组
			List<Map<String, Object>> userCaiDanZu = (List<Map<String, Object>>) getSession().getAttribute("userCaiDanZu");
			// 用户菜单
			List<Map<String, Object>> userCaiDan = (List<Map<String, Object>>) getSession().getAttribute("userCaiDan");
			if (userMoKuai == null || userMoKuai.size() == 0)
			{
				userMoKuai = this.loginService.searchUserMoKuai(yongHuId, jueSeId);
				setSessionAttr("userMoKuai", userMoKuai);
				userCaiDanZu = this.loginService.searchUserCaiDanZu(yongHuId, jueSeId);
				setSessionAttr("userCaiDanZu", userCaiDanZu);
				userCaiDan = this.loginService.searchUserCaiDan(yongHuId, jueSeId);
				setSessionAttr("userCaiDan", userCaiDan);
			}

			// 点击角色进入系统或者点击模块页面跳转
			String moKuaiId = DataSwitch.convertObjectToString(userMoKuai.get(0).get("CDID"));
			String caiDanZuId = "";
			for (Map<String, Object> map : userCaiDanZu)
			{
				String tmpMkId = DataSwitch.convertObjectToString(map.get("PID"));
				if (tmpMkId.equals(moKuaiId))
				{
					caiDanZuId = DataSwitch.convertObjectToString(map.get("CDID"));
					break;
				}
			}
			String jieDianId = "";
			String jieDianUrl = "";

			for (Map<String, Object> map : userCaiDan)
			{
				String tmpCDZId = DataSwitch.convertObjectToString(map.get("PID"));
				if (tmpCDZId.equals(caiDanZuId))
				{
					jieDianId = DataSwitch.convertObjectToString(map.get("CDID"));
					jieDianUrl = DataSwitch.convertObjectToString(map.get("URL"));
					break;
				}
			}
			if (DataSwitch.isEmpty(jieDianUrl))
			{
				jieDianUrl="userLogin.initDefaultJdPage.action";
			}
			getResponse().sendRedirect(jieDianUrl + "?moKuaiId=" + moKuaiId + "&jieDianId=" + jieDianId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * @throws Exception 
	 * @功能简介：响应菜单跳转
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月19日 下午10:58:42
	 * @参数说明：
	 * @返回类型：void
	 * 
	 */
	@Action("userLogin.caiDanTiaoZhuan")
	public void caiDanTiaoZhuan() throws Exception
	{
		try
		{
			// 用户模块
			List<Map<String, Object>> userMoKuai = (List<Map<String, Object>>) getSession().getAttribute("userMoKuai");
			// 用户菜单组
			List<Map<String, Object>> userCaiDanZu = (List<Map<String, Object>>) getSession().getAttribute("userCaiDanZu");
			// 用户菜单
			List<Map<String, Object>> userCaiDan = (List<Map<String, Object>>) getSession().getAttribute("userCaiDan");
			// 点击角色进入系统或者点击模块页面跳转
			String moKuaiId = super.getMoKuaiId();
			String jieDianId = super.getJieDianId();
			String jieDianUrl = "";
			if (DataSwitch.isEmpty(jieDianId))
			{
				String caiDanZuId = "";
				for (Map<String, Object> map : userCaiDanZu)
				{
					String tmpMkId = DataSwitch.convertObjectToString(map.get("PID"));
					if (tmpMkId.equals(moKuaiId))
					{
						caiDanZuId = DataSwitch.convertObjectToString(map.get("CDID"));
						break;
					}
				}
				for (Map<String, Object> map : userCaiDan)
				{
					String tmpCDZId = DataSwitch.convertObjectToString(map.get("PID"));
					if (tmpCDZId.equals(caiDanZuId))
					{
						jieDianId = DataSwitch.convertObjectToString(map.get("CDID"));
						jieDianUrl = DataSwitch.convertObjectToString(map.get("URL"));
						break;
					}
				}
			}
			if (DataSwitch.isEmpty(jieDianUrl))
			{
				jieDianUrl="userLogin.initDefaultJdPage.action";
			}
			getResponse().sendRedirect(jieDianUrl + "?moKuaiId=" + moKuaiId + "&jieDianId=" + jieDianId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * @功能简介：初始化菜单节点默认页
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月19日 下午11:03:28
	 * @参数说明：@return
	 * @返回类型：String
	 *
	 */
	@Action("userLogin.initDefaultJdPage")
	public String initDefaultJdPage()
	{
		return "initDefaultJdPage";
	}
	
	/**
	 * @功能简介：初始化页面顶部 
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月20日 下午2:38:33
	 * @参数说明：@return
	 * @返回类型：String
	 *
	 */
	@Action("userLogin.initHeaderPage")
	public String initHeaderPage()
	{
		return "initHeaderPage";
	}
	
	/**
	 * @功能简介：初始化页面左部
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月20日 下午2:39:25
	 * @参数说明：@return
	 * @返回类型：String
	 *
	 */
	@Action("userLogin.initLeftPage")
	public String initLeftPage()
	{
		return "initLeftPage";
	}
	

}
