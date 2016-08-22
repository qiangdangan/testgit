package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbJiHuaHanGaiRenYuanGongZuoZhuanYeFanChou entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_JiHuaHanGaiRenYuanGongZuoZhuanYeFanChou")
public class TbJiHuaHanGaiRenYuanGongZuoZhuanYeFanChou implements java.io.Serializable
{

	// Fields

	private String jhhgrygzzyfcid;
	private String jhhgryid;
	private String zyid;

	// Constructors

	/** default constructor */
	public TbJiHuaHanGaiRenYuanGongZuoZhuanYeFanChou()
	{}

	/** full constructor */
	public TbJiHuaHanGaiRenYuanGongZuoZhuanYeFanChou(String jhhgryid, String zyid)
	{
		this.jhhgryid = jhhgryid;
		this.zyid = zyid;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "JHHGRYGZZYFCID", unique = true, nullable = false, length = 50)
	public String getJhhgrygzzyfcid()
	{
		return this.jhhgrygzzyfcid;
	}

	public void setJhhgrygzzyfcid(String jhhgrygzzyfcid)
	{
		this.jhhgrygzzyfcid = jhhgrygzzyfcid;
	}

	@Column(name = "JHHGRYID", length = 50)
	public String getJhhgryid()
	{
		return this.jhhgryid;
	}

	public void setJhhgryid(String jhhgryid)
	{
		this.jhhgryid = jhhgryid;
	}

	@Column(name = "ZYID", length = 50)
	public String getZyid()
	{
		return this.zyid;
	}

	public void setZyid(String zyid)
	{
		this.zyid = zyid;
	}

}