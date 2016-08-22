package com.gwzd.model.findentity.basefindentity;

import com.gwzd.model.enumeration.publicenum.ShiFouEnum;

/**
 * @文件名称: BaseFindEntity.java 
 * @包: com.gwzd.model.findentity.basefindentity 
 * @版本：V1.0  
 * @版权所有：北京国网中电自动化技术有限公司
 * 
 * @创建人：高洪涛
 * @创建时间：2014年10月20日
 * @功能简介：基础FindEntity类，记录分页排序等关键信息
 *
 */
public class BaseFindEntity
{
	private int page; // 当前页
	private int pageNumber; // 当前页
	private int rows; // 每页大小
	private String isFenYe = ShiFouEnum.SHI; // 是否分页
	private String sort; // 排序字段
	private String order; // 排序方式
	
	private int pageSize=0;//自定义封装分页控件  每页记录数
	private int pageNum=0;//自定义封装分页控件  当前页码
	//private int pageCount=0;//自定义封装分页控件  分页总计数
	//private int total=0;//自定义封装分页控件  数据总记录数

	private int tabIndex;//默认选中也签的索引
	private String comboParam;

	public String getComboParam()
	{
		return comboParam;
	}

	public void setComboParam(String comboParam)
	{
		this.comboParam = comboParam;
	}

	private String comboParamValue;// comBoxGird 查询参数ID

	public String getComboParamValue()
	{
		return comboParamValue;
	}

	public void setComboParamValue(String comboParamValue)
	{
		this.comboParamValue = comboParamValue;
	}

	/**
	 * @return the sort
	 */
	public String getSort()
	{
		return sort;
	}

	/**
	 * @param sort
	 *            the sort to set
	 */
	public void setSort(String sort)
	{
		this.sort = sort;
	}

	/**
	 * @return the order
	 */
	public String getOrder()
	{
		return order;
	}

	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(String order)
	{
		this.order = order;
	}

	public int getPage()
	{
		return page;
	}

	public void setPage(int page)
	{
		this.page = page;
	}

	public int getRows()
	{
		return rows;
	}

	public void setRows(int rows)
	{
		this.rows = rows;
	}

	public String getIsFenYe()
	{
		return isFenYe;
	}

	public void setIsFenYe(String isFenYe)
	{
		this.isFenYe = isFenYe;
	}

	/**
	 * @return the pageNumber
	 */
	public int getPageNumber()
	{
		return pageNumber;
	}

	/**
	 * @param pageNumber
	 *            the pageNumber to set
	 */
	public void setPageNumber(int pageNumber)
	{
		this.pageNumber = pageNumber;
	}

	/**
	 * @定义说明：
	 * @返回类型： the pageSize
	 */
	public int getPageSize()
	{
		return pageSize;
	}

	/**
	 * @定义说明：pageSize
	 * the pageSize to set
	 */
	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	/**
	 * @定义说明：
	 * @返回类型： the pageNum
	 */
	public int getPageNum()
	{
		return pageNum;
	}

	/**
	 * @定义说明：pageNum
	 * the pageNum to set
	 */
	public void setPageNum(int pageNum)
	{
		this.pageNum = pageNum;
	}

    public int getTabIndex()
    {
        return tabIndex;
    }

    public void setTabIndex(int tabIndex)
    {
        this.tabIndex = tabIndex;
    }

}
