package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbHuiFangJiLu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_HuiFangJiLu")
public class TbHuiFangJiLu implements java.io.Serializable
{

	// Fields

	private String hfjlid;
	private String csxxid;
	private String huiFangRen;
	private Timestamp huiFangShiJian;
	private String huiFangManYiDu;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbHuiFangJiLu()
	{}

	/** full constructor */
	public TbHuiFangJiLu(String csxxid, String huiFangRen, Timestamp huiFangShiJian, String huiFangManYiDu, String beiZhu)
	{
		this.csxxid = csxxid;
		this.huiFangRen = huiFangRen;
		this.huiFangShiJian = huiFangShiJian;
		this.huiFangManYiDu = huiFangManYiDu;
		this.beiZhu = beiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "HFJLID", unique = true, nullable = false, length = 50)
	public String getHfjlid()
	{
		return this.hfjlid;
	}

	public void setHfjlid(String hfjlid)
	{
		this.hfjlid = hfjlid;
	}

	@Column(name = "CSXXID", length = 50)
	public String getCsxxid()
	{
		return this.csxxid;
	}

	public void setCsxxid(String csxxid)
	{
		this.csxxid = csxxid;
	}

	@Column(name = "HuiFangRen", length = 50)
	public String getHuiFangRen()
	{
		return this.huiFangRen;
	}

	public void setHuiFangRen(String huiFangRen)
	{
		this.huiFangRen = huiFangRen;
	}

	@Column(name = "HuiFangShiJian", length = 19)
	public Timestamp getHuiFangShiJian()
	{
		return this.huiFangShiJian;
	}

	public void setHuiFangShiJian(Timestamp huiFangShiJian)
	{
		this.huiFangShiJian = huiFangShiJian;
	}

	@Column(name = "HuiFangManYiDu", length = 200)
	public String getHuiFangManYiDu()
	{
		return this.huiFangManYiDu;
	}

	public void setHuiFangManYiDu(String huiFangManYiDu)
	{
		this.huiFangManYiDu = huiFangManYiDu;
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