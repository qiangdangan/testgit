package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbSheBeFeiBiaoZhunMoKuai entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_SheBeFeiBiaoZhunMoKuai")
public class TbSheBeFeiBiaoZhunMoKuai implements java.io.Serializable
{

	// Fields

	private String sbfbzmkid;
	private String sbjbxxid;
	private String fbzmkbjid;
	private Double shengMingZhouQi;
	private Integer moKuaiShuLiang;
	private Double zongZhongLiang;
	private Double zongJiaGe;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbSheBeFeiBiaoZhunMoKuai()
	{}

	/** full constructor */
	public TbSheBeFeiBiaoZhunMoKuai(String sbjbxxid, String fbzmkbjid, Double shengMingZhouQi, Integer moKuaiShuLiang, Double zongZhongLiang, Double zongJiaGe,
			String beiZhu)
	{
		this.sbjbxxid = sbjbxxid;
		this.fbzmkbjid = fbzmkbjid;
		this.shengMingZhouQi = shengMingZhouQi;
		this.moKuaiShuLiang = moKuaiShuLiang;
		this.zongZhongLiang = zongZhongLiang;
		this.zongJiaGe = zongJiaGe;
		this.beiZhu = beiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "SBFBZMKID", unique = true, nullable = false, length = 50)
	public String getSbfbzmkid()
	{
		return this.sbfbzmkid;
	}

	public void setSbfbzmkid(String sbfbzmkid)
	{
		this.sbfbzmkid = sbfbzmkid;
	}

	@Column(name = "SBJBXXID", length = 50)
	public String getSbjbxxid()
	{
		return this.sbjbxxid;
	}

	public void setSbjbxxid(String sbjbxxid)
	{
		this.sbjbxxid = sbjbxxid;
	}

	@Column(name = "FBZMKBJID", length = 50)
	public String getFbzmkbjid()
	{
		return this.fbzmkbjid;
	}

	public void setFbzmkbjid(String fbzmkbjid)
	{
		this.fbzmkbjid = fbzmkbjid;
	}

	@Column(name = "ShengMingZhouQi", precision = 9)
	public Double getShengMingZhouQi()
	{
		return this.shengMingZhouQi;
	}

	public void setShengMingZhouQi(Double shengMingZhouQi)
	{
		this.shengMingZhouQi = shengMingZhouQi;
	}

	@Column(name = "MoKuaiShuLiang")
	public Integer getMoKuaiShuLiang()
	{
		return this.moKuaiShuLiang;
	}

	public void setMoKuaiShuLiang(Integer moKuaiShuLiang)
	{
		this.moKuaiShuLiang = moKuaiShuLiang;
	}

	@Column(name = "ZongZhongLiang", precision = 9)
	public Double getZongZhongLiang()
	{
		return this.zongZhongLiang;
	}

	public void setZongZhongLiang(Double zongZhongLiang)
	{
		this.zongZhongLiang = zongZhongLiang;
	}

	@Column(name = "ZongJiaGe", precision = 9)
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