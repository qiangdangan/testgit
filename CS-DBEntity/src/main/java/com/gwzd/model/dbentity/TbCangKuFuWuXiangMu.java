package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbCangKuFuWuXiangMu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_CangKuFuWuXiangMu")
public class TbCangKuFuWuXiangMu implements java.io.Serializable
{

	// Fields

	private String xmckid;
	private String xmid;
	private String cangKuId;

	// Constructors

	/** default constructor */
	public TbCangKuFuWuXiangMu()
	{}

	/** full constructor */
	public TbCangKuFuWuXiangMu(String xmid, String cangKuId)
	{
		this.xmid = xmid;
		this.cangKuId = cangKuId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "XMCKID", unique = true, nullable = false, length = 50)
	public String getXmckid()
	{
		return this.xmckid;
	}

	public void setXmckid(String xmckid)
	{
		this.xmckid = xmckid;
	}

	@Column(name = "XMID", length = 50)
	public String getXmid()
	{
		return this.xmid;
	}

	public void setXmid(String xmid)
	{
		this.xmid = xmid;
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

}