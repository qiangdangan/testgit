package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbYongHuQuanXian entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_YongHuQuanXian")
public class TbYongHuQuanXian implements java.io.Serializable
{

	// Fields

	private String yhqxId;
	private String qxId;
	private String xtyhId;

	// Constructors

	/** default constructor */
	public TbYongHuQuanXian()
	{}

	/** full constructor */
	public TbYongHuQuanXian(String qxId, String xtyhId)
	{
		this.qxId = qxId;
		this.xtyhId = xtyhId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "YHQX_ID", unique = true, nullable = false, length = 50)
	public String getYhqxId()
	{
		return this.yhqxId;
	}

	public void setYhqxId(String yhqxId)
	{
		this.yhqxId = yhqxId;
	}

	@Column(name = "QX_ID", length = 50)
	public String getQxId()
	{
		return this.qxId;
	}

	public void setQxId(String qxId)
	{
		this.qxId = qxId;
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