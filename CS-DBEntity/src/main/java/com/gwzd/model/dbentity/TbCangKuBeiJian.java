package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbCangKuBeiJian entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_CangKuBeiJian")
public class TbCangKuBeiJian implements java.io.Serializable
{

	// Fields

	private String ckbjid;
	private String cangKuId;
	private String bjid;
	private Integer yuJingXian;
	private String tianJiaRen;
	private Timestamp tianJiaShiJian;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbCangKuBeiJian()
	{}

	/** full constructor */
	public TbCangKuBeiJian(String cangKuId, String bjid, Integer yuJingXian, String tianJiaRen, Timestamp tianJiaShiJian, String beiZhu)
	{
		this.cangKuId = cangKuId;
		this.bjid = bjid;
		this.yuJingXian = yuJingXian;
		this.tianJiaRen = tianJiaRen;
		this.tianJiaShiJian = tianJiaShiJian;
		this.beiZhu = beiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CKBJID", unique = true, nullable = false, length = 50)
	public String getCkbjid()
	{
		return this.ckbjid;
	}

	public void setCkbjid(String ckbjid)
	{
		this.ckbjid = ckbjid;
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

	@Column(name = "YuJingXian")
	public Integer getYuJingXian()
	{
		return this.yuJingXian;
	}

	public void setYuJingXian(Integer yuJingXian)
	{
		this.yuJingXian = yuJingXian;
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

	@Column(name = "TianJiaShiJian", length = 19)
	public Timestamp getTianJiaShiJian()
	{
		return this.tianJiaShiJian;
	}

	public void setTianJiaShiJian(Timestamp tianJiaShiJian)
	{
		this.tianJiaShiJian = tianJiaShiJian;
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