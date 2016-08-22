package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbSheBeiBiaoZhunMoKuai entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_SheBeiBiaoZhunMoKuai")
public class TbSheBeiBiaoZhunMoKuai implements java.io.Serializable
{

	// Fields

	private String sbbzmkid;
	private String sbjbxxid;
	private String bzmkid;
	private Double shengMingZhouQi;
	private Integer moKuaiShuLiang;
	private Double zongZhongLiang;
	private Double zongJiaGe;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbSheBeiBiaoZhunMoKuai()
	{}

	/** full constructor */
	public TbSheBeiBiaoZhunMoKuai(String sbjbxxid, String bzmkid, Double shengMingZhouQi, Integer moKuaiShuLiang, Double zongZhongLiang, Double zongJiaGe,
			String beiZhu)
	{
		this.sbjbxxid = sbjbxxid;
		this.bzmkid = bzmkid;
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
	@Column(name = "SBBZMKID", unique = true, nullable = false, length = 50)
	public String getSbbzmkid()
	{
		return this.sbbzmkid;
	}

	public void setSbbzmkid(String sbbzmkid)
	{
		this.sbbzmkid = sbbzmkid;
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

	@Column(name = "BZMKID", length = 50)
	public String getBzmkid()
	{
		return this.bzmkid;
	}

	public void setBzmkid(String bzmkid)
	{
		this.bzmkid = bzmkid;
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