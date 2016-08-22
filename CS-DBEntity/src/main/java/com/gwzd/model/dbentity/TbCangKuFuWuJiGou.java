package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbCangKuFuWuJiGou entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_CangKuFuWuJiGou")
public class TbCangKuFuWuJiGou implements java.io.Serializable
{

	// Fields

	private String khckid;
	private String cangKuId;
	private String khxxid;

	// Constructors

	/** default constructor */
	public TbCangKuFuWuJiGou()
	{}

	/** full constructor */
	public TbCangKuFuWuJiGou(String cangKuId, String khxxid)
	{
		this.cangKuId = cangKuId;
		this.khxxid = khxxid;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "KHCKID", unique = true, nullable = false, length = 50)
	public String getKhckid()
	{
		return this.khckid;
	}

	public void setKhckid(String khckid)
	{
		this.khckid = khckid;
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

	@Column(name = "KHXXID", length = 50)
	public String getKhxxid()
	{
		return this.khxxid;
	}

	public void setKhxxid(String khxxid)
	{
		this.khxxid = khxxid;
	}

}