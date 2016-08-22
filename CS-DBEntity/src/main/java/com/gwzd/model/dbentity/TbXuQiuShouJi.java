package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbXuQiuShouJi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_XuQiuShouJi")
public class TbXuQiuShouJi implements java.io.Serializable
{

	// Fields

	private String xqsjid;
	private String cangKuId;
	private String bjid;
	private Integer xuQiuShuLiang;
	private String shenPiRen;
	private Timestamp shenPiShiJian;
	private String shenQingRen;
	private Timestamp shenQingShiJian;
	private Integer zhuangTai;
	private String beiZhu;
	private Integer laiYuanLeiXing;

	// Constructors

	/** default constructor */
	public TbXuQiuShouJi()
	{}

	/** full constructor */
	public TbXuQiuShouJi(String cangKuId, String bjid, Integer xuQiuShuLiang, String shenPiRen, Timestamp shenPiShiJian, String shenQingRen,
			Timestamp shenQingShiJian, Integer zhuangTai, String beiZhu, Integer laiYuanLeiXing)
	{
		this.cangKuId = cangKuId;
		this.bjid = bjid;
		this.xuQiuShuLiang = xuQiuShuLiang;
		this.shenPiRen = shenPiRen;
		this.shenPiShiJian = shenPiShiJian;
		this.shenQingRen = shenQingRen;
		this.shenQingShiJian = shenQingShiJian;
		this.zhuangTai = zhuangTai;
		this.beiZhu = beiZhu;
		this.laiYuanLeiXing = laiYuanLeiXing;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "XQSJID", unique = true, nullable = false, length = 50)
	public String getXqsjid()
	{
		return this.xqsjid;
	}

	public void setXqsjid(String xqsjid)
	{
		this.xqsjid = xqsjid;
	}

	@Column(name = "CangKuID", length = 50)
	public String getCangKuId()
	{
		return this.cangKuId;
	}

	public void setCangKuId(String cangKuId)
	{
		this.cangKuId = cangKuId;
	}

	@Column(name = "BJID", length = 50)
	public String getBjid()
	{
		return this.bjid;
	}

	public void setBjid(String bjid)
	{
		this.bjid = bjid;
	}

	@Column(name = "XuQiuShuLiang")
	public Integer getXuQiuShuLiang()
	{
		return this.xuQiuShuLiang;
	}

	public void setXuQiuShuLiang(Integer xuQiuShuLiang)
	{
		this.xuQiuShuLiang = xuQiuShuLiang;
	}

	@Column(name = "ShenPiRen", length = 50)
	public String getShenPiRen()
	{
		return this.shenPiRen;
	}

	public void setShenPiRen(String shenPiRen)
	{
		this.shenPiRen = shenPiRen;
	}

	@Column(name = "ShenPiShiJian", length = 19)
	public Timestamp getShenPiShiJian()
	{
		return this.shenPiShiJian;
	}

	public void setShenPiShiJian(Timestamp shenPiShiJian)
	{
		this.shenPiShiJian = shenPiShiJian;
	}

	@Column(name = "ShenQingRen", length = 50)
	public String getShenQingRen()
	{
		return this.shenQingRen;
	}

	public void setShenQingRen(String shenQingRen)
	{
		this.shenQingRen = shenQingRen;
	}

	@Column(name = "ShenQingShiJian", length = 19)
	public Timestamp getShenQingShiJian()
	{
		return this.shenQingShiJian;
	}

	public void setShenQingShiJian(Timestamp shenQingShiJian)
	{
		this.shenQingShiJian = shenQingShiJian;
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

	@Column(name = "BeiZhu", length = 1000)
	public String getBeiZhu()
	{
		return this.beiZhu;
	}

	public void setBeiZhu(String beiZhu)
	{
		this.beiZhu = beiZhu;
	}

	@Column(name = "LaiYuanLeiXing")
	public Integer getLaiYuanLeiXing()
	{
		return this.laiYuanLeiXing;
	}

	public void setLaiYuanLeiXing(Integer laiYuanLeiXing)
	{
		this.laiYuanLeiXing = laiYuanLeiXing;
	}

}