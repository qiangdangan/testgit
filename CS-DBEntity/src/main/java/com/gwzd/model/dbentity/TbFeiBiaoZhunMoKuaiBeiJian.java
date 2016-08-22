package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbFeiBiaoZhunMoKuaiBeiJian entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_FeiBiaoZhunMoKuaiBeiJian")
public class TbFeiBiaoZhunMoKuaiBeiJian implements java.io.Serializable
{

	// Fields

	private String fbzmkbjid;
	private String sbqtmkid;
	private String ckbjid;
	private Integer beiJianShuLiang;
	private Double shengMingZhouQi;
	private Double zongZhongLiang;
	private Double zongJiaGe;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbFeiBiaoZhunMoKuaiBeiJian()
	{}

	/** full constructor */
	public TbFeiBiaoZhunMoKuaiBeiJian(String sbqtmkid, String ckbjid, Integer beiJianShuLiang, Double shengMingZhouQi, Double zongZhongLiang, Double zongJiaGe,
			String beiZhu)
	{
		this.sbqtmkid = sbqtmkid;
		this.ckbjid = ckbjid;
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
	@Column(name = "FBZMKBJID", unique = true, nullable = false, length = 50)
	public String getFbzmkbjid()
	{
		return this.fbzmkbjid;
	}

	public void setFbzmkbjid(String fbzmkbjid)
	{
		this.fbzmkbjid = fbzmkbjid;
	}

	@Column(name = "SBQTMKID", length = 50)
	public String getSbqtmkid()
	{
		return this.sbqtmkid;
	}

	public void setSbqtmkid(String sbqtmkid)
	{
		this.sbqtmkid = sbqtmkid;
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