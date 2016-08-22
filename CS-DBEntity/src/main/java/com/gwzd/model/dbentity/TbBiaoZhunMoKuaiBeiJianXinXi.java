package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbBiaoZhunMoKuaiBeiJianXinXi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_BiaoZhunMoKuaiBeiJianXinXi")
public class TbBiaoZhunMoKuaiBeiJianXinXi implements java.io.Serializable
{

	// Fields

	private String bzmkbjid;
	private String ckbjid;
	private String bzmkid;
	private Integer beiJianShuLiang;
	private Double shengMingZhouQi;
	private Double zongZhongLiang;
	private Double zongJiaGe;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbBiaoZhunMoKuaiBeiJianXinXi()
	{}

	/** full constructor */
	public TbBiaoZhunMoKuaiBeiJianXinXi(String ckbjid, String bzmkid, Integer beiJianShuLiang, Double shengMingZhouQi, Double zongZhongLiang, Double zongJiaGe,
			String beiZhu)
	{
		this.ckbjid = ckbjid;
		this.bzmkid = bzmkid;
		this.beiJianShuLiang = beiJianShuLiang;
		this.shengMingZhouQi = shengMingZhouQi;
		this.zongZhongLiang = zongZhongLiang;
		this.zongJiaGe = zongJiaGe;
		this.beiZhu = beiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "BZMKBJID", unique = true, nullable = false, length = 50)
	public String getBzmkbjid()
	{
		return this.bzmkbjid;
	}

	public void setBzmkbjid(String bzmkbjid)
	{
		this.bzmkbjid = bzmkbjid;
	}

	@Column(name = "CKBJID", length = 50)
	public String getCkbjid()
	{
		return this.ckbjid;
	}

	public void setCkbjid(String ckbjid)
	{
		this.ckbjid = ckbjid;
	}

	@Column(name = "BZMKID", length = 50)
	public String getBzmkid()
	{
		return this.bzmkid;
	}

	public void setBzmkid(String bzmkid)
	{
		this.bzmkid = bzmkid;
	}

	@Column(name = "BeiJianShuLiang")
	public Integer getBeiJianShuLiang()
	{
		return this.beiJianShuLiang;
	}

	public void setBeiJianShuLiang(Integer beiJianShuLiang)
	{
		this.beiJianShuLiang = beiJianShuLiang;
	}

	@Column(name = "ShengMingZhouQi", precision = 5)
	public Double getShengMingZhouQi()
	{
		return this.shengMingZhouQi;
	}

	public void setShengMingZhouQi(Double shengMingZhouQi)
	{
		this.shengMingZhouQi = shengMingZhouQi;
	}

	@Column(name = "ZongZhongLiang", precision = 5)
	public Double getZongZhongLiang()
	{
		return this.zongZhongLiang;
	}

	public void setZongZhongLiang(Double zongZhongLiang)
	{
		this.zongZhongLiang = zongZhongLiang;
	}

	@Column(name = "ZongJiaGe", precision = 5)
	public Double getZongJiaGe()
	{
		return this.zongJiaGe;
	}

	public void setZongJiaGe(Double zongJiaGe)
	{
		this.zongJiaGe = zongJiaGe;
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