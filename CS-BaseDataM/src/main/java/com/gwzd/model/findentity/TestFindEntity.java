package com.gwzd.model.findentity;

import com.gwzd.model.findentity.basefindentity.BaseFindEntity;

/**
 * @文件名称: TestFindEntity.java
 * @包: com.gwzd.model.findentity
 * @版本：V1.0
 * @版权所有：北京国网中电自动化技术有限公司
 * 
 * @创建人：强子
 * @创建时间：2016年8月18日
 * @功能简介：查询实体
 * 
 */
public class TestFindEntity extends BaseFindEntity
{
	private String userName; // 姓名
	private String age; // 年龄
	private String sex; // 性别
	private String phone; // 手机

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getAge()
	{
		return age;
	}

	public void setAge(String age)
	{
		this.age = age;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}
}
