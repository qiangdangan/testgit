package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbDingDanMingXi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_DingDanMingXi")
public class TbDingDanMingXi implements java.io.Serializable
{

	// Fields

	private String ddmxid;
	private String ddxxid;
	private String cangKuId;
	private String bjid;

	// Constructors

	/** default constructor */
	public TbDingDanMingXi()
	{}

	/** full constructor */
	public TbDingDanMingXi(String ddxxid, String cangKuId, String bjid)
	{
		this.ddxxid = ddxxid;
		this.cangKuId = cangKuId;
		this.bjid = bjid;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "DDMXID", unique = true, nullable = false, length = 50)
	public String getDdmxid()
	{
		return this.ddmxid;
	}

	public void setDdmxid(String ddmxid)
	{
		this.ddmxid = ddmxid;
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

}