package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbDingDanFuJian entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_DingDanFuJian")
public class TbDingDanFuJian implements java.io.Serializable
{

	// Fields

	private String ddfjid;
	private String ddxxid;
	private String fuJianYuanMingCheng;
	private String fuJianXinMingCheng;
	private String fuJianDiZhI;

	// Constructors

	/** default constructor */
	public TbDingDanFuJian()
	{}

	/** full constructor */
	public TbDingDanFuJian(String ddxxid, String fuJianYuanMingCheng, String fuJianXinMingCheng, String fuJianDiZhI)
	{
		this.ddxxid = ddxxid;
		this.fuJianYuanMingCheng = fuJianYuanMingCheng;
		this.fuJianXinMingCheng = fuJianXinMingCheng;
		this.fuJianDiZhI = fuJianDiZhI;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "DDFJID", unique = true, nullable = false, length = 50)
	public String getDdfjid()
	{
		return this.ddfjid;
	}

	public void setDdfjid(String ddfjid)
	{
		this.ddfjid = ddfjid;
	}

	@Column(name = "DDXXID", length = 50)
	public String getDdxxid()
	{
		return this.ddxxid;
	}

	public void setDdxxid(String ddxxid)
	{
		this.ddxxid = ddxxid;
	}

	@Column(name = "FuJianYuanMingCheng", length = 200)
	public String getFuJianYuanMingCheng()
	{
		return this.fuJianYuanMingCheng;
	}

	public void setFuJianYuanMingCheng(String fuJianYuanMingCheng)
	{
		this.fuJianYuanMingCheng = fuJianYuanMingCheng;
	}

	@Column(name = "FuJianXinMingCheng", length = 200)
	public String getFuJianXinMingCheng()
	{
		return this.fuJianXinMingCheng;
	}

	public void setFuJianXinMingCheng(String fuJianXinMingCheng)
	{
		this.fuJianXinMingCheng = fuJianXinMingCheng;
	}

	@Column(name = "FuJianDiZhI", length = 500)
	public String getFuJianDiZhI()
	{
		return this.fuJianDiZhI;
	}

	public void setFuJianDiZhI(String fuJianDiZhI)
	{
		this.fuJianDiZhI = fuJianDiZhI;
	}

}