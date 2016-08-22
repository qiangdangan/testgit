package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbZuiGaoXueLi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_ZuiGaoXueLi")
public class TbZuiGaoXueLi implements java.io.Serializable
{

	// Fields

	private String xlId;
	private String xueLiMingCheng;
	private Integer zhuangTai;
	private String tianJiaRen;
	private Timestamp tianJiaiShiJian;
	private String xiuGaiRen;
	private Timestamp xiuGaiShiJian;

	// Constructors

	/** default constructor */
	public TbZuiGaoXueLi()
	{}

	/** full constructor */
	public TbZuiGaoXueLi(String xueLiMingCheng, Integer zhuangTai, String tianJiaRen, Timestamp tianJiaiShiJian, String xiuGaiRen, Timestamp xiuGaiShiJian)
	{
		this.xueLiMingCheng = xueLiMingCheng;
		this.zhuangTai = zhuangTai;
		this.tianJiaRen = tianJiaRen;
		this.tianJiaiShiJian = tianJiaiShiJian;
		this.xiuGaiRen = xiuGaiRen;
		this.xiuGaiShiJian = xiuGaiShiJian;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "XL_ID", unique = true, nullable = false, length = 50)
	public String getXlId()
	{
		return this.xlId;
	}

	public void setXlId(String xlId)
	{
		this.xlId = xlId;
	}

	@Column(name = "XueLiMingCheng", length = 100)
	public String getXueLiMingCheng()
	{
		return this.xueLiMingCheng;
	}

	public void setXueLiMingCheng(String xueLiMingCheng)
	{
		this.xueLiMingCheng = xueLiMingCheng;
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

}