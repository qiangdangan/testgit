package com.gwzd.servicedao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gwzd.model.findentity.TestFindEntity;
import com.gwzd.servicedao.basedao.BaseDBDao;
import com.gwzd.util.DataSwitch;
import com.gwzd.util.Pager;

/**
 * @author qiangdangan
 * 
 */
@Repository("testServicedao")
public class TestServiceDao extends BaseDBDao
{

	public List<Map<String, Object>> getDbDataList() throws Exception
	{
		StringBuilder sbSql = new StringBuilder();
		sbSql.append(" SELECT  ");
		sbSql.append("   id, ");
		sbSql.append("   username, ");
		sbSql.append("   age, ");
		sbSql.append("   CASE ");
		sbSql.append("     WHEN sex = 1  ");
		sbSql.append("     THEN '男'  ");
		sbSql.append("     ELSE '女'  ");
		sbSql.append("   END sex, ");
		sbSql.append("   phone  ");
		sbSql.append(" FROM ");
		sbSql.append("   t_demo  ");

		try
		{
			return super.getList(sbSql.toString(), null);
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
	 * @创建时间：2016年8月18日 上午10:36:13
	 * @参数说明：@param testFindEntity
	 * @参数说明：@return
	 * @返回类型：Pager
	 * 
	 */
	public Pager searchTest(TestFindEntity testFindEntity) throws Exception
	{
		StringBuilder sbSql = new StringBuilder();
		sbSql.append(" SELECT  ");
		sbSql.append("   id, ");
		sbSql.append("   username, ");
		sbSql.append("   age, ");
		sbSql.append("   CASE ");
		sbSql.append("     WHEN sex = 1  ");
		sbSql.append("     THEN '男'  ");
		sbSql.append("     ELSE '女'  ");
		sbSql.append("   END sex, ");
		sbSql.append("   phone  ");
		sbSql.append(" FROM ");
		sbSql.append("   t_demo  ");
		sbSql.append(" WHERE 1 = 1  ");
		Map<String, Object> parasMaps = new HashMap<String, Object>();
		String userName = testFindEntity.getUserName(); // 姓名
		if (!DataSwitch.isEmpty(userName))
		{
			sbSql.append("   AND username LIKE :userName  ");
			parasMaps.put("userName", "%" + userName + "%");
		}
		String age = testFindEntity.getAge(); // 年龄
		if (!DataSwitch.isEmpty(age))
		{
			sbSql.append("   AND age = :age  ");
			parasMaps.put("age", age);
		}
		String sex = testFindEntity.getSex(); // 性别
		if (!DataSwitch.isEmpty(sex))
		{
			sbSql.append("   AND sex = :sex  ");
			parasMaps.put("sex", sex);
		}
		String phone = testFindEntity.getPhone(); // 手机
		if (!DataSwitch.isEmpty(phone))
		{
			sbSql.append("   AND phone LIKE :phone  ");
			parasMaps.put("phone", "%" + phone + "%");
		}
		try
		{
			return super.getListBySQLQuery(sbSql.toString(), parasMaps, testFindEntity);
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
	 * @创建时间：2016年8月20日 下午4:56:43
	 * @参数说明：@param id
	 * @参数说明：@param username
	 * @参数说明：@return
	 * @返回类型：boolean
	 * 
	 */
	public boolean searchUserNameIsExist(String id, String username) throws Exception
	{
		StringBuilder sbSql = new StringBuilder();
		sbSql.append(" SELECT COUNT(1) ");
		sbSql.append(" FROM   t_demo ");
		sbSql.append(" WHERE  1 = 1 ");
		Map<String, Object> map = new HashMap<String, Object>();
		if (!DataSwitch.isEmpty(username))
		{
			sbSql.append("        AND username = :username ");
			map.put("username", username);
		}
		if (!DataSwitch.isEmpty(id))
		{
			sbSql.append("        AND id != :id ");
			map.put("id", id);
		}
		try
		{
			return super.getTotalCount(sbSql.toString(), map) > 0;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

}
