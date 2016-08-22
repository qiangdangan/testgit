package com.gwzd.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gwzd.model.dbentity.TDemo;
import com.gwzd.model.findentity.TestFindEntity;
import com.gwzd.servicedao.TestServiceDao;
import com.gwzd.util.Pager;

/**
 * @author qiangdangan
 * 
 */
@Service("testService")
public class TestService
{
	private TestServiceDao testServiceDao;

	@Resource
	public void setTestServiceDao(TestServiceDao testServiceDao)
	{
		this.testServiceDao = testServiceDao;
	}

	public List<Map<String, Object>> getDbDataList() throws Exception
	{
		try
		{
			return this.testServiceDao.getDbDataList();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @throws Exception
	 * @功能简介：分页查询
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月18日 上午10:35:33
	 * @参数说明：@param testFindEntity
	 * @参数说明：@return
	 * @返回类型：Pager
	 * 
	 */
	public Pager searchTest(TestFindEntity testFindEntity) throws Exception
	{
		try
		{
			return this.testServiceDao.searchTest(testFindEntity);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @throws Exception
	 * @功能简介：异步验证姓名是否存在
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月20日 下午4:56:16
	 * @参数说明：@param id
	 * @参数说明：@param username
	 * @参数说明：@return
	 * @返回类型：boolean
	 * 
	 */
	public boolean searchUserNameIsExist(String id, String username) throws Exception
	{
		try
		{
			return this.testServiceDao.searchUserNameIsExist(id, username);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @throws Exception
	 * @功能简介：保存demo
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月20日 下午5:03:23
	 * @参数说明：@param demo
	 * @参数说明：@return
	 * @返回类型：boolean
	 * 
	 */
	public boolean saveDemo(TDemo demo) throws Exception
	{
		try
		{
			return this.testServiceDao.addEntity(demo);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @throws Exception 
	 * @功能简介：修改Demo
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月20日 下午5:05:22
	 * @参数说明：@param demo
	 * @参数说明：@return
	 * @返回类型：boolean
	 *
	 */
	public boolean updateDemo(TDemo demo) throws Exception
	{
		try
		{
			return this.testServiceDao.mergeEntiy(demo);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @throws Exception 
	 * @功能简介：删除demo
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月20日 下午5:19:48
	 * @参数说明：@param ids
	 * @参数说明：@return
	 * @返回类型：boolean
	 *
	 */
	public boolean deleteDemo(String ids) throws Exception
	{
		try
		{
			return this.testServiceDao.deleteByPrimaryKey(TDemo.class, ids);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

}
