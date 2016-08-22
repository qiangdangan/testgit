package com.gwzd.util;

import java.io.Serializable;
import java.util.List;


/**
 * @文件名称: Pager.java 
 * @包: com.gwzd.gwzdapi 
 * @版本：V1.0  
 * @版权所有：北京国网中电自动化技术有限公司
 * 
 * @创建人：高洪涛
 * @创建时间：2014年10月16日
 * @功能简介：
 *
 */
public class Pager implements Serializable
{
	/**
	 * 
	 */
	public Pager()
	{

	}

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields pageNo : 页码
	 */
	private Integer pageNo;
	/**
	 * @Fields pageSize : 每页记录条数
	 */
	private Integer pageSize;
	/**
	 * @Fields total : 总记录数
	 */
	private Integer total;
	@SuppressWarnings("rawtypes")
	private List rows;

	
	public Integer getPageNo()
	{
		return pageNo;
	}

	// 从第几条开始
	public void setPageNo(Integer pageNo)
	{
		this.pageNo = pageNo;
	}

	public Integer getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(Integer pageSize)
	{
		this.pageSize = pageSize;
	}

	public Integer getTotal()
	{
		return total;
	}

	public void setTotal(Integer total)
	{
		this.total = total;
	}

	public List getRows()
	{
		return rows;
	}

	/**
	 * @功能简介：存放数据库中的数据，多行，每行为一个map对象
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月16日 下午5:41:15
	 * @param rows：
	 */
	public void setRows(List rows)
	{
		this.rows = rows;
	}
}
