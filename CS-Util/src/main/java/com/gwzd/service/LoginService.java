package com.gwzd.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gwzd.model.dbentity.TbDengLuRiZhi;
import com.gwzd.servicedao.LoginServiceDao;
import com.gwzd.util.DateUtil;

/**
 * @文件名称: LoginService.java 
 * @包: com.gwzd.service 
 * @版本：V1.0  
 * @版权所有：北京国网中电自动化技术有限公司
 * 
 * @创建人：强子
 * @创建时间：2016年8月18日
 * @功能简介：用户登录事务管理
 *
 */
@Service("loginService")
public class LoginService
{
	private LoginServiceDao loginServiceDao;

	@Resource
	public void setLoginServiceDao(LoginServiceDao loginServiceDao)
	{
		this.loginServiceDao = loginServiceDao;
	}

	/**
	 * @throws Exception 
	 * @功能简介：查询用户名是否存在
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月18日 下午5:31:38
	 * @参数说明：@param userName 用户名
	 * @参数说明：@return
	 * @返回类型：boolean
	 *
	 */
	public boolean searchUserNameIsExist(String userName) throws Exception
	{
		try
		{
			return this.loginServiceDao.searchUserNameIsExist(userName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @throws Exception 
	 * @功能简介：查询登录用户信息
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月18日 下午5:44:28
	 * @参数说明：@param userName 用户名
	 * @参数说明：@param password 密码
	 * @参数说明：@return
	 * @返回类型：Map<String,Object>
	 *
	 */
	public Map<String, Object> seachLoginUserMap(String userName, String password) throws Exception
	{
		try
		{
			return this.loginServiceDao.seachLoginUserMap(userName, password);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @throws Exception 
	 * @功能简介：查询用户角色
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月19日 上午11:51:11
	 * @参数说明：@param yongHuId 用户iD
	 * @参数说明：@return
	 * @返回类型：List<Map<String,Object>>
	 *
	 */
	public List<Map<String, Object>> searchUserJueSeList(String yongHuId) throws Exception
	{
		try
		{
			return this.loginServiceDao.searchUserJueSeList(yongHuId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @throws Exception 
	 * @功能简介：查询用户模块
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月19日 下午2:28:21
	 * @参数说明：@param yongHuId
	 * @参数说明：@return
	 * @返回类型：List<Map<String,Object>>
	 *
	 */
	public List<Map<String, Object>> searchUserMoKuai(String yongHuId,String jueSeId) throws Exception
	{
		try
		{
			return this.loginServiceDao.searchUserMoKuai(yongHuId, jueSeId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @throws Exception 
	 * @功能简介：查询用户菜单组
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月19日 下午2:31:03
	 * @参数说明：@param yongHuId
	 * @参数说明：@return
	 * @返回类型：List<Map<String,Object>>
	 *
	 */
	public List<Map<String, Object>> searchUserCaiDanZu(String yongHuId, String jueSeId) throws Exception
	{
		try
		{
			return this.loginServiceDao.searchUserCaiDanZu(yongHuId, jueSeId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @throws Exception 
	 * @功能简介：查询用户菜单
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月19日 下午2:33:09
	 * @参数说明：@param yongHuId
	 * @参数说明：@return
	 * @返回类型：List<Map<String,Object>>
	 *
	 */
	public List<Map<String, Object>> searchUserCaiDan(String yongHuId, String jueSeId) throws Exception
	{
		try
		{
			return this.loginServiceDao.searchUserCaiDan(yongHuId, jueSeId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @return 
	 * @throws Exception 
	 * @功能简介：保存登录日志
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月19日 下午3:48:33
	 * @参数说明：@param dengLuRiZhi
	 * @返回类型：boolean
	 *
	 */
	public boolean saveDengLuRiZhi(TbDengLuRiZhi dengLuRiZhi) throws Exception
	{
		try
		{
			return this.loginServiceDao.addEntity(dengLuRiZhi);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @throws Exception 
	 * @功能简介：查询用户上次登录时间
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月19日 下午3:51:40
	 * @参数说明：@param yongHuId
	 * @参数说明：@return
	 * @返回类型：String
	 *
	 */
	public String searchShangCiDengLuShiJian(String yongHuId) throws Exception
	{
		try
		{
			return this.loginServiceDao.searchShangCiDengLuShiJian(yongHuId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @功能简介：
	 * @应用页面：
	 * @return 
	 * @throws Exception 
	 * @作者姓名：强子
	 * @创建时间：2016年8月19日 下午4:02:47
	 * @参数说明：@param yongHuId
	 * @返回类型：void
	 *
	 */
	public boolean updateLoginOutTime(String yongHuId) throws Exception
	{
		try
		{
			String dengLuRiZhiId=this.loginServiceDao.getDengLuRiZhiId(yongHuId); //登录日志Id
			return this.loginServiceDao.updateAllBySql(TbDengLuRiZhi.class, dengLuRiZhiId, "LiKaiShiJian", DateUtil.getCurrentDateStr());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

}
