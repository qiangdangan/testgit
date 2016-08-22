package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbChuShiXiaoXiJieShouRen entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_ChuShiXiaoXiJieShouRen")
public class TbChuShiXiaoXiJieShouRen implements java.io.Serializable
{

	// Fields

	private String csxxjsrid;
	private String csxxid;
	private String jsryid;
	private Integer xxydzt;

	// Constructors

	/** default constructor */
	public TbChuShiXiaoXiJieShouRen()
	{}

	/** full constructor */
	public TbChuShiXiaoXiJieShouRen(String csxxid, String jsryid, Integer xxydzt)
	{
		this.csxxid = csxxid;
		this.jsryid = jsryid;
		this.xxydzt = xxydzt;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CSXXJSRID", unique = true, nullable = false, length = 50)
	public String getCsxxjsrid()
	{
		return this.csxxjsrid;
	}

	public void setCsxxjsrid(String csxxjsrid)
	{
		this.csxxjsrid = csxxjsrid;
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

	@Column(name = "JSRYID", length = 50)
	public String getJsryid()
	{
		return this.jsryid;
	}

	public void setJsryid(String jsryid)
	{
		this.jsryid = jsryid;
	}

	@Column(name = "XXYDZT")
	public Integer getXxydzt()
	{
		return this.xxydzt;
	}

	public void setXxydzt(Integer xxydzt)
	{
		this.xxydzt = xxydzt;
	}

}