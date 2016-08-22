package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbZhiCheng entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_ZhiCheng")
public class TbZhiCheng implements java.io.Serializable
{

	// Fields

	private String zcId;
	private String zhiChengMingCheng;
	private Integer zhuangTai;
	private String tianJiaRen;
	private Timestamp tianJiaiShiJian;
	private String xiuGaiRen;
	private Timestamp xiuGaiShiJian;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbZhiCheng()
	{}

	/** full constructor */
	public TbZhiCheng(String zhiChengMingCheng, Integer zhuangTai, String tianJiaRen, Timestamp tianJiaiShiJian, String xiuGaiRen, Timestamp xiuGaiShiJian,
			String beiZhu)
	{
		this.zhiChengMingCheng = zhiChengMingCheng;
		this.zhuangTai = zhuangTai;
		this.tianJiaRen = tianJiaRen;
		this.tianJiaiShiJian = tianJiaiShiJian;
		this.xiuGaiRen = xiuGaiRen;
		this.xiuGaiShiJian = xiuGaiShiJian;
		this.beiZhu = beiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ZC_ID", unique = true, nullable = false, length = 50)
	public String getZcId()
	{
		return this.zcId;
	}

	public void setZcId(String zcId)
	{
		this.zcId = zcId;
	}

	@Column(name = "ZhiChengMingCheng", length = 100)
	public String getZhiChengMingCheng()
	{
		return this.zhiChengMingCheng;
	}

	public void setZhiChengMingCheng(String zhiChengMingCheng)
	{
		this.zhiChengMingCheng = zhiChengMingCheng;
	}

	@Column(name = "ZhuangTai")
	public Integer getZhuangTai()
	{
		return this.zhuangTai;
	}

	public void setZhuangTai(Integer zhuangTai)
	{
		this.zhuangTai = zhuangTai;
	}

	@Column(name = "TianJiaRen", length = 50)
	public String getTianJiaRen()
	{
		return this.tianJiaRen;
	}

	public void setTianJiaRen(String tianJiaRen)
	{
		this.tianJiaRen = tianJiaRen;
	}

	@Column(name = "TianJiaiShiJian", length = 19)
	public Timestamp getTianJiaiShiJian()
	{
		return this.tianJiaiShiJian;
	}

	public void setTianJiaiShiJian(Timestamp tianJiaiShiJian)
	{
		this.tianJiaiShiJian = tianJiaiShiJian;
	}

	@Column(name = "XiuGaiRen", length = 50)
	public String getXiuGaiRen()
	{
		return this.xiuGaiRen;
	}

	public void setXiuGaiRen(String xiuGaiRen)
	{
		this.xiuGaiRen = xiuGaiRen;
	}

	@Column(name = "XiuGaiShiJian", length = 19)
	public Timestamp getXiuGaiShiJian()
	{
		return this.xiuGaiShiJian;
	}

	public void setXiuGaiShiJian(Timestamp xiuGaiShiJian)
	{
		this.xiuGaiShiJian = xiuGaiShiJian;
	}

	@Column(name = "BeiZhu", length = 1000)
	public String getBeiZhu()
	{
		return this.beiZhu;
	}

	public void setBeiZhu(String beiZhu)
	{
		this.beiZhu = beiZhu;
	}

}