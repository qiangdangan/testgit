package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbFaHuoBaoHanDingDan entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_FaHuoBaoHanDingDan")
public class TbFaHuoBaoHanDingDan implements java.io.Serializable
{

	// Fields

	private String mffhddid;
	private String ddxxid;
	private String fhdid;
	private String fhpcid;

	// Constructors

	/** default constructor */
	public TbFaHuoBaoHanDingDan()
	{}

	/** full constructor */
	public TbFaHuoBaoHanDingDan(String ddxxid, String fhdid, String fhpcid)
	{
		this.ddxxid = ddxxid;
		this.fhdid = fhdid;
		this.fhpcid = fhpcid;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "MFFHDDID", unique = true, nullable = false, length = 50)
	public String getMffhddid()
	{
		return this.mffhddid;
	}

	public void setMffhddid(String mffhddid)
	{
		this.mffhddid = mffhddid;
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

	@Column(name = "FHDID", length = 50)
	public String getFhdid()
	{
		return this.fhdid;
	}

	public void setFhdid(String fhdid)
	{
		this.fhdid = fhdid;
	}

	@Column(name = "FHPCID", length = 50)
	public String getFhpcid()
	{
		return this.fhpcid;
	}

	public void setFhpcid(String fhpcid)
	{
		this.fhpcid = fhpcid;
	}

}