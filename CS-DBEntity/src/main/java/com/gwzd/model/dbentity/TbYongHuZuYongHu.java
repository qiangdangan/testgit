package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbYongHuZuYongHu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_YongHuZuYongHu")
public class TbYongHuZuYongHu implements java.io.Serializable
{

	// Fields

	private String yhzyhid;
	private String yhzid;
	private String xtyhId;

	// Constructors

	/** default constructor */
	public TbYongHuZuYongHu()
	{}

	/** full constructor */
	public TbYongHuZuYongHu(String yhzid, String xtyhId)
	{
		this.yhzid = yhzid;
		this.xtyhId = xtyhId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "YHZYHID", unique = true, nullable = false, length = 50)
	public String getYhzyhid()
	{
		return this.yhzyhid;
	}

	public void setYhzyhid(String yhzyhid)
	{
		this.yhzyhid = yhzyhid;
	}

	@Column(name = "YHZID", length = 50)
	public String getYhzid()
	{
		return this.yhzid;
	}

	public void setYhzid(String yhzid)
	{
		this.yhzid = yhzid;
	}

	@Column(name = "XTYH_ID", length = 50)
	public String getXtyhId()
	{
		return this.xtyhId;
	}

	public void setXtyhId(String xtyhId)
	{
		this.xtyhId = xtyhId;
	}

}