package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbYeMianYuanSu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_YeMianYuanSu")
public class TbYeMianYuanSu implements java.io.Serializable
{

	// Fields

	private String ymysid;
	private String yuanSuDaiMa;
	private String yuanSuMingCheng;
	private String yeMianSuoShu;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbYeMianYuanSu()
	{}

	/** full constructor */
	public TbYeMianYuanSu(String yuanSuDaiMa, String yuanSuMingCheng, String yeMianSuoShu, String beiZhu)
	{
		this.yuanSuDaiMa = yuanSuDaiMa;
		this.yuanSuMingCheng = yuanSuMingCheng;
		this.yeMianSuoShu = yeMianSuoShu;
		this.beiZhu = beiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "YMYSID", unique = true, nullable = false, length = 50)
	public String getYmysid()
	{
		return this.ymysid;
	}

	public void setYmysid(String ymysid)
	{
		this.ymysid = ymysid;
	}

	@Column(name = "YuanSuDaiMa", length = 100)
	public String getYuanSuDaiMa()
	{
		return this.yuanSuDaiMa;
	}

	public void setYuanSuDaiMa(String yuanSuDaiMa)
	{
		this.yuanSuDaiMa = yuanSuDaiMa;
	}

	@Column(name = "YuanSuMingCheng", length = 100)
	public String getYuanSuMingCheng()
	{
		return this.yuanSuMingCheng;
	}

	public void setYuanSuMingCheng(String yuanSuMingCheng)
	{
		this.yuanSuMingCheng = yuanSuMingCheng;
	}

	@Column(name = "YeMianSuoShu", length = 100)
	public String getYeMianSuoShu()
	{
		return this.yeMianSuoShu;
	}

	public void setYeMianSuoShu(String yeMianSuoShu)
	{
		this.yeMianSuoShu = yeMianSuoShu;
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